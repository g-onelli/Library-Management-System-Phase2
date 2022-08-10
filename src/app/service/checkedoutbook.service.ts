import { BehaviorSubject, Observable } from 'rxjs';
import { CheckedOutBook } from './../model/checkedoutbook.model';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CheckedoutbookService {

  checkedOutBook$ = new BehaviorSubject<CheckedOutBook[]>([]);

  getCheckedOutBooksApi = "http://localhost:8080/checkedoutbook"
  getCheckedOutBooksByIdApi = "http://localhost:8080/checkedoutbook/patron/"
  postCheckedOutBooksApi = "http://localhost:8080/checkoutbook/"
  deleteCheckedOutBooksApi = "http://localhost:8080/checkedoutbook/"

  constructor(private http: HttpClient) { }

  fetchCheckedOutBooks(): Observable<CheckedOutBook[]> {
    let encodedCredentials= localStorage.getItem('credentials');
    let httpOptions = {
      headers: new HttpHeaders({
        'Content-type': 'application/json',
        'Authorization': 'basic ' + encodedCredentials
      })
    };

    return this.http.get<CheckedOutBook[]>(this.getCheckedOutBooksApi, httpOptions);

  }

  fetchCheckedOutBooksById(id : number): Observable<CheckedOutBook[]> {
    let encodedCredentials= localStorage.getItem('credentials');
    let httpOptions = {
      headers: new HttpHeaders({
        'Content-type': 'application/json',
        'Authorization': 'basic ' + encodedCredentials
      })
    };

    return this.http.get<CheckedOutBook[]>(this.getCheckedOutBooksByIdApi + id, httpOptions);

  }

  postCheckedOutBook(pId: number, bId: number): Observable<any> {
    let encodedCredentials= localStorage.getItem('credentials');
    let httpOptions = {
      headers: new HttpHeaders({
        'Content-type': 'application/json',
        'Authorization': 'basic ' + encodedCredentials
      })
    };

    return this.http.post<any>(this.postCheckedOutBooksApi + pId + '/' + bId, null, httpOptions);
    

  }

  deleteCheckedOutBook(id: number): Observable<any> {
    let encodedCredentials= localStorage.getItem('credentials');
    let httpOptions = {
      headers: new HttpHeaders({
        'Content-type': 'application/json',
        'Authorization': 'basic ' + encodedCredentials
      })
    };

    return this.http.delete<any>(this.deleteCheckedOutBooksApi + id, httpOptions)
  }



}
