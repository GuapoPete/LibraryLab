public class Book {

    String title;
    boolean borrowed;

    // Creates a new Book
    public Book(String bookTitle) {
        title = bookTitle; // Set the title of the book
        borrowed = false;  // Initially, the book is not borrowed
    }
   
    // Marks the book as rented
    public void borrowed() {
        borrowed = true; // Set the 'borrowed' flag to true
    }
   
    // Marks the book as not rented
    public void returned() {
        borrowed = false; // Set the 'borrowed' flag to false
    }
   
    // Returns true if the book is rented, false otherwise
    public boolean isBorrowed() {
        return borrowed; // Return the value of the 'borrowed' flag
    }
   
    // Returns the title of the book
    public String getTitle() {
        return title; // Return the title of the book
    }

    public static void main(String[] arguments) {
        // Small test of the Book class
        Book example = new Book("The Da Vinci Code");
        System.out.println("Title (should be The Da Vinci Code): " + example.getTitle());
        System.out.println("Borrowed? (should be false): " + example.isBorrowed());
        example.borrowed(); // Use 'borrowed' method to mark the book as borrowed
        System.out.println("Borrowed? (should be true): " + example.isBorrowed());
        example.returned(); // Use 'returned' method to mark the book as returned
        System.out.println("Borrowed? (should be false): " + example.isBorrowed());
    }
}
