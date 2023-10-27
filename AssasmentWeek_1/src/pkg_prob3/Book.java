package pkg_prob3;

public class Book {
	
	private String bookID;
    private String title;
    private String author;
    private String category;
    private float price;
    
    public Book(String bookID, String title, String author, String category, float price) throws InvalidBookException {
        if (!category.equals("Science") && !category.equals("Fiction")
                && !category.equals("Technology") && !category.equals("Others")) {
            throw new InvalidBookException("Invalid category: " + category);
        }
        if (price < 0) {
            throw new InvalidBookException("Price cannot be negative");
        }
        if (!bookID.startsWith("B") || bookID.length() != 4) {
            throw new InvalidBookException("Invalid book ID: " + bookID);
        }
		
		
		this.bookID = bookID;
		this.title = title;
		this.author = author;
		this.category = category;
		this.price = price;
	}

	public String getBookID() {
		return bookID;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public String getCategory() {
		return category;
	}

	public float getPrice() {
		return price;
	}
    
	public void displayDetails() {
        System.out.println("Book ID: " + bookID);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Category: " + category);
        System.out.println("Price: $" + price);
    }
	
}
