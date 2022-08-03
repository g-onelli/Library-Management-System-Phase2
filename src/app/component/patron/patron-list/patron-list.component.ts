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
  constructor(private patronService: PatronService) { }

  ngOnInit(): void {

    this.patronService.patron$.subscribe(data=>{
      this.patrons = data;
    });
  }
  prev(){
      //read the value of page from subject
      let page = this.patronService.page$.getValue();
      //update the value of page
      if(page>0){
        this.page = page-1;
      }
      //attach the updated value to the subject
      this.patronService.page$.next(this.page);
  }
  next(){
    //read the value of page from subject
    let page = this.patronService.page$.getValue();
    //update the value of page
      this.page = page+1;
    //attach the updated value to the subject
    this.patronService.page$.next(this.page);
  }

}
