import { HttpClient } from '@angular/common/http';
import { Injectable, OnInit } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { EventModel } from '../model/event.model';

@Injectable({
  providedIn: 'root'
})
export class EventService {

  postApi: string;
  getAllApi: string;
  getByIdApi: string;
  deleteByIdApi: string;
  updateByIdApi: string;

  event$ = new BehaviorSubject<EventModel[]>([]);
  page$ = new BehaviorSubject<number>(0);
  size$ = new BehaviorSubject<number>(3);

  constructor (private http : HttpClient) {
    this.postApi = 'http://localhost:8080/event';
    this.getAllApi = 'http://localhost:8080/event';
    this.getByIdApi = 'http://localhost:8080/event';
    this.deleteByIdApi = 'http://localhost:8080/event';
    this.updateByIdApi = 'http://localhost:8080/event';
  }

  postEvent(event: EventModel, libId: number) : Observable<EventModel>{
    return this.http.post<EventModel>(this.postApi + '/' + libId, event);
  }

  getAllEvent(page: number, size: number) : Observable<EventModel[]> {
    return this.http.get<EventModel[]>(this.getAllApi + '?page=' + page + '&size=' + size);
  }

  getByIdEvent(id: number) : Observable<EventModel> {
    return this.http.get<EventModel>(this.getByIdApi + '?id=' + id);
  }

  deleteByIdEvent(id: number) {
    this.http.delete(this.deleteByIdApi + '/' + id);
    console.log('Deleted: ' + id + ', change later.');
  }

  updateByIdEvent(id: number, event: EventModel) : Observable<EventModel> {
    return this.http.put<EventModel>(this.updateByIdApi + '/' + id, event);
  }

}
