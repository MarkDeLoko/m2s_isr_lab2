package isd;

import java.io.*;
import java.util.*;
import java.util.Map;


public final class CountWords {

    public static void main(String[] args) {

        try {
            String fileName = "src/main/res/Harry_Potter.txt";
            final BufferedReader bufferedReader;
            bufferedReader = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(fileName)));
            String line;
            int count = 0;
            Map<String, Integer> wordToCount = new TreeMap<>();
            while ((line = bufferedReader.readLine()) != null) {
                for (String word : line.split(" "))
                {
                    wordToCount.put(word, wordToCount.getOrDefault(word, 0) + 1);
                }
            }
            System.out.println(wordToCount);
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}