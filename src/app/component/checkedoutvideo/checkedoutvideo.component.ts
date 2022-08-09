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

  constructor(private checkedOutVideoService: CheckedoutvideoService) { }

  ngOnInit(): void {
    this.errorMessage = '';
    this.checkedOutVideoService.fetchCheckedOutVideos().subscribe({
      next: (data) => {
        this.checkedOutVideos = data;
      },
      error: (e) => {
        this.errorMessage = 'Checked-Out Videos could not be fetched..'
      }
    });
  }


  checkOutVideo(pId: number, vId: number) {
    this.checkedOutVideoService.postCheckedOutVideos(pId, vId).subscribe({
      next: (data) => {
        this.checkedOutVideos = this.checkedOutVideos
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
