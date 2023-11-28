import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Book } from '../create-book/book';

@Injectable({
  providedIn: 'root'
})
export class BookService {
  private baseURL = "http://localhost:9090/api/project2/books";

  constructor(private httpClient: HttpClient) { }

  getBooksList(): Observable<Book[]> {
    return this.httpClient.get<Book[]>(`${this.baseURL}`);
  }

  //sends http post request
  createBook(book: Book): Observable<Object> {
    return this.httpClient.post(`${this.baseURL}`, book);
  }

  getBookById(id: number): Observable<Book> {
    return this.httpClient.get<Book>(`${this.baseURL}/${id}`);
  }

  //sends put request
  updateBook(id: number, book: Book): Observable<Object> {
    return this.httpClient.put(`${this.baseURL}/${id}`, book);
  }

  deleteBook(id: number): Observable<Object> {
    return this.httpClient.delete(`${this.baseURL}/${id}`);
  }
}
