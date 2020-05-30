package main.java.com.company.Entities;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.stream.Collectors;

public class Text {
    private ArrayList<Sentence> sentences = new ArrayList<>();
    private ArrayList<Word> words = new ArrayList<>();

    public Text(String text) {
        ArrayList<String> sentencesArray = new ArrayList<>();
        String curSentence = "";
        for(int i = 0; i < text.length(); i++) {
            char curSymb = text.charAt(i);
            if(curSymb == '?' || curSymb == '!' || curSymb == '.') {
                sentencesArray.add(curSentence.trim());
                curSentence = "";
            }
            else {
                curSentence += curSymb;
            }
        }
        for(String sentence: sentencesArray) {
            Sentence currentSentence = new Sentence(sentence);
            this.sentences.add(currentSentence);
            for(Word word: currentSentence.wordArrayList()){
                this.words.add(word);
            }
        }
    }

    public void sortWords() {
        this.words = this.words.stream()
                .sorted(Comparator.comparing(Word::toString))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public void distinctWords() {
        ArrayList<Word> filteredWords = new ArrayList<>();
        for(Word word: this.words) {
            if(!filteredWords.contains(word)) {
                filteredWords.add(word);
            }
        }
        this.words = filteredWords;
    }

    public String getFormattedString() {
        String res = "";
        char wordFirstChar = this.words.get(0).getWord().get(0).getSymbol();
        for(Word word: this.words) {
            char currentWordFirstChar = word.getWord().get(0).getSymbol();
            if(currentWordFirstChar != wordFirstChar) {
                wordFirstChar = currentWordFirstChar;
                res += "\n";
            }
            res += word.toString() + " ";
        }

        return res;
    }
}
