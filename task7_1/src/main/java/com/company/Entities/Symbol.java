package main.java.com.company.Entities;

import java.util.Arrays;

public class Symbol {
    private char symbol;

    public Symbol(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return this.symbol;
    }

    public int getCode() {
        return (int)this.symbol;
    }

    public boolean isPunctuationalMark() {
        int[] pmCodes = {33, 34, 39, 40, 41, 42, 43, 44, 45, 46, 47, 58, 59, 63, 96, 123, 124, 125};
        for (int pmCode : pmCodes) {
            if (pmCode == this.getCode()) {
                return true;
            }
        }
        return false;
    }
}
