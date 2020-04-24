package com.assignment2.wasteless.Factory;

import com.assignment2.wasteless.Presentation.Model.MonthlyReport;
import com.assignment2.wasteless.Presentation.Model.ReportGenerator;
import com.assignment2.wasteless.Presentation.Model.ReportType;

public class MonthlyReportFactory extends ReportFactory {

    @Override
    public ReportGenerator getReport(ReportType reportType) {
        return new MonthlyReport();
    }
}