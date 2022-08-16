import { VideoService } from './../../service/video.service';
import { Component, OnInit } from '@angular/core';
import { Video } from 'src/app/model/video.model';

@Component({
  selector: 'app-video',
  templateUrl: './video.component.html',
  styleUrls: ['./video.component.less']
})
export class VideoComponent implements OnInit {


  constructor(private videoService:VideoService) { }

  ngOnInit(): void {
  }



}
