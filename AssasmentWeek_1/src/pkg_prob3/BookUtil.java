package pkg_prob3;

import java.util.Scanner;

public class BookUtil {
    public static void main(String[] args) {
        BookStore bookStore = new BookStore();
        Scanner scanner = new Scanner(System.in);

        try {
            for (int i = 1; i <= 3; i++) {
                System.out.println("Enter details for Book " + i + ":");
                System.out.print("Book ID: ");
                String bookID = scanner.next();
                System.out.print("Title: ");
                String title = scanner.next();
                System.out.print("Author: ");
                String author = scanner.next();
                System.out.print("Category (Science/Fiction/Technology/Others): ");
                String category = scanner.next();
                System.out.print("Price: ");
                float price = scanner.nextFloat();

                Book book = new Book(bookID, title, author, category, price);
                bookStore.addBook(book);
            }
            
            System.out.println("==============================");

            System.out.println("Search by Title:");
            bookStore.searchByTitle(scanner.next());
            
            System.out.println("==============================");

            System.out.println("Search by Author:");
            bookStore.searchByAuthor(scanner.next());
            
            System.out.println("==============================");


            System.out.println("Display All Books:");
            
            System.out.println("==============================");
            bookStore.displayAll();
        } catch (InvalidBookException e) {
            System.out.println("Book not found: " + e.getMessage());
        }
    }
}
