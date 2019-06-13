package isd;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class BookImpl {
    private String name;
    private String text;

    public BookImpl(File file) {
        this.name = file.getName();
        this.text = getTextFromFile(file);
    }

    private String getTextFromFile(File file) {
        StringBuilder stringBuilder = new StringBuilder();
        try (FileReader reader = new FileReader(file)) {
            Scanner scanner = new Scanner(reader);
            while (scanner.hasNextLine()) {
                stringBuilder.append(scanner.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }
}
