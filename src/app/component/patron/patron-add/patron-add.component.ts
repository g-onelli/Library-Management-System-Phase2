import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Patron } from 'src/app/model/patron.model';
import { PatronService } from 'src/app/service/patron.service';

@Component({
  selector: 'app-patron-add',
  templateUrl: './patron-add.component.html',
  styleUrls: ['./patron-add.component.css']
})
export class PatronAddComponent implements OnInit {
  patronForm :FormGroup;
  patron: Patron;
  msg: string;
  id: number;
  constructor(private patronService: PatronService) { }

  ngOnInit(): void {
    this.patronForm = new FormGroup({
      id: new FormControl('', [Validators.required,Validators.pattern(/^[0-9 ]+$/)]),
      name: new FormControl('', [Validators.pattern(/^[a-zA-Z ]+$/)]),
      cardexpirationdate: new FormControl('', [Validators.pattern(/^\d{4}-\d{2}-\d{2}$/)]),
      balance: new FormControl('', [Validators.pattern(/\d+\.\d*|\.?\d+/)]),
      //username: new FormControl('', [Validators.pattern(/^[a-zA-Z0-9]+$/)]),
    });
  }
onFormSubmit(){
  this.patron = this.patronForm.value;
  this.id = this.patronForm.value.id;
  this.patronService.putPatron(this.patron, this.id).subscribe({
    next: (data)=>{
      this.patron = data;
      this.msg='Patron updated in the system';
      //read the value from the subject
      let patronArray = this.patronService.patron$.getValue();
      //update the value: add patron to Patron[]
      patronArray.push(this.patron);
      //update the subject value
      this.patronService.patron$.next(patronArray);
    },
    error: (e)=>{
      this.msg='Operation failed';
    }
  });
}

}
