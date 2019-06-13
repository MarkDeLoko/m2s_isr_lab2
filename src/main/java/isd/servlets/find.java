package isd.servlets;

import isd.DB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "find")
public class find extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        DB db = new DB();
        String book = request.getParameter("inputBook");
        String word = request.getParameter("inputWord");

//        long frequencyOfWordInBook = db.getFrequencyOfWordInBook(book, word);
//        writer.append(String.valueOf(frequencyOfWordInBook));
//        writer.print(String.valueOf(frequencyOfWordInBook));
//        writer.print(String.valueOf(66));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
