package com.company;

import main.java.com.company.Entities.Symbol;
import main.java.com.company.Entities.Text;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        String str = "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the first true generator on the Internet. It uses a dictionary of over two hundred Latin words, combined with a handful of model sentence structures, to generate Lorem Ipsum which looks reasonable. The generated Lorem Ipsum is therefore always free from repetition, injected humour, or non-characteristic words etc.";
        Text text = new Text(str);
        text.sortWords();
        text.distinctWords();
        System.out.println(text.getFormattedString());
    }
}
