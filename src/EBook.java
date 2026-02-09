public class EBook extends Book {
    // Additional field for EBook
    private double fileSize; // in MB

    // Constructor
    public EBook(String title, String author, int year, double fileSize) {
        super(title, author, year); // Call parent constructor
        this.fileSize = fileSize;
    }

    // Getter for fileSize
    public double getFileSize() {
        return fileSize;
    }

    // Override toString() to include file size
    @Override
    public String toString() {
        return "[E-Book] Title: " + getTitle() + ", Author: " + getAuthor() + 
               ", Year: " + getYear() + ", File Size: " + fileSize + "MB, Available: " + isAvailable();
    }
}
