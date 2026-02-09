import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library(10); // Create library with capacity of 10
        
        int choice;
        
        do {
            // Display menu
            System.out.println("\n=== Library Management System ===");
            System.out.println("1. Add book");
            System.out.println("2. Add e-book");
            System.out.println("3. Display all books");
            System.out.println("4. Search book by title");
            System.out.println("5. Borrow book");
            System.out.println("6. Return book");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            
            // Validate menu choice input
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number between 1 and 7.");
                System.out.print("Enter your choice: ");
                scanner.next(); // Consume invalid input
            }
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1: // Add book
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author name: ");
                    String author = scanner.nextLine();
                    
                    int year = 0;
                    boolean validYear = false;
                    while (!validYear) {
                        System.out.print("Enter publication year: ");
                        if (scanner.hasNextInt()) {
                            year = scanner.nextInt();
                            validYear = true;
                        } else {
                            System.out.println("Invalid year. Please enter a valid number.");
                            scanner.next(); // Consume invalid input
                        }
                    }
                    scanner.nextLine(); // Consume newline
                    
                    Book book = new Book(title, author, year);
                    library.addBook(book);
                    break;
                    
                case 2: // Add e-book
                    System.out.print("Enter e-book title: ");
                    String eTitle = scanner.nextLine();
                    System.out.print("Enter author name: ");
                    String eAuthor = scanner.nextLine();
                    
                    int eYear = 0;
                    boolean validEYear = false;
                    while (!validEYear) {
                        System.out.print("Enter publication year: ");
                        if (scanner.hasNextInt()) {
                            eYear = scanner.nextInt();
                            validEYear = true;
                        } else {
                            System.out.println("Invalid year. Please enter a valid number.");
                            scanner.next(); // Consume invalid input
                        }
                    }
                    
                    double fileSize = 0;
                    boolean validSize = false;
                    while (!validSize) {
                        System.out.print("Enter file size (MB): ");
                        if (scanner.hasNextDouble()) {
                            fileSize = scanner.nextDouble();
                            validSize = true;
                        } else {
                            System.out.println("Invalid size. Please enter a valid number (e.g., 5.2).");
                            scanner.next(); // Consume invalid input
                        }
                    }
                    scanner.nextLine(); // Consume newline
                    
                    EBook ebook = new EBook(eTitle, eAuthor, eYear, fileSize);
                    library.addBook(ebook);
                    break;
                    
                case 3: // Display all books
                    library.displayBooks();
                    break;
                    
                case 4: // Search book by title
                    System.out.print("Enter book title to search: ");
                    String searchTitle = scanner.nextLine();
                    Book foundBook = library.searchByTitle(searchTitle);
                    
                    if (foundBook != null) {
                        System.out.println("Book found: " + foundBook.toString());
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                    
                case 5: // Borrow book
                    System.out.print("Enter book title to borrow: ");
                    String borrowTitle = scanner.nextLine();
                    library.borrowBook(borrowTitle);
                    break;
                    
                case 6: // Return book
                    System.out.print("Enter book title to return: ");
                    String returnTitle = scanner.nextLine();
                    library.returnBook(returnTitle);
                    break;
                    
                case 7: // Exit
                    System.out.println("Thank you for using the Library Management System!");
                    break;
                    
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            
        } while (choice != 7);
        
        scanner.close();
    }
}
