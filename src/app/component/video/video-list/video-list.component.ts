import { Component, OnInit } from '@angular/core';
import { Video } from 'src/app/model/video.model';
import { VideoService } from 'src/app/service/video.service';

@Component({
  selector: 'app-video-list',
  templateUrl: './video-list.component.html',
  styleUrls: ['./video-list.component.css']
})
export class VideoListComponent implements OnInit {

  videos:Video[];
  errorMessage:string;

  constructor(private videoService:VideoService) { }

  ngOnInit(): void {
    this.displayAllVideos()
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
