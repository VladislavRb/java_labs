package main.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class TextMapper {
    private ArrayList<String> allWords = new ArrayList<>();
    private ArrayList<String> searchWords;

    public TextMapper(ArrayList<String> lines, ArrayList<String> searchWords) {
        this.searchWords = searchWords;

        for(String line: lines) {
            String[] wordsInLine = line.split(" ");
            for(String word: wordsInLine) {
                if (!word.isEmpty()) {
                    this.allWords.add(word
                            .toLowerCase()
                            .replace(".", "")
                            .replace(",", ""));
                }
            }
        }
    }

    public ArrayList<String> getAllWords() {
        return this.allWords;
    }

    public int countSearchWordNumber(String searchWord) {
        int counter = 0;
        for(String s: this.allWords) {
            if (s.equals(searchWord)) {
                counter++;
            }
        }
        return counter;
    }

    public ArrayList<String> getSortedSearchWords() {
        return this.searchWords.stream()
                .sorted(Comparator.comparingInt(this::countSearchWordNumber))
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
