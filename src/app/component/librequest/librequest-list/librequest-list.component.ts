import { Component, OnInit } from '@angular/core';
import { Requests } from 'src/app/model/request.model';
import { RequestService } from 'src/app/service/request.service';

@Component({
  selector: 'app-librequest-list',
  templateUrl: './librequest-list.component.html',
  styleUrls: ['./librequest-list.component.less']
})
export class LibrequestListComponent implements OnInit {

  requests: Requests[];
  page:number;
  total:number;
  constructor(private requestService: RequestService) { }

  ngOnInit(): void {
    this.page = this.requestService.rpage$.getValue();
    this.requestService.rpage$.next(this.page);
    this.requestService.request$.subscribe(data=>{
      this.requests = data;
      this.total = data[0].tpages;
    });
  }
  prev(){
      //read the value of page from subject
      let page = this.requestService.rpage$.getValue();
      //update the value of page
      if(page>0){
        this.page = page-1;
      }
      //attach the updated value to the subject
      this.requestService.rpage$.next(this.page);
  }
  next(){
    //read the value of page from subject
    let page = this.requestService.rpage$.getValue();
    if(page<this.total-1){
    //update the value of page
      this.page = page+1;
    }
    //attach the updated value to the subject
    this.requestService.rpage$.next(this.page);
  }

}
