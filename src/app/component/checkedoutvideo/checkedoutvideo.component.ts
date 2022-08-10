import { PatronService } from 'src/app/service/patron.service';
import { CheckedoutvideoService } from './../../service/checkedoutvideo.service';
import { CheckedOutVideo } from './../../model/checkedoutvideo.model';
import { Component, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-checkedoutvideo',
  templateUrl: './checkedoutvideo.component.html',
  styleUrls: ['./checkedoutvideo.component.css']
})
export class CheckedoutvideoComponent implements OnInit {

  checkedOutVideos: CheckedOutVideo[];

  errorMessage: string;
  pId: number;

  constructor(private checkedOutVideoService: CheckedoutvideoService, private patronService : PatronService) { }

  ngOnInit(): void {
    this.errorMessage = '';

    this.patronService.getIdByCredentials().subscribe({
      next: (data) => {
        this.pId  = data.id;
        
        this.checkedOutVideoService.fetchCheckedOutVideosById(this.pId).subscribe({
          next: (data2) =>{
            this.checkedOutVideos = data2;
          },
          error: (e) =>{
            //redirect to error page
          }
        })
      },
        error: (e) =>{
          //redirect to error page
        }
      
    })
  }


  checkOutVideo(pId: number, vId: number) {
    this.checkedOutVideoService.postCheckedOutVideos(pId, vId).subscribe({
      next: (data) => {
        this.checkedOutVideos = data
      },
      error: (e) => {
        this.errorMessage = "ID does not exist in available books list";
      }
    })
  }

  checkInVideo(id: number) {
    this.checkedOutVideoService.deleteCheckedOutVideo(id).subscribe({
      next: (data) => {
        this.checkedOutVideos = this.checkedOutVideos.filter(cv => cv.id != id);
      },
      error: (e) => {
        this.errorMessage = "ID does not exist in list of checked out videos!!!";
      }
    });
  }

}
