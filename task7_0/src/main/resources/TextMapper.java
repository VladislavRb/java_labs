package main.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.Random;

public class TextMapper {
    private ArrayList<String> lines;
    private int[] values;
    private char symbol;
    private int k;

    public TextMapper(String text, char symbol, int k) {
        Random generator = new Random();
        this.lines = Arrays.stream(text.split("\n"))
                .collect(Collectors.toCollection(ArrayList::new));
        this.values = new int[this.lines.size()];
        for(int i = 0; i < this.lines.size(); i++) {
            this.values[i] = generator.nextInt(2);
        }
        this.symbol = symbol;
        this.k = k;
    }

    public String getNewLineIf0(String line) {
        return line.replace(this.symbol + "", "");
    }

    public String getNewLineIf1(String line) {
        if(this.k < line.length()) {
            return line.substring(0, k + 1) + this.symbol + line.substring(k + 1);
        }
        return line;
    }

    public ArrayList<String> getMappedLines() {
        for(int item: this.values) {
            System.out.println(item);
        }
        ArrayList<String> newLines = new ArrayList<>();
        for(int i = 0; i < this.lines.size(); i++) {
            if(this.values[i] == 0) {
                newLines.add(this.getNewLineIf0(this.lines.get(i)));
            }
            else {
                newLines.add(this.getNewLineIf1(this.lines.get(i)));
            }
        }

        return newLines;
    }
}
