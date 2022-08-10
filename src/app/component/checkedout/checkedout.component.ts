import { CheckedoutvideoComponent } from './../checkedoutvideo/checkedoutvideo.component';
import { CheckedoutbookComponent } from './../checkedoutbook/checkedoutbook.component';
import { Component, OnInit, ViewChild } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';



@Component({
  selector: 'app-checkedout',
  templateUrl: './checkedout.component.html',
  styleUrls: ['./checkedout.component.css']
})


export class CheckedoutComponent implements OnInit {

  checkOutForm: FormGroup;
  checkInForm: FormGroup;
  message: string;

  @ViewChild(CheckedoutbookComponent) checkedOutBookComponent: CheckedoutbookComponent;
  @ViewChild(CheckedoutvideoComponent) checkedOutVideoComponent: CheckedoutvideoComponent;

  constructor() { }

  ngOnInit(): void {
    this.message = '';


    this.checkOutForm = new FormGroup({
      itemId: new FormControl('', [Validators.required, Validators.pattern(/^([0-9]+)$/)]),
      iType: new FormControl('book')
    });

    this.checkInForm = new FormGroup({
      itemId: new FormControl('', [Validators.required, Validators.pattern(/^([0-9]+)$/)]),
      iType: new FormControl('book')
    });
  }

  checkOutFormSubmit() {
    console.log(parseInt(this.checkOutForm.value.itemId));
    console.log(this.checkOutForm.value.iType)

    if (this.checkOutForm.value.iType === "book") {
      this.checkOutBook(8,parseInt(this.checkOutForm.value.itemId));

    }
    else {
      this.checkOutVideo(8,parseInt(this.checkOutForm.value.itemId));


    }


  }

  checkInFormSubmit() {
    console.log(parseInt(this.checkInForm.value.itemId));
    console.log(this.checkInForm.value.iType)

    if (this.checkInForm.value.iType === "book") {

      this.checkInBook(parseInt(this.checkInForm.value.itemId));

    }
    else {
      this.checkInVideo(parseInt(this.checkInForm.value.itemId));
    }


  }


  checkOutBook(pId: number, bId: number) {

    this.checkedOutBookComponent.checkOutBook(pId, bId);

  }
  checkOutVideo(pId: number, vId: number) {

   this.checkedOutVideoComponent.checkOutVideo(pId, vId);
  }

  checkInBook(id: number) {
    this.checkedOutBookComponent.checkInBook(id);
  }

  checkInVideo(id: number) {
    this.checkedOutVideoComponent.checkInVideo(id);
  }



}
