package main.java.com.company;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() { this("", 0); }

    @Override
    public String toString() {
        return this.name + " " + this.age;
    }
}
