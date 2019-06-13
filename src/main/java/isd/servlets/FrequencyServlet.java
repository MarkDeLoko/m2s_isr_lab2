package isd.servlets;

import isd.DB;
import javafx.util.Pair;
import isd.SearchResultsWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class FrequencyServlet extends javax.servlet.http.HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DB db = new DB();
        db.init();
        String word = req.getParameter("inputWord");
        SearchResultsWriter searchResultsWriter = new SearchResultsWriter();
        searchResultsWriter.setResponseWriter(resp.getWriter());
        List<Pair<String, Integer>> results = db.getFrequencyOfWordInBook(word);
        searchResultsWriter.writeSearchResults(results);
    }
}
