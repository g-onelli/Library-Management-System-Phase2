import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { ProfilePatron } from 'src/app/model/patron.model';
import { environment } from 'src/environments/environment';
import { PatronSignupDto, User, UserResetDto } from '../model/user.model';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  username: string;
  username$ = new BehaviorSubject<string>('');
  message$ = new BehaviorSubject<string>('');
  user$ = new BehaviorSubject<string>(''); 
  loginApi:string;
  roleApi: string;
  signUpApi: string;
  profileApi: string;
  roleAs: string;
  getUserSecurityInfoApi: string;
  securityAnswerValidationApi:string;
  passwordResetAPi: string;
  usernameApi: string;

  constructor(private http: HttpClient) {
    this.username='';
    this.loginApi=environment.serverUrl +'/login';
    this.signUpApi=environment.serverUrl +'/signup';
    this.roleApi= environment.serverUrl +'/role';
    this.profileApi= environment.serverUrl +'/profile';
    this.usernameApi= environment.serverUrl +'/patron/username';
    this.getUserSecurityInfoApi=environment.serverUrl + '/user/security/info/';
    this.securityAnswerValidationApi=environment.serverUrl + '/validate-security-answer/';
    this.passwordResetAPi=environment.serverUrl +'/user/reset-password/';
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
    return this.http.get<User>(this.loginApi, httpOptions);
  }
  signUp(patronSignupDto: PatronSignupDto):Observable<any> {
    return this.http.post(this.signUpApi, patronSignupDto);
  }
  getRole():Observable<User> {
    let encodedCredentials= localStorage.getItem('credentials');
    let httpOptions = {
      headers: new HttpHeaders({
        'Content-type': 'application/json',
        'Authorization': 'basic ' + encodedCredentials
      })
    };
    return this.http.get<User>(this.roleApi, httpOptions);
  }
  getUserByUsername(credentials: string) : Observable<ProfilePatron>{
    let httpOptions={
      headers : new HttpHeaders({
        'Content-type': 'application/json',
        'Authorization' : 'basic ' + credentials
      })
    };
    return this.http.get<ProfilePatron>(this.usernameApi,httpOptions);
  }
  editProfile(patronProfileDto: ProfilePatron) :Observable<ProfilePatron>{
    let httpOptions={
      headers : new HttpHeaders({
        'Content-type': 'application/json',
        'Authorization' : 'basic ' + localStorage.getItem('credentials')
      })
    };
    return this.http.put<ProfilePatron>(this.profileApi,patronProfileDto,httpOptions);
  }
  getUserSecurityDetailsByUsername(username: string): Observable<UserResetDto> {
    return this.http.get<UserResetDto>(this.getUserSecurityInfoApi + username);
  }
  validateSecurityAnswer(username:string, answer: string): Observable<boolean> {
    let encodedText = btoa(username + '--'+answer);
    return this.http.get<boolean>(this.securityAnswerValidationApi + encodedText);
  }
  resetPassword(username: string, password: string):Observable<any> {
    let encodedText= btoa(username + '--'+password);
     return this.http.put(this.passwordResetAPi + encodedText,{});
 }

}
