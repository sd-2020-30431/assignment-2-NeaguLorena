import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Goal} from "../model/goal";

@Injectable()
export class GoalService {

  private goalURL: string;
  private reminderUrl: string;

  constructor(private http: HttpClient) {
    this.goalURL = 'http://localhost:8080/goal';
    this.reminderUrl = 'http://localhost:8080/reminder';
  }

  public save(goal: Goal) {
    return this.http.post<Goal>(this.goalURL, goal);
  }

  public findAll(): Observable<Goal[]> {
    return this.http.get<Goal[]>(this.goalURL);
  }

  public getReminder() {
    return this.http.get<String>(this.reminderUrl);
  }
}
