import { Component, OnInit } from '@angular/core';
import { EventModel } from 'src/app/model/event.model';
import { EventService } from 'src/app/service/event.service';

@Component({
  selector: 'app-event',
  templateUrl: './event.component.html',
  styleUrls: ['./event.component.css']
})
export class EventComponent implements OnInit {

  events: EventModel[];
  page: number;
  size: number;
  constructor(private eventService : EventService) { }

  ngOnInit(): void {
    this.size = 3;
    this.eventService.page$.subscribe(value => {
      this.page = value;
      this.eventService.getAllEvent(this.page, this.size).subscribe ({
        next: (data) => {
          this.events = data;
          this.eventService.event$.next(this.events);
        },
        error: (e) => {
          console.log(e);
        }
      })
    })
  }

}
