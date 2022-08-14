import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Patron } from 'src/app/model/patron.model';
import { PatronService } from 'src/app/service/patron.service';

@Component({
  selector: 'app-patron-delete',
  templateUrl: './patron-delete.component.html',
  styleUrls: ['./patron-delete.component.less']
})
export class PatronDeleteComponent implements OnInit {

  patronForm :FormGroup;
  patron: Patron;
  msg: string;
  id: number;
  constructor(private patronService: PatronService) { }

  ngOnInit(): void {
    this.patronForm = new FormGroup({
      id: new FormControl('', [Validators.required,Validators.pattern(/^[0-9 ]+$/)])
    });
    this.msg='';
  }
onFormSubmit(){
  this.id = this.patronForm.value.id;
  this.patronService.deletePatron(this.id).subscribe({
    next: (data)=>{
      this.msg='Patron deleted in the system';
    },
    error: (e)=>{
      this.msg='Operation failed';
      
    }
  });
}

}
