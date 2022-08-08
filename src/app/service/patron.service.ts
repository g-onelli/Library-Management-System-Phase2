import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable, Subject } from 'rxjs';
import { Patron } from 'src/app/model/patron.model';
import { environment } from 'src/environments/environment';
import { PatronEditDto, PatronId } from '../auth/model/user.model';

@Injectable({
  providedIn: 'root'
})
export class PatronService {
  
  putApi: string;
  getAllApi: string;
  getApi: string;
  getIdApi: string;
  deleteApi: string;
  patronEditDto: PatronEditDto;
  patron$= new BehaviorSubject<Patron[]>([]);
  page$= new BehaviorSubject<number>(0);
  constructor(private http: HttpClient) { 
    this.putApi=environment.serverUrl +'/patrons';
    this.getAllApi=environment.serverUrl +'/patrons';
    this.deleteApi=environment.serverUrl +'/patrons';
    this.getApi=environment.serverUrl +'/patrons';
    this.getIdApi=environment.serverUrl +'/patronId';
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
  getIdByCredentials():Observable<PatronId> {
    let encodedCredentials= localStorage.getItem('credentials');
    let httpOptions = {
      headers: new HttpHeaders({
        'Content-type': 'application/json',
        'Authorization': 'basic ' + encodedCredentials
      })
    };
    return this.http.get<PatronId>(this.getIdApi,httpOptions)
  }
}
