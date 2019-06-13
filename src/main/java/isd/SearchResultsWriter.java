package isd;

import javafx.util.Pair;

import java.io.PrintWriter;
import java.util.List;

public class SearchResultsWriter {

    private PrintWriter responseWriter;

    public SearchResultsWriter() {
    }

    public void setResponseWriter(PrintWriter responseWriter) {
        this.responseWriter = responseWriter;
    }

    public void writeSearchResults(List<Pair<String, Integer>> searchResults) {
        this.writeTableStartAndProps();
        this.writeTableName();
        this.writeTableHeader();
        for (Pair<String, Integer> oneResultPoint : searchResults) {
            this.writeOneSearchResultPoint(oneResultPoint);
        }
        this.writeTableEnd();
        this.writeGoBackLink();
    }

    private void writeTableStartAndProps() {
        this.responseWriter.print("<table rules=\"all\" frame=\"border\" style=\"min-width: 420px;\">");
    }

    private void writeTableName() {
        this.responseWriter.print("<b><caption><h1>Search results</caption></h1></b>");
    }

    private void writeTableHeader() {
        this.responseWriter.print(
                "<tr>" +
                        "<th>File</th> <th>Matches count</th>" +
                        "</tr>"
        );
    }

    private void writeOneSearchResultPoint(Pair<String, Integer> oneResultPoint) {
        this.responseWriter.print(
                "<tr>" +
                        "<td>" + oneResultPoint.getKey() + "</td> <td>" + oneResultPoint.getValue() + "</td>" +
                        "</tr>"
        );
    }

    private void writeTableEnd() {
        this.responseWriter.print("</table>");
    }

    private void writeGoBackLink() {
        this.responseWriter.print("<br>" +
                "<a href=\"/\">Go back to searching</a>");
    }
}
