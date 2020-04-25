import {Component, OnInit} from '@angular/core';
import {Report} from "../../model/report";
import {ActivatedRoute} from "@angular/router";
import {ReportService} from "../../service/report.service";

@Component({
  selector: 'app-report',
  templateUrl: './report.component.html',
  styleUrls: ['./report.component.css']
})
export class ReportComponent implements OnInit {

  private report: Report;
  private reportType: string;
  private type : string;

  constructor(private route: ActivatedRoute,
              private reportService: ReportService) {
  }

  ngOnInit() {
    this.route.queryParams.subscribe(params => {
      this.reportType = params['type'];
    });
    this.reportService.getReport(this.reportType).subscribe(report => {
      this.report = report;
    });
    this.type = this.reportType === 'weekly'? 'week':'month';
  }

}
