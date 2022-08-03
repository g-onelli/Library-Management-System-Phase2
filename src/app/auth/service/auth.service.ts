import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { PatronEditDto, PatronSignupDto, User } from '../model/user.model';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  username: string;
  username$ = new BehaviorSubject<string>('');
  message$ = new BehaviorSubject<string>('');
  loginApi:string;
  editApi: string;
  signUpApi: string;
  constructor(private http: HttpClient) {
    this.username='';
    this.loginApi='http://localhost:8080/login';
    this.editApi='http://localhost:8080/user/profile';
    this.signUpApi='http://localhost:8080/signup';
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
  signUp(patronSignupDto: PatronSignupDto):Observable<any> {
    return this.http.post(this.signUpApi, patronSignupDto);
  }
  /* editPatron(patronEditDto: PatronEditDto) :Observable<PatronEditDto>{
    let httpOptions={
      headers : new HttpHeaders({
        'Content-type': 'application/json',
        'Authorization' : 'basic '
      })
    };
    return this.http.put<PatronEditDto>(this.editApi,patronEditDto,httpOptions);
  } */
}
