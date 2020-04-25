import {Injectable} from '@angular/core';
import {Grocerylistitem} from "../model/grocerylistitem";
import {Observable} from "rxjs";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Grocerylist} from "../model/grocerylist";

@Injectable()
export class GrocerylistitemService {

  grocerylistitemsUrl: string;
  groceryItemDeleteUrl: string;
  groceryItemUpdateUrl: string;
  private httpOptions = {
    headers: new HttpHeaders({'Content-Type': 'application/json'})
  };

  constructor(private http: HttpClient) {
    this.grocerylistitemsUrl = 'http://localhost:8080/groceryLists-user';
    this.groceryItemDeleteUrl = 'http://localhost:8080/delete';
    this.groceryItemUpdateUrl = 'http://localhost:8080/consume';
  }

  public findAllByListId(listId: string): Observable<Grocerylistitem[]> {
    return this.http.get<Grocerylistitem[]>(`${this.grocerylistitemsUrl}/${listId}`);
  }

  public save(grocerylistitem: Grocerylistitem, listId: string) {
    return this.http.post<Grocerylistitem>(`${this.grocerylistitemsUrl}/${listId}`, grocerylistitem);
  }

  public deleteItem(itemId : number) : Observable<Grocerylistitem>{
    return this.http.delete<Grocerylistitem>(`${this.groceryItemDeleteUrl}/${itemId}`, this.httpOptions);
  }

  public consumeItem(item : Grocerylistitem) :Observable<Grocerylistitem>{
    return this.http.post<Grocerylistitem>(`${this.groceryItemUpdateUrl}/${item.itemId}`, item);
  }
}
