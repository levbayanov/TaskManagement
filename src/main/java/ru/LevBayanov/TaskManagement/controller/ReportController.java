package ru.LevBayanov.TaskManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.LevBayanov.TaskManagement.entity.ReportEntity;
import ru.LevBayanov.TaskManagement.service.ReportServiceImpl;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Controller
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private ReportServiceImpl reportService;

    @GetMapping("/{id}")
    public String getReportContent(@PathVariable Long id, Model model) {
        ReportEntity report = reportService.getReport(id);
        model.addAttribute("report", report);
        return "report";
    }

    @GetMapping("/create")
    public String createdReport(Model model)
    {
        Long id = reportService.createReport();
        CompletableFuture<ReportEntity> future = reportService.generateReport(id);
        try {
            future.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new IllegalStateException(e);
        }
        return "redirect:/report/"+id;
    }

}
