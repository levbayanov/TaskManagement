package ru.LevBayanov.TaskManagement.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.LevBayanov.TaskManagement.entity.ReportEntity;
import ru.LevBayanov.TaskManagement.entity.TaskEntity;
import ru.LevBayanov.TaskManagement.repository.ReportRepository;
import ru.LevBayanov.TaskManagement.repository.TaskRepository;
import ru.LevBayanov.TaskManagement.repository.UserRepository;
import ru.LevBayanov.TaskManagement.utility.ReportStatus;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
public class ReportServiceImpl
{
    private final ReportRepository reportRepository;
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    public ReportServiceImpl(ReportRepository reportRepository, TaskRepository taskRepository, UserRepository userRepository) {
        this.reportRepository = reportRepository;
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    public ReportEntity getReport(Long id)
    {
        return reportRepository.findById(id).orElseThrow();
    }

    @Transactional
    public void upReport(ReportEntity report)
    {
        ReportEntity newReport = new ReportEntity();
        newReport.setStatus(report.getStatus());
        newReport.setContent(report.getContent());
        newReport.setCountUsers(report.getCountUsers());
        newReport.setTimeToCountTask(report.getTimeToCountTask());
        newReport.setTimeToCountUser(report.getTimeToCountUser());
        newReport.setTimeToCreatedReport(report.getTimeToCreatedReport());

        reportRepository.delete(report);
        reportRepository.save(newReport);
    }

    public Long createReport()
    {
        ReportEntity report = new ReportEntity();
        report.setStatus(ReportStatus.CREATED);
        reportRepository.save(report);
        return report.getId();
    }

    public ReportEntity generateReport(Long id) {
        CompletableFuture<ReportEntity> future = CompletableFuture.supplyAsync(() -> {
            long timeGenerateStart = System.currentTimeMillis();
            ReportEntity report = getReport(id);
            List<TaskEntity> tasks = (List<TaskEntity>) taskRepository.findAll();


            Thread t1 = new Thread(() -> {
                long timeStart = System.currentTimeMillis();
                String content = tasks.stream().map(TaskEntity::getName).
                        collect(Collectors.joining("\n"));
                report.setContent(content);
                report.setTimeToCountTask(System.currentTimeMillis() - timeStart);
            });


            Thread t2 = new Thread(() -> {
                long timeStart = System.currentTimeMillis();
                Long countUser = userRepository.count();
                report.setCountUsers(countUser);
                report.setTimeToCountUser(System.currentTimeMillis() - timeStart);

            });

            t2.start();
            t1.start();

            try {
                t1.join();
                t2.join();
                report.setTimeToCreatedReport(System.currentTimeMillis() - timeGenerateStart);
                report.setStatus(ReportStatus.COMPLETED);
            } catch (InterruptedException e) {
                report.setStatus(ReportStatus.ERROR);
                throw new RuntimeException(e);
            } finally {
                upReport(report);
            }
            return report;
        });
        return future.resultNow();
    }

}
