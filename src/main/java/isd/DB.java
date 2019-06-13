package isd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import javafx.util.Pair;

import java.util.List;

public class DB {
    public String url = "jdbc:mysql://localhost:3306/book" +
            "?verifyServerCertificate=false" +
            "&useSSL=false" +
            "&requireSSL=false" +
            "&useLegacyDatetimeCode=false" +
            "&amp" +
            "&serverTimezone=UTC";

    public void init() {
        String driverName = "com.mysql.jdbc.Driver";

        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            System.out.println("Can't get class. No driver found");
            e.printStackTrace();
            return;
        }
    }


    public void addFrequencyAllWordsForBook(BookImpl book, Map<String, Long> countFrequencyAllWords) {

        try (Connection connection = DriverManager.getConnection(url, "root", "root")) {
            PreparedStatement stm = connection.prepareStatement(
                    "INSERT INTO book.frequency_word (book, word, frequency) \n" +
                            "VALUES (?, ?, ?)");
            for (Map.Entry<String, Long> entry : countFrequencyAllWords.entrySet()) {
                stm.setString(1, book.getName());
                stm.setString(2, entry.getKey());
                stm.setLong(3, entry.getValue());
                stm.addBatch();
            }
            stm.executeBatch();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList getFrequencyOfWordInBook(String word) {
        try (Connection connection = DriverManager.getConnection(url, "root", "root")) {
            PreparedStatement stm = connection.prepareStatement(
                    "SELECT book.frequency_word.book, book.frequency_word.frequency FROM book.frequency_word " +
                            "WHERE book.frequency_word.word=? order by book.frequency_word.frequency desc");

            stm.setString(1, word);
            stm.execute();
            ResultSet resultSet = stm.getResultSet();
            List<Pair<String, Integer>> listPair = new ArrayList();
            while (resultSet.next()) {
                listPair.add(new Pair(resultSet.getString(1), Integer.parseInt(resultSet.getString(2))));
            }
            return (ArrayList) listPair;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

