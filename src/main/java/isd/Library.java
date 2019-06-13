package isd;

import java.io.File;
import java.util.*;

public class Library {

    private final Map<String, BookImpl> books;

    public Library(String pathToLibrary) {
        books = createBooks(pathToLibrary);

    }

    private Map<String, BookImpl> createBooks(String pathToLibrary) {
        List<File> files = Arrays.asList(new File(pathToLibrary).listFiles());
        Map<String, BookImpl> books = new HashMap<>();

        for (File file : files) {
            BookImpl book = new BookImpl(file);
            books.put(book.getName(), book);
        }
        return books;
    }

    public List<String> getListNameOfBooks() {
        List<String> listNameOfBooks = new ArrayList<String>();
        books.forEach((name, book) -> listNameOfBooks.add(name));
        return listNameOfBooks;
    }

    public BookImpl getBook(String book) {
        return books.get(book);
    }

    public List<BookImpl> getListOfBooks() {
        return new ArrayList<>(books.values());
    }
}
