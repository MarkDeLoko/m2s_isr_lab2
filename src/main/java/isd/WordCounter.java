package isd;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class WordCounter   {

    public long countWordInBook(String word, String text) {
       return Arrays.stream(text.split(" "))
               .filter(s -> s.equalsIgnoreCase(word))
               .count();
    }

    public Map<String, Long> countFrequencyAllWords(String text) {
        return Arrays.stream(text.split(" "))
                .parallel()
                .map(s -> s.replaceAll("[^a-z^A-Z^à-ÿ]", "").toLowerCase())
                .collect(Collectors.toMap(String::toString, s -> 1L, (aLong, aLong2) -> aLong + aLong2));
    }

}
