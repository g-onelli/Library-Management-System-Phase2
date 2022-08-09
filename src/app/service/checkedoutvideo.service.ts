import { CheckedOutVideo } from './../model/checkedoutvideo.model';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CheckedoutvideoService {

  getCheckedOutVideosApi = "http://localhost:8080/checkedoutvideo"
  postCheckedOutVideosApi = "http://localhost:8080/checkoutvideo/"
  deleteCheckedOutVideosApi = "http://localhost:8080/checkedoutvideo/"
  constructor(private http: HttpClient) { }

  fetchCheckedOutVideos(): Observable<CheckedOutVideo[]> {
    return this.http.get<CheckedOutVideo[]>(this.getCheckedOutVideosApi);

  }

  postCheckedOutVideos(pId: number, vId: number): Observable<any> {
    return this.http.post<any>(this.postCheckedOutVideosApi + pId + '/' + vId, null);
    

  }

  deleteCheckedOutVideo(id: number): Observable<any> {
    return this.http.delete<any>(this.deleteCheckedOutVideosApi + id)
  }
}
