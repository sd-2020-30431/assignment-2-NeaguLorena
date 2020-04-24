import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Grocerylist} from "../model/grocerylist";
import {Observable} from "rxjs/Observable";

@Injectable()
export class GrocerylistService {

  private grocerylistURL : string;

  constructor(private http: HttpClient) {
    this.grocerylistURL = 'http://localhost:8080/groceryLists-user';}

  public findAll(): Observable<Grocerylist[]> {
    return this.http.get<Grocerylist[]>(this.grocerylistURL);
  }

  public save(groceryList: Grocerylist) {
    return this.http.post<Grocerylist>(this.grocerylistURL, groceryList);
  }
}
