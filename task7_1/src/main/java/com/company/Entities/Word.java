package main.java.com.company.Entities;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Objects;
import java.util.stream.Collectors;

public class Word {
    private ArrayList<Symbol> word = new ArrayList<Symbol>();

    public Word(String word) {
        word = word.toLowerCase();
        for(int i = 0; i < word.length(); i++) {
            Symbol currentSymbol = new Symbol(word.charAt(i));
            this.word.add(currentSymbol);
        }
    }

    public ArrayList<Symbol> getWord() {
        return word;
    }

    public void deletePunctuationalMarks() {
        this.word = this.word.stream()
                .filter(symbol -> !symbol.isPunctuationalMark())
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public boolean isEmpty() {
        return this.word.size() == 0;
    }

    @Override
    public String toString() {
        String res = "";
        return this.word.stream()
                .map(Symbol::getSymbol)
                .map(c -> c.toString())
                .reduce((str1, str2) -> str1 + str2)
                .get();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word1 = (Word) o;
        return this.toString().equals(word1.toString());
    }
}
