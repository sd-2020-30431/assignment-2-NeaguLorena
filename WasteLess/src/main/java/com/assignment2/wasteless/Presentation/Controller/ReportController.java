package com.assignment2.wasteless.Presentation.Controller;

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
@CrossOrigin(origins = "http://localhost:4200")
public class ReportController {

    @Autowired
    private ReportGeneratorRepository reportGeneratorRepository;

    @RequestMapping("/groceryLists-user/reportGenerate")
    public Report generateReport(@RequestParam(value = "type", required = false) String type, Principal principal) {
        ReportType reportType = ReportType.valueOf(type.toUpperCase());
//        model.addAttribute("report", reportGeneratorRepository.getReport(reportType, principal.getName()));
        return reportGeneratorRepository.getReport(reportType, principal.getName());
//        return "report-view";
    }


}
