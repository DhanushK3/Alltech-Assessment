import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Book } from '../create-book/book';
import { BookService } from '../service-book/book.service';

@Component({
  selector: 'app-view-book',
  templateUrl: './view-book.component.html',
  styleUrls: ['./view-book.component.css']
})
export class ViewBookComponent implements OnInit {
  book: Book = new Book();

  constructor(
    private bookService: BookService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.getBookDetails();
  }

  getBookDetails() {
    const id = +this.route.snapshot.params['id'];
    if (id) {
      this.bookService.getBookById(id).subscribe(
        (data) => {
          this.book = data;
        },
        (error) => console.log(error)
      );
    }
  }

  goToBookList() {
    this.router.navigate(['/books']);
  }
}



// import { Component, OnInit } from '@angular/core';
// import { ActivatedRoute, Router } from '@angular/router';
// import { BookService } from '../service-book/book.service';
// import { Book } from '../create-book/book';

// @Component({
//   selector: 'app-view-book',
//   templateUrl: './view-book.component.html',
//   styleUrls: ['./view-book.component.css']
// })
// export class ViewBookComponent implements OnInit {
//   book: Book = new Book();

//   constructor(
//     private bookService: BookService,
//     private route: ActivatedRoute,
//     private router: Router
//   ) { }

//   ngOnInit(): void {
//     this.getBookDetails();
//   }

//   getBookDetails() {
//     const id = +this.route.snapshot.paramMap.get('id');
//     if (id !== null && id !== undefined) {
//       this.bookService.getBookById(id).subscribe(
//         (data) => {
//           this.book = data;
//         },
//         (error) => console.log(error)
//       );
//     } else {
//       console.error('ID parameter is missing in the route.');
//     }
//   }

//   goToBookList() {
//     this.router.navigate(['/books']);
//   }
// }
