package entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class PoemList {
    private ArrayList<Poem> poems = new ArrayList<>();

    public PoemList(String poemsString) {
        Arrays.stream(poemsString.split("//")).forEach(s -> this.poems.add(new Poem(s)));
    }

    public ArrayList<Poem> getSortedPoems() {
        return this.poems.stream()
                .sorted(Comparator.comparingDouble(Poem::getPoemLinesLengthCoeff))
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
