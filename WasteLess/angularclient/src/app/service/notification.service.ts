import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Grocerylistitem} from "../model/grocerylistitem";

@Injectable()
export class NotificationService {

  private notificationUrl: string;
  private itemsToExpireUrl: string;

  constructor(private http: HttpClient) {
    this.notificationUrl = 'http://localhost:8080/notificationMessage';
    this.itemsToExpireUrl = 'http://localhost:8080/itemsToExpire';
  }

  public getItemsAboutToExpire(): Observable<Grocerylistitem[]> {
    return this.http.get<Grocerylistitem[]>(this.itemsToExpireUrl);
  }

  public getExpirationNotification() : Observable<any>{
    return this.http.get<String>(this.notificationUrl, {responseType: 'text' as 'json'});
  }
}
