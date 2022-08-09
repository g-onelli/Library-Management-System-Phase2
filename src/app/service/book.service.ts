import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Book } from '../model/book.model';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  getBooksApi="http://localhost:8080/book"
  constructor(private http:HttpClient) { }

  fetchAllBooks() : Observable<Book[]>{
    return this.http.get<Book[]>(this.getBooksApi);
}

}
