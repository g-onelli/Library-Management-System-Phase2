import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Book } from '../model/book.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AvailableBooksService {

  getAvailableBooksApi="http://localhost:8080/book/available"

  constructor(private http:HttpClient) { }

  
  fetchAvailableBooks() : Observable<Book[]>{
    return this.http.get<Book[]>(this.getAvailableBooksApi)
  }
}
