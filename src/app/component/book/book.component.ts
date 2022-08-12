import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { Book } from 'src/app/model/book.model';
import { BookService } from 'src/app/service/book.service';

@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.less']
})
export class BookComponent implements OnInit{

  

  constructor(private bookService : BookService) { }

  ngOnInit(): void {
  }


}
