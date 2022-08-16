import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { room } from 'src/app/model/room.model';
import { RoomService } from 'src/app/service/room.service';

@Component({
  selector: 'app-show-room',
  templateUrl: './show-room.component.html',
  styleUrls: ['./show-room.component.css']
})
export class ShowRoomComponent implements OnInit {
  roomList:room[];
  room:room;
  formOne:FormGroup;
  constructor(private roomServices:RoomService) { }

  ngOnInit(): void {
    rNum: new FormControl("",Validators.required);

    this.roomServices.showAllRooms().subscribe(data=>{
        this.roomList=data;
      });
    }

  showSingleRoom(){
    console.log(this.formOne.value.rNum);
    this.roomServices.showOneRoom(this.formOne.value.rNum).subscribe(data=>{
      this.room = data;
    })
    console.log(this.room);
  }

}


