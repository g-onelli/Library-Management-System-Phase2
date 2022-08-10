import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Video } from '../model/video.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AvailableVideosService {

  getAvailableVideosApi="http://localhost:8080/video/available"


  constructor(private http:HttpClient) { }

  fetchAvailableVideos() : Observable<Video[]>{
    return this.http.get<Video[]>(this.getAvailableVideosApi)
  }
  
  
}
