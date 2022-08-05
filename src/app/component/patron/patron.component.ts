import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { Patron } from 'src/app/model/patron.model';
import { PatronService } from 'src/app/service/patron.service';

@Component({
  selector: 'app-patron',
  templateUrl: './patron.component.html',
  styleUrls: ['./patron.component.css']
})
export class PatronComponent implements OnInit {
  patrons: Patron[];
  subscriptions: Subscription[]=[];
  page:number;
  size: number;
  constructor(private patronService: PatronService) { }

  ngOnInit(): void {
    this.subscriptions=[];
    this.size = 5;
    this.subscriptions.push(
      this.patronService.page$.subscribe(value=>{
          this.page = value;
          this.patronService.getAllPatrons(this.page,this.size).subscribe({
            next: (data)=>{
                this.patrons = data;
                this.patronService.patron$.next(this.patrons);
            },
            error: (e)=>{
              //redirect to error page
            }
          });
      })
    );


  }
  ngOnDestroy(): void {
    this.subscriptions.forEach(sub=>sub.unsubscribe());
  }
}
