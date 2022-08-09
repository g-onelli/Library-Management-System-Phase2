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
  constructor(private checkedOutBookService: CheckedoutbookService) {
  }

  ngOnInit(): void {
    this.errorMessage = '';
    this.checkedOutBookService.fetchCheckedOutBooks().subscribe({
      next: (data) => {
        this.checkedOutBooks = data;
      },
      error: (e) => {
        this.errorMessage = 'Checked-Out Books could not be fetched..'
      }
    });
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
