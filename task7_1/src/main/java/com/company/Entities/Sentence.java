package main.java.com.company.Entities;

import java.util.ArrayList;

public class Sentence {
    private ArrayList<Word> sentence = new ArrayList<Word>();

    public Sentence(String sentence) {
        String[] wordsArray = sentence.split(" ");
        for(String wordItem: wordsArray) {
            Word word = new Word(wordItem);
            word.deletePunctuationalMarks();
            if(!word.isEmpty()) {
                this.sentence.add(word);
            }
        }
    }

    public ArrayList<Word> wordArrayList() {
        return sentence;
    }
    public ArrayList<String> stringArrayList() {
        ArrayList<String> stringArrayList = new ArrayList<>();
        for(Word word: this.sentence) {
            stringArrayList.add(word.toString());
        }
        return stringArrayList;
    }
}
