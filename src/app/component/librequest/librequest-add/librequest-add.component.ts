import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { CompleteRequest } from 'src/app/model/request.model';
import { RequestService } from 'src/app/service/request.service';

@Component({
  selector: 'app-librequest-add',
  templateUrl: './librequest-add.component.html',
  styleUrls: ['./librequest-add.component.css']
})
export class LibrequestAddComponent implements OnInit {

  completeRequest: CompleteRequest;
  requestForm :FormGroup;
  request: Request;
  msg: string;

  constructor(private requestService: RequestService, private router: Router) { }

  ngOnInit(): void {
    this.requestForm = new FormGroup({
      id: new FormControl('', [Validators.required,Validators.pattern(/^[0-9 ]+$/)]),
      publisher: new FormControl('', [Validators.required,Validators.pattern(/^[\w\-\s]+$/)]),
      genre: new FormControl('', [Validators.required]),
    });
  }
onFormSubmit(){
      this.completeRequest={
        publisher: this.requestForm.value.publisher,
        genre: this.requestForm.value.genre
      };
      this.requestService.completeBookRequest(this.completeRequest, this.requestForm.value.id).subscribe({
        next: (data)=>{
          this.msg='Book Added';
        },
        error: (e)=>{
          this.msg='Operation failed';
        }
      });
}

}
