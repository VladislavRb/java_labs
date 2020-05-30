package com.company;

import main.java.com.company.Catalog;
import main.java.com.company.Person;

public class Main {

    public static void main(String[] args) {
        Catalog catalog = new Catalog("my catalog");
        catalog.add(new Person("Vlad", 18), "Programming on Java");
        catalog.add(new Person("Petya", 16), "I love minecraft");
        catalog.add(new Person("Dasha", 21), "Cooking book");

        System.out.println(catalog.toString());
    }
}
