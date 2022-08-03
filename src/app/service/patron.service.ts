import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable, Subject } from 'rxjs';
import { Patron } from 'src/app/model/patron.model';

@Injectable({
  providedIn: 'root'
})
export class PatronService {
  putApi: string;
  getAllApi: string;
  deleteApi: string;
  patron$= new BehaviorSubject<Patron[]>([]);
  page$= new BehaviorSubject<number>(0);
  constructor(private http: HttpClient) { 
    this.putApi='http://localhost:8080/patrons';
    this.getAllApi='http://localhost:8080/patrons';
    this.deleteApi='http://localhost:8080/patrons';
  }

  public putPatron(patron: Patron, id: number) :Observable<Patron>{
    return this.http.put<Patron>(this.putApi + '/' + id, patron);
  }
  getAllPatrons(page: number, size:number):Observable<Patron[]>{
    return this.http.get<Patron[]>(this.getAllApi + '?page=' +page+ '&size='+size);
  }
  public deletePatron(id: number):Observable<Patron>{
    return this.http.delete<Patron>(this.deleteApi + '/' + id);
  }
}
