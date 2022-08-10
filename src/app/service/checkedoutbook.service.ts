import { BehaviorSubject, Observable } from 'rxjs';
import { CheckedOutBook } from './../model/checkedoutbook.model';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CheckedoutbookService {

  checkedOutBook$ = new BehaviorSubject<CheckedOutBook[]>([]);

  getCheckedOutBooksApi = "http://localhost:8080/checkedoutbook"
  postCheckedOutBooksApi = "http://localhost:8080/checkoutbook/"
  deleteCheckedOutBooksApi = "http://localhost:8080/checkedoutbook/"
  constructor(private http: HttpClient) { }

  fetchCheckedOutBooks(): Observable<CheckedOutBook[]> {
    return this.http.get<CheckedOutBook[]>(this.getCheckedOutBooksApi);

  }

  postCheckedOutBook(pId: number, bId: number): Observable<any> {
    return this.http.post<any>(this.postCheckedOutBooksApi + pId + '/' + bId, null);
    

  }

  deleteCheckedOutBook(id: number): Observable<any> {
    return this.http.delete<any>(this.deleteCheckedOutBooksApi + id)
  }



}
