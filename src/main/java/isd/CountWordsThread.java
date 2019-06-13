package isd;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class CountWordsThread {

    public static void main(String[] args) {

        String pathToLibrary = "src/main/res/";
        Library library = new Library(pathToLibrary);
        DB db = new DB();
        CountWordsThread countManager = new CountWordsThread(library, db);
        countManager.countFrequencyAllWordsInAllBooks();

        }

    private Library library;
    private DB db;

    public CountWordsThread(Library library, DB db) {
        this.library = library;
        this.db = db;
        db.init();
    }

    public void countFrequencyAllWordsInAllBooks() {
        List<BookImpl> books = library.getListOfBooks();
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        for (BookImpl book : books) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    WordCounter wordCounter = new WordCounter();
                    Map<String, Long> countFrequencyAllWords = wordCounter.countFrequencyAllWords(book.getText());
                    db.addFrequencyAllWordsForBook(book, countFrequencyAllWords);
                }
            });
        }
        executorService.shutdown();
        while (!executorService.isTerminated()) ;
    }
}




