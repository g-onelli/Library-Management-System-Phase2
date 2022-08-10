import { VideoService } from './../../service/video.service';
import { Component, OnInit } from '@angular/core';
import { Video } from 'src/app/model/video.model';

@Component({
  selector: 'app-video',
  templateUrl: './video.component.html',
  styleUrls: ['./video.component.css']
})
export class VideoComponent implements OnInit {
  videos:Video[];
  errorMessage:string;

  constructor(private videoService:VideoService) { }

  ngOnInit(): void {

    this.displayAllVideos();

  }

  sortByCallNumber(videos : Video[], flag : number) : Video[]{
    if(flag = 1)
      videos = videos.sort( (b1, b2) => b1.callNumber = b2.callNumber);
    else
      videos = videos.sort( (b1, b2) => b2.callNumber = b1.callNumber);

      return videos;

  }


  displayAllVideos(){
    this.errorMessage='';
    this.videoService.fetchVideos().subscribe({
      next: (data) => {
        this.videos = data;
      },
      error: (e) => {
        this.errorMessage = 'Videos could not be fetched..'
      }
    });
  }

}
