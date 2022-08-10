import { Video } from './../model/video.model';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class VideoService {

  
  getVideosApi="http://localhost:8080/video"
  constructor(private http:HttpClient) { }

  fetchVideos() : Observable<Video[]>{
    let encodedCredentials= localStorage.getItem('credentials');
    let httpOptions = {
      headers: new HttpHeaders({
        'Content-type': 'application/json',
        'Authorization': 'basic ' + encodedCredentials
      })
    };

    return this.http.get<Video[]>(this.getVideosApi, httpOptions);
}

}
