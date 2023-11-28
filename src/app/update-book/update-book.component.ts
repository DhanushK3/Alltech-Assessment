import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { BookService } from '../service-book/book.service';
import { Book } from '../create-book/book';

@Component({
  selector: 'app-update-book',
  templateUrl: './update-book.component.html',
  styleUrls: ['./update-book.component.css'],
})
export class UpdateBookComponent implements OnInit {
  id!: number; //definite assignment assertion

  book: Book = new Book(0, '', '', '', 0, 0); //Initialize id with default value

  constructor(
    private bookService: BookService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.bookService.getBookById(this.id).subscribe(
      (data) => {
        this.book = data;
      },
      (error) => console.log(error)
    );
  }

  onSubmit() {
    this.bookService.updateBook(this.id, this.book).subscribe(
      (data) => {
        console.log('Book updated successfully.');
        this.goToBookList();
      },
      (error) => console.log(error)
    );
  }

  goToBookList() {
    this.router.navigate(['/books']);//navigate
  }
}
