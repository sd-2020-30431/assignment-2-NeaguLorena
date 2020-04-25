import {Injectable} from '@angular/core';
import {Grocerylistitem} from "../model/grocerylistitem";
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {Grocerylist} from "../model/grocerylist";

@Injectable()
export class GrocerylistitemService {

  grocerylistitemsUrl: string;
  groceryItemDeleteUrl: string;

  constructor(private http: HttpClient) {
    this.grocerylistitemsUrl = 'http://localhost:8080/groceryLists-user';
    this.groceryItemDeleteUrl = 'http://localhost:8080/delete'
  }

  public findAllByListId(listId: string): Observable<Grocerylistitem[]> {
    return this.http.get<Grocerylistitem[]>(`${this.grocerylistitemsUrl}/${listId}`);
  }

  public save(grocerylistitem: Grocerylistitem, listId: string) {
    return this.http.post<Grocerylistitem>(`${this.grocerylistitemsUrl}/${listId}`, grocerylistitem);
  }

  public deleteItem(grocerylistitem: Grocerylistitem) {
    return this.http.delete<Grocerylistitem>(`${this.groceryItemDeleteUrl}/${grocerylistitem.listId}/${grocerylistitem.itemId}`);
  }

  //update
}
