import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Book } from '../create-book/book';
import { BookService } from '../service-book/book.service';

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.css'],
})
export class BookListComponent implements OnInit {
  books: Book[] = [];

  constructor(private bookService: BookService, private router: Router) {}

  ngOnInit(): void {
    this.getBooks();
  }

  private getBooks() {
    this.bookService.getBooksList().subscribe((data) => {
      this.books = data;
    });
  }

  updateBook(id: number) {
    this.router.navigate(['update-book', id]);
  }

  deleteBook(id: number) {
    this.bookService.deleteBook(id).subscribe(
      () => {
        console.log('Book deleted successfully.');
        this.getBooks();
      },
      (error) => console.log(error)
    );
  }

  viewBook(id: number) {
    // Assuming you have a route like '/books/view/:id' for viewing book details
    this.router.navigate(['/books/view', id]);
  }
}
