package ru.LevBayanov.TaskManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.LevBayanov.TaskManagement.entity.ReportEntity;
import ru.LevBayanov.TaskManagement.service.ReportServiceImpl;

@Controller
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private ReportServiceImpl reportService; // ваш сервис для работы с отчетами

    @GetMapping("{id}")
    public String getReportContent(@PathVariable Long id, Model model) {
        ReportEntity report = reportService.getReport(id); // Получаем отчет по ID
        model.addAttribute("report", report); // Добавляем отчет в модель
        return "report";
    }
}
