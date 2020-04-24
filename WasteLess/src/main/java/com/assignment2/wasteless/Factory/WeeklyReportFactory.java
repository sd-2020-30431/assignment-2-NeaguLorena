package com.assignment2.wasteless.Factory;

import com.assignment2.wasteless.Presentation.Model.ReportGenerator;
import com.assignment2.wasteless.Presentation.Model.ReportType;
import com.assignment2.wasteless.Presentation.Model.WeeklyReport;

public class WeeklyReportFactory extends ReportFactory {

    @Override
    public ReportGenerator getReport(ReportType reportType) {
        return new WeeklyReport();
    }
}
