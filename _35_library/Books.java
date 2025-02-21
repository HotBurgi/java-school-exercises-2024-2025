package _35_library;

import java.util.HashMap;

public class Books {
    private final HashMap<Integer, Book> books;

    public Books() {
        this.books = new HashMap<>();
    }

    public boolean addBook(Book book) {
        if (this.books.containsKey(book.getISBNNumber())) {
            return false;
        }
        this.books.put(book.getISBNNumber(), book);
        return true;
    }

    public boolean removeBook(Book book) {
        if (!this.books.containsKey(book.getISBNNumber())) {
            return false;
        }
        this.books.containsKey(book.getISBNNumber());
        return true;
    }

    public void printBooks() {
        for (Book book : this.books.values()) {
            System.out.println(book.toString());
        }
    }
}
