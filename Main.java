import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library lib = new Library();
        Scanner sc = new Scanner(System.in);
        boolean exit = false;

        lib.addBook(new Book("B001", "The Great Gatsby", "F. Scott Fitzgerald"));
        lib.addBook(new Book("B002", "1984", "George Orwell"));

        while (!exit) {
            System.out.println("\n================================================");
            System.out.println("        SYSTEM: LIBRARY MANAGEMENT v1.0         ");
            System.out.println("================================================");
            System.out.println(" [1]  ADD NEW BOOK");
            System.out.println(" [2]  SEARCH BY TITLE/AUTHOR");
            System.out.println(" [3]  ISSUE A BOOK");
            System.out.println(" [4]  RETURN A BOOK");
            System.out.println(" [5]  VIEW ALL BOOKS");
            System.out.println(" [6]  EXIT SYSTEM");
            System.out.print("\nSELECT ACTION > ");

            int choice = 0;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("[!] Please enter a valid number (1-6).");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter Unique ID: "); String id = sc.nextLine();
                    System.out.print("Enter Title    : "); String title = sc.nextLine();
                    System.out.print("Enter Author   : "); String author = sc.nextLine();
                    lib.addBook(new Book(id, title, author));
                    break;
                case 2:
                    System.out.print("Search Title/Author: ");
                    lib.search(sc.nextLine());
                    break;
                case 3:
                    System.out.print("Enter Book ID to Issue: ");
                    lib.issueBook(sc.nextLine());
                    break;
                case 4:
                    System.out.print("Enter Book ID to Return: ");
                    lib.returnBook(sc.nextLine());
                    break;
                case 5:
                    lib.showAllBooks();
                    break;
                case 6:
                    exit = true;
                    System.out.println("\nSystem shutting down. Have a productive day!");
                    break;
                default:
                    System.out.println("[!] Invalid option.");
            }

            if (!exit) {
                System.out.println("\nPress [ENTER] to return to Main Menu...");
                sc.nextLine();
            }
        }
        sc.close();
    }
}
