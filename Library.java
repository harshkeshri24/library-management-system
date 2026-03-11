import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
        System.out.println("\n[SUCCESS] Book registered in the system.");
    }

    public void showAllBooks() {
        if (books.isEmpty()) {
            System.out.println("\n[!] The library is empty. Please add books first.");
            return;
        }
        System.out.println("\n============= CURRENT LIBRARY REPOSITORY =============");
        for (Book b : books) {
            b.displayCard();
        }
    }

    public void search(String query) {
        boolean found = false;
        System.out.println("\n--- SEARCH RESULTS ---");
        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(query) || b.getAuthor().equalsIgnoreCase(query)) {
                b.displayCard();
                found = true;
            }
        }
        if (!found) System.out.println(" No matches found for: " + query);
    }

    public void issueBook(String id) {
        for (Book b : books) {
            if (b.getId().equalsIgnoreCase(id)) {
                if (b.isAvailable()) {
                    b.setAvailable(false);
                    System.out.println("\n SUCCESS: '" + b.getTitle() + "' has been issued.");
                } else {
                    System.out.println("\n ERROR: This book is already checked out.");
                }
                return;
            }
        }
        System.out.println("\n ERROR: Book ID not found.");
    }

    public void returnBook(String id) {
        for (Book b : books) {
            if (b.getId().equalsIgnoreCase(id)) {
                if (!b.isAvailable()) {
                    b.setAvailable(true);
                    System.out.println("\n SUCCESS: '" + b.getTitle() + "' is now back in stock.");
                } else {
                    System.out.println("\n NOTICE: This book was already in the library.");
                }
                return;
            }
        }
        System.out.println("\nERROR: Invalid Book ID.");
    }
}
