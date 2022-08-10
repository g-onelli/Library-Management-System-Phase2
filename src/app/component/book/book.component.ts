import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { Book } from 'src/app/model/book.model';
import { BookService } from 'src/app/service/book.service';

@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.css']
})
export class BookComponent implements OnInit{
  books:Book[];
  errorMessage:string;
  

  constructor(private bookService : BookService) { }

  ngOnInit(): void {
    this.displayAllBooks();
  }

  displayAllBooks(){
    this.errorMessage='';
    this.bookService.fetchAllBooks().subscribe({
      next: (data) => {
        this.books = data;
      },
      error: (e) => {
        this.errorMessage = 'Books could not be fetched..'
      }
    });
  }

  sortByCallNumber(books : Book[], flag : number) : Book[]{
    if(flag = 1)
      books = books.sort( (b1, b2) => b1.callNumber = b2.callNumber);
    else
      books = books.sort( (b1, b2) => b2.callNumber = b1.callNumber);

      return books;

  }
}
