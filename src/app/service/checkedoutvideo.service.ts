import { CheckedOutVideo } from './../model/checkedoutvideo.model';
import { Observable, BehaviorSubject } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CheckedoutvideoService {


  getCheckedOutVideosApi = "http://localhost:8080/checkedoutvideo"
  getCheckedOutVideosByIdApi = "http://localhost:8080/checkedoutvideo/patron/"
  postCheckedOutVideosApi = "http://localhost:8080/checkoutvideo/"
  deleteCheckedOutVideosApi = "http://localhost:8080/checkedoutvideo/"

  checkedOutVideo$ = new BehaviorSubject<CheckedOutVideo[]>([]);
  constructor(private http: HttpClient) { }

  fetchCheckedOutVideos(): Observable<CheckedOutVideo[]> {
    let encodedCredentials= localStorage.getItem('credentials');
    let httpOptions = {
      headers: new HttpHeaders({
        'Content-type': 'application/json',
        'Authorization': 'basic ' + encodedCredentials
      })
    };

    return this.http.get<CheckedOutVideo[]>(this.getCheckedOutVideosApi, httpOptions);

  } 

  fetchCheckedOutVideosById(id:number): Observable<CheckedOutVideo[]> {
    let encodedCredentials= localStorage.getItem('credentials');
    let httpOptions = {
      headers: new HttpHeaders({
        'Content-type': 'application/json',
        'Authorization': 'basic ' + encodedCredentials
      })
    };

    return this.http.get<CheckedOutVideo[]>(this.getCheckedOutVideosByIdApi + id, httpOptions);

  } 

  postCheckedOutVideos(pId: number, vId: number): Observable<any> {
    let encodedCredentials= localStorage.getItem('credentials');
    let httpOptions = {
      headers: new HttpHeaders({
        'Content-type': 'application/json',
        'Authorization': 'basic ' + encodedCredentials
      })
    };

    return this.http.post<any>(this.postCheckedOutVideosApi + pId + '/' + vId, null, httpOptions);
    

  }

  deleteCheckedOutVideo(id: number): Observable<any> {
    let encodedCredentials= localStorage.getItem('credentials');
    let httpOptions = {
      headers: new HttpHeaders({
        'Content-type': 'application/json',
        'Authorization': 'basic ' + encodedCredentials
      })
    };

    return this.http.delete<any>(this.deleteCheckedOutVideosApi + id, httpOptions)
  }


}
