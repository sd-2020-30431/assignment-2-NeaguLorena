import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {Observable} from "rxjs";
import {Report} from "../model/report";

@Injectable()
export class ReportService {

  private reportURL: string;

  constructor(private http: HttpClient) {
    this.reportURL = "http://localhost:8080/reportGenerate";
  }

  public getReport(type: string): Observable<Report> {
    const params = new HttpParams().set('type', type);
    return this.http.get<Report>(this.reportURL, {params});
  }
}
