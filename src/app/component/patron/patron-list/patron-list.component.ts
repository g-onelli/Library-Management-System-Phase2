import { Component, OnInit } from '@angular/core';
import { Patron } from 'src/app/model/patron.model';
import { PatronService } from 'src/app/service/patron.service';

@Component({
  selector: 'app-patron-list',
  templateUrl: './patron-list.component.html',
  styleUrls: ['./patron-list.component.css']
})
export class PatronListComponent implements OnInit {

  patrons: Patron[];
  page:number;
  total:number;
  constructor(private patronService: PatronService) { }

  ngOnInit(): void {
    this.page = this.patronService.ppage$.getValue();
    this.patronService.ppage$.next(this.page);
    this.patronService.patron$.subscribe(data=>{
      this.patrons = data;
      this.total = data[0].totalpages;
    });
  }
  prev(){
      //read the value of page from subject
      let page = this.patronService.ppage$.getValue();
      //update the value of page
      if(page>0){
        this.page = page-1;
      }
      //attach the updated value to the subject
      this.patronService.ppage$.next(this.page);
  }
  next(){
    //read the value of page from subject
    let page = this.patronService.ppage$.getValue();
    if(page<this.total-1){
    //update the value of page
      this.page = page+1;
    }
    //attach the updated value to the subject
    this.patronService.ppage$.next(this.page);
  }

}
