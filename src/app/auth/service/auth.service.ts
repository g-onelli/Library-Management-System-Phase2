import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { User } from '../model/user.model';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  username: string;
  username$ = new BehaviorSubject<string>('');
  message$ = new BehaviorSubject<string>('');
  loginApi:string;
  constructor(private http: HttpClient) {
    this.username='';
    this.loginApi='http://localhost:8080/login';
   }
  isLoggedIn(): boolean{
    //check if the user is logged in or not
    this.username = localStorage.getItem('username');
    if(this.username==null)
      return false;
    return true;
  }
  login(username: string, password: string): Observable<User> {
    //call login api from here
    let encodedCredentials= btoa(username + ":" + password);
    let httpOptions = {
      headers: new HttpHeaders({
        'Content-type': 'application/json',
        'Authorization': 'basic ' + encodedCredentials
      })
    };
    return this.http.get<User>(this.loginApi, httpOptions)
  }
}
