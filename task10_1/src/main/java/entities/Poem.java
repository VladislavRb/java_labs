package entities;

import java.util.ArrayList;
import java.util.Arrays;

public class Poem {
    private ArrayList<String> lines = new ArrayList<String>();

    public Poem(ArrayList<String> lines) {
        this.lines = lines;
    }

    public ArrayList<String> getLines() {
        return this.lines;
    }

    public Poem(String str) {
        Arrays.stream(str.split("\n")).forEach(s -> {
            if(!s.isEmpty()) {
                this.lines.add(s);
            }
        });
    }

    public int wordsAmount(String line) {
        return line.trim().split(" ").length;
    }

    public double getPoemLinesLengthCoeff() {
        return (double) this.lines.stream()
                .map(this::wordsAmount)
                .reduce(0, Integer::sum) / this.lines.size();
    }
}
