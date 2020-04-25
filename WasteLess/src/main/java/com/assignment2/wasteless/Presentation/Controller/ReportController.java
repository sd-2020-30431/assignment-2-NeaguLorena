package com.assignment2.wasteless.Presentation.Controller;

import com.assignment2.wasteless.Bussiness.Service.UserService;
import com.assignment2.wasteless.Data.Repository.ReportGeneratorRepository;
import com.assignment2.wasteless.Presentation.Model.Report;
import com.assignment2.wasteless.Presentation.Model.ReportType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@CrossOrigin("*")
public class ReportController {

    @Autowired
    private ReportGeneratorRepository reportGeneratorRepository;

    @RequestMapping("reportGenerate")
    public Report generateReport(@RequestParam(value = "type", required = false) String type) {
        ReportType reportType = ReportType.valueOf(type.toUpperCase());
        return reportGeneratorRepository.getReport(reportType, UserService.getLoggedUser().getUsername());
    }
}
