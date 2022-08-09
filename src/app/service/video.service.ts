import { Video } from './../model/video.model';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class VideoService {

  
  getVideosApi="http://localhost:8080/video"
  constructor(private http:HttpClient) { }

  fetchVideos() : Observable<Video[]>{
    return this.http.get<Video[]>(this.getVideosApi);
}

}
