package _27_kindle;

import java.util.HashMap;
import java.util.Map;

public class Kindle {
    Map<Integer, Book> map = new HashMap<>();

    public void addBook(Book book) {
        map.put(book.getISBN(), book);
    }

    public void listBooks() {
        for (Map.Entry<Integer, Book> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().getTitle());
        }
    }

    public Book searchByAuthor(String author) {
        for (Book book : map.values()) {
            if (book.getAuthor().equals(author)) {
                return book;
            }
        }
        return null;
    }

    public Book searchByTitle(String title) {
        for (Book book : map.values()) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }

    public Book searchByISBN(int ISBN) {
        return map.get(ISBN);
    }

    public boolean removeBook(int ISBN) {
        return map.remove(ISBN) != null;
    }

    public void loadFromFile() {
        map = FileManagement.readFromFile();
    }

    public void saveToFile() {
        FileManagement.saveToFile(this);
    }
}
