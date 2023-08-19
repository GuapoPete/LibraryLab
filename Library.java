public class Library {
    // Add the missing implementation to this class
    
    String address;
    Book[] books;
    static String openingHours = "Libraries are open daily from 9am to 5pm.";
    
    public Library(String libraryAddress) {
        address = libraryAddress;
        books = new Book[4]; // Assuming each library can hold up to 4 books
    }
    
    public static void printOpeningHours() {
        System.out.println(openingHours);
    }
    
    public void printAddress() {
        System.out.println(address);
    }
    
    public void addBook(Book book) {
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) {
                books[i] = book;
                break;
            }
        }
    }
    
    public void borrowBook(String bookTitle) {
        for (Book book : books) {
            if (book != null && book.getTitle().equals(bookTitle)) {
                if (!book.isBorrowed()) {
                    book.borrowed();
                    System.out.println("You successfully borrowed " + bookTitle);
                } else {
                    System.out.println("Sorry, this book is already borrowed.");
                }
                return;
            }
        }
        System.out.println("Sorry, this book is not in our catalog.");
    }
    
    public void returnBook(String bookTitle) {
        for (Book book : books) {
            if (book != null && book.getTitle().equals(bookTitle)) {
                book.returned();
                System.out.println("You successfully returned " + bookTitle);
                return;
            }
        }
    }
    
    public void printAvailableBooks() {
        boolean isEmpty = true;
        for (Book book : books) {
            if (book != null && !book.isBorrowed()) {
                System.out.println(book.getTitle());
                isEmpty = false;
            }
        }
        if (isEmpty) {
            System.out.println("No book in catalog");
        }
    }

    public static void main(String[] args) {
        // Create two libraries
        Library firstLibrary = new Library("10 Main St.");
        Library secondLibrary = new Library("228 Liberty St.");

        // Add four books to the first library
        firstLibrary.addBook(new Book("The Da Vinci Code"));
        firstLibrary.addBook(new Book("Le Petit Prince"));
        firstLibrary.addBook(new Book("A Tale of Two Cities"));
        firstLibrary.addBook(new Book("The Lord of the Rings"));

        // Print opening hours and the addresses
        System.out.println("Library hours:");
        printOpeningHours();
        System.out.println();

        System.out.println("Library addresses:");
        firstLibrary.printAddress();
        secondLibrary.printAddress();
        System.out.println();

        // Try to borrow The Lord of the Rings from both libraries
        System.out.println("Borrowing The Lord of the Rings:");
        firstLibrary.borrowBook("The Lord of the Rings");
        firstLibrary.borrowBook("The Lord of the Rings");
        secondLibrary.borrowBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of all available books from both libraries
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
        System.out.println();
        System.out.println("Books available in the second library:");
        secondLibrary.printAvailableBooks();
        System.out.println();

        // Return The Lord of the Rings to the first library
        System.out.println("Returning The Lord of the Rings:");
        firstLibrary.returnBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of available from the first library
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
    }
}
