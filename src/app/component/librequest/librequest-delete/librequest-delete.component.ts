import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Requests } from 'src/app/model/request.model';
import { RequestService } from 'src/app/service/request.service';

@Component({
  selector: 'app-librequest-delete',
  templateUrl: './librequest-delete.component.html',
  styleUrls: ['./librequest-delete.component.less']
})
export class LibrequestDeleteComponent implements OnInit {

  requestForm :FormGroup;
  request: Requests;
  msg: string;
  id: number;
  constructor(private requestService: RequestService) { }

  ngOnInit(): void {
    this.requestForm = new FormGroup({
      id: new FormControl('', [Validators.required,Validators.pattern(/^[0-9 ]+$/)])
    });
  }
onFormSubmit(){
  this.id = this.requestForm.value.id;
  this.requestService.deleteRequest(this.id).subscribe({
    next: (data)=>{
      this.msg='Request deleted in the system';
    },
    error: (e)=>{
      this.msg='Operation failed';
      
    }
  });
}

}
