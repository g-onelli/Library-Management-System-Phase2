import { PatronService } from 'src/app/service/patron.service';
import { CheckedoutbookService } from './../../service/checkedoutbook.service';
import { CheckedOutBook } from './../../model/checkedoutbook.model';
import { Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-checkedoutbook',
  templateUrl: './checkedoutbook.component.html',
  styleUrls: ['./checkedoutbook.component.css']
})
export class CheckedoutbookComponent implements OnInit {

  checkedOutBooks: CheckedOutBook[];
  errorMessage: string;
  pId : number;
  constructor(private checkedOutBookService: CheckedoutbookService, private patronService : PatronService) {
  }

  ngOnInit(): void {
    this.errorMessage = '';

    this.patronService.getIdByCredentials().subscribe({
      next: (data) => {
        this.pId  = data.id;
        
        this.checkedOutBookService.fetchCheckedOutBooksById(this.pId).subscribe({
          next: (data2) =>{
            this.checkedOutBooks = data2;
          },
          error: (e) =>{
            //redirect to error page
          }
        })
      },
        error: (e) =>{
          //redirect to error page
        }
      
    })
  }

  checkOutBook(pId: number, bId: number) {
    this.checkedOutBookService.postCheckedOutBook(pId, bId).subscribe({
      next: (data) => {
        this.checkedOutBooks = data;
      },
      error: (e) => {
        this.errorMessage = "ID does not exits in list of available books!!!"
      }
    })
  }

  checkInBook(id: number) {
    this.checkedOutBookService.deleteCheckedOutBook(id).subscribe({
      next: (data) => {
        this.checkedOutBooks = this.checkedOutBooks.filter(cb => cb.id != id);
      },
      error: (e) => {
        this.errorMessage = "ID does not exist in list of checked out books!!!"
      }
    });
  }

}
