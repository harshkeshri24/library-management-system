public class Book {
    private String id;
    private String title;
    private String author;
    private boolean isAvailable;

    public Book(String id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    // Getters
    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isAvailable() { return isAvailable; }

    // Setters
    public void setAvailable(boolean available) { isAvailable = available; }

    // Professional Card Display
    public void displayCard() {
        String status = isAvailable ? " [ AVAILABLE ] " : " [ CHECKED OUT ]";
    

        System.out.println("  ┌──────────────────────────────────────────────────┐");
        System.out.printf("  │  BOOK ID : %-37s │%n", id);
        System.out.printf("  │  TITLE   : %-37s │%n", title);
        System.out.printf("  │  AUTHOR  : %-37s │%n", author);
        System.out.printf("  │  STATUS  : %-35s │%n",status);
        System.out.println("  └──────────────────────────────────────────────────┘");
    }
}
