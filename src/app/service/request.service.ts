import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { CompleteRequest } from '../model/request.model';
import { Requests } from 'src/app/model/request.model';

@Injectable({
  providedIn: 'root'
})
export class RequestService {
  postApi: string;
  getAllApi: string;
  getApi: string;
  deleteApi: string;
  patronPostApi: string;
  completedRequest: CompleteRequest;
  request$= new BehaviorSubject<Requests[]>([]);
  page$= new BehaviorSubject<number>(0);
  constructor(private http: HttpClient) { 
    this.postApi=environment.serverUrl +'/requests';
    this.getAllApi=environment.serverUrl +'/requests';
    this.deleteApi=environment.serverUrl +'/requests';
    this.getApi=environment.serverUrl +'/requests';
    this.patronPostApi=environment.serverUrl +'/requests/patrons';
  }

  public completeBookRequest(completedRequest: CompleteRequest, id: number) :Observable<CompleteRequest>{
    return this.http.post<CompleteRequest>(this.postApi + '/' + id,completedRequest);
  }
  getAllRequests(page: number, size:number):Observable<Requests[]>{
    return this.http.get<Requests[]>(this.getAllApi + '?page=' +page+ '&size='+size);
  }
  public deleteRequest(id: number):Observable<Requests>{
    return this.http.delete<Requests>(this.deleteApi + '/' + id);
  }
  getRequestById(id: number):Observable<Requests>{
    return this.http.get<Requests>(this.getApi + '/' + id);
  }
  postRequest(request: Requests, id: number):Observable<any>{
    return this.http.post(this.patronPostApi+ '/' + id, request);
  }

}
