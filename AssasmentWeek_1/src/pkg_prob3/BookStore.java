package pkg_prob3;

import java.util.ArrayList;
import java.util.List;

public class BookStore {
	List<Book> books = new ArrayList<>();
	
	//add a book
	public void addBook(Book book) {
		books.add(book);
	}
	
	//search by title
	public void searchByTitle(String title) {
		for(Book book:books) {
			if(book.getTitle().equalsIgnoreCase(title)) {
				book.displayDetails();
			}
		}	
	}
	
	//search by author
	 public void searchByAuthor(String author) {
	        for (Book book : books) {
	            if (book.getAuthor().equalsIgnoreCase(author)) {
	                book.displayDetails();
	            }
	        }
	    }
	
	//display all
	 public void displayAll() {
	        for (Book book : books) {
	            book.displayDetails();
	        }
	 }
}
