package _27_kindle;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pick;
        Kindle kindle = new Kindle();
        Book book = new Book("The Great Gatsby", "F. Scott Fitzgerald", "Novel", 1925, 180);

        do {
            System.out.println("1. Add a book");
            System.out.println("2. List all books");
            System.out.println("3. Search for a book");
            System.out.println("4. Search for a book by author");
            System.out.println("5. Search for a book by ISBN");
            System.out.println("6. Remove a book");
            System.out.println("7. Load books from file");
            System.out.println("8. Save books to file");
            System.out.println("0. Exit");
            System.out.print("Pick: ");
            pick = scanner.nextInt();

            switch (pick) {
                case 1:
                    System.out.println("Adding a book...");
                    kindle.addBook(book);
                    break;
                case 2:
                    System.out.println("Listing all books...");
                    kindle.listBooks();
                    break;
                case 3:
                    System.out.println("Searching for a book...");
                    System.out.print("Enter the title of the book: ");
                    scanner.nextLine();
                    String title = scanner.nextLine();
                    Book foundBook = kindle.searchByTitle(title);
                    if (foundBook != null) {
                        System.out.println("Book found: " + foundBook.getTitle());
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 4:
                    System.out.println("Searching for a book...");
                    System.out.print("Enter the author of the book: ");
                    scanner.nextLine();
                    String author = scanner.nextLine();
                    Book foundBook2 = kindle.searchByAuthor(author);
                    if (foundBook2 != null) {
                        System.out.println("Book found: " + foundBook2.getTitle());
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 5:
                    System.out.println("Searching for a book...");
                    System.out.print("Enter the ISBN of the book: ");
                    int ISBN = scanner.nextInt();
                    Book foundBook3 = kindle.searchByISBN(ISBN);
                    if (foundBook3 != null) {
                        System.out.println("Book found: " + foundBook3.getTitle());
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 6:
                    System.out.println("Removing a book...");
                    System.out.print("Enter the ISBN of the book: ");
                    int ISBN2 = scanner.nextInt();
                    if (kindle.removeBook(ISBN2)) {
                        System.out.println("Book removed.");
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 7:
                    System.out.println("Loading books from file...");
                    kindle.loadFromFile();
                    break;
                case 8:
                    System.out.println("Saving books to file...");
                    kindle.saveToFile();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } while (pick != 0);
    }
}
