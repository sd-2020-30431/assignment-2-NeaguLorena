package com.assignment2.wasteless.Factory;

import com.assignment2.wasteless.Presentation.Model.ReportType;

public class ReportFactoryProducer {
    public  ReportFactory getFactory(ReportType report){
        if(report == ReportType.WEEKLY)
            return new WeeklyReportFactory();
        else if(report == ReportType.MONTHLY){
            return new MonthlyReportFactory();
        }
        return null;
    }
}
