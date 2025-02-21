package _28_masked_party;

import _27_kindle.Book;
import _27_kindle.Kindle;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InviteList inviteList = new InviteList(LocalDateTime.now(), null, "Party Location", "City");
        Kindle kindle = new Kindle();

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Add Student to Invite List");
            System.out.println("2. Print Invite List");
            System.out.println("3. Research Students by Mask");
            System.out.println("4. Filter Students by Age");
            System.out.println("5. Save Invite List to File");
            System.out.println("6. Load Invite List from File");
            System.out.println("7. Add Book to Kindle");
            System.out.println("8. List Book in Kindle");
            System.out.println("9. Search Book by Author");
            System.out.println("10. Search Book by Title");
            System.out.println("11. Search Book by ISBN");
            System.out.println("12. Remove Book by ISBN");
            System.out.println("13. Save Kindle to File");
            System.out.println("14. Load Kindle from File");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter student birth date (YYYY-MM-DD): ");
                    LocalDate birthDate = LocalDate.parse(scanner.nextLine());
                    System.out.print("Enter student mask: ");
                    String mask = scanner.nextLine();
                    System.out.print("Enter student sex (m/f): ");
                    char sex = scanner.nextLine().charAt(0);
                    Student student = new Student(name, birthDate, mask, sex);
                    inviteList.addStudent(student);
                    break;
                case 2:
                    inviteList.printInviteList();
                    break;
                case 3:
                    System.out.print("Enter mask to search: ");
                    String searchMask = scanner.nextLine();
                    ArrayList<Student> students = inviteList.researchByMask(searchMask);
                    for (Student s : students) {
                        System.out.println(s);
                    }
                    break;
                case 4:
                    System.out.print("Enter age to filter: ");
                    int age = scanner.nextInt();
                    inviteList.filterByAge(age);
                    break;
                case 5:
                    _28_masked_party.FileManagement.saveToFile(inviteList);
                    break;
                case 6:
                    inviteList = new InviteList(LocalDateTime.now(), null, "Party Location", "City");
                    inviteList.getInvites().addAll(_28_masked_party.FileManagement.readFromFile());
                    break;
                case 7:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter book genre: ");
                    String genre = scanner.nextLine();
                    System.out.print("Enter book year: ");
                    int year = scanner.nextInt();
                    System.out.print("Enter book pages: ");
                    int pages = scanner.nextInt();
                    Book book = new Book(title, author, genre, year, pages);
                    kindle.addBook(book);
                    break;
                case 8:
                    kindle.listBooks();
                    break;
                case 9:
                    System.out.print("Enter author to search: ");
                    String searchAuthor = scanner.nextLine();
                    Book foundBookByAuthor = kindle.searchByAuthor(searchAuthor);
                    System.out.println(foundBookByAuthor != null ? foundBookByAuthor : "Book not found");
                    break;
                case 10:
                    System.out.print("Enter title to search: ");
                    String searchTitle = scanner.nextLine();
                    Book foundBookByTitle = kindle.searchByTitle(searchTitle);
                    System.out.println(foundBookByTitle != null ? foundBookByTitle : "Book not found");
                    break;
                case 11:
                    System.out.print("Enter ISBN to search: ");
                    int searchISBN = scanner.nextInt();
                    Book foundBookByISBN = kindle.searchByISBN(searchISBN);
                    System.out.println(foundBookByISBN != null ? foundBookByISBN : "Book not found");
                    break;
                case 12:
                    System.out.print("Enter ISBN to remove: ");
                    int removeISBN = scanner.nextInt();
                    boolean removed = kindle.removeBook(removeISBN);
                    System.out.println(removed ? "Book removed" : "Book not found");
                    break;
                case 13:
                    kindle.saveToFile();
                    break;
                case 14:
                    kindle.loadFromFile();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}