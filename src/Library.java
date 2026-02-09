public class Library {
    // Private fields
    private Book[] books;
    private int count;

    // Constructor
    public Library(int capacity) {
        this.books = new Book[capacity];
        this.count = 0;
    }

    // Add a book to the library
    public void addBook(Book book) {
        if (count < books.length) {
            books[count] = book;
            count++;
            System.out.println("Book added successfully.");
        } else {
            System.out.println("Library is full. Cannot add more books.");
        }
    }

    // Display all books in the library
    public void displayBooks() {
        if (count == 0) {
            System.out.println("No books in the library.");
            return;
        }
        System.out.println("\n=== Library Books ===");
        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ". " + books[i].toString());
        }
        System.out.println("=====================\n");
    }

    // Search for a book by title
    public Book searchByTitle(String title) {
        for (int i = 0; i < count; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                return books[i];
            }
        }
        return null; // Book not found
    }

    // Borrow a book by title
    public void borrowBook(String title) {
        Book book = searchByTitle(title);
        if (book != null) {
            book.borrowBook();
        } else {
            System.out.println("Book not found in the library.");
        }
    }

    // Return a book by title
    public void returnBook(String title) {
        Book book = searchByTitle(title);
        if (book != null) {
            book.returnBook();
        } else {
            System.out.println("Book not found in the library.");
        }
    }
}
