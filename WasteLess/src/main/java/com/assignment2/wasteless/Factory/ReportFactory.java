package com.assignment2.wasteless.Factory;

import com.assignment2.wasteless.Presentation.Model.ReportGenerator;
import com.assignment2.wasteless.Presentation.Model.ReportType;

public abstract class ReportFactory {

    public abstract ReportGenerator getReport(ReportType reportType);
}
