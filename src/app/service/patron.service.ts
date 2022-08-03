import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable, Subject } from 'rxjs';
import { Patron } from 'src/app/model/patron.model';
import { PatronEditDto } from '../auth/model/user.model';

@Injectable({
  providedIn: 'root'
})
export class PatronService {
  putApi: string;
  getAllApi: string;
  getApi: string;
  deleteApi: string;
  patronEditDto: PatronEditDto;
  patron$= new BehaviorSubject<Patron[]>([]);
  page$= new BehaviorSubject<number>(0);
  constructor(private http: HttpClient) { 
    this.putApi='http://localhost:8080/patrons';
    this.getAllApi='http://localhost:8080/patrons';
    this.deleteApi='http://localhost:8080/patrons';
    this.getApi='http://localhost:8080/patrons';
  }

  public putPatron(patronEditDto: PatronEditDto) :Observable<PatronEditDto>{
    return this.http.put<PatronEditDto>(this.putApi,patronEditDto);
  }
  getAllPatrons(page: number, size:number):Observable<Patron[]>{
    return this.http.get<Patron[]>(this.getAllApi + '?page=' +page+ '&size='+size);
  }
  public deletePatron(id: number):Observable<Patron>{
    return this.http.delete<Patron>(this.deleteApi + '/' + id);
  }
  getPatronById(id: number):Observable<PatronEditDto>{
    return this.http.get<PatronEditDto>(this.getApi + '/' + id)
  }
}
