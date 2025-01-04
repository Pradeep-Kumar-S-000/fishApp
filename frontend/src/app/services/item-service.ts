import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http"
import { Item } from "../entities/item";
import { Observable } from "rxjs";

@Injectable({
    providedIn: 'root'
})
export class ItemService {
    private baseUrl = 'http://localhost:8080/fishApp/items';
    private postItemApiUrl = this.baseUrl + '/addItem';
    constructor(private http: HttpClient) {}

    postItem(item: Item) : Observable<any> {
        return this.http.post(this.postItemApiUrl, item);
    }


}