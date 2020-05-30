package main.java.com.company;

import java.util.ArrayList;
import java.util.List;

public class Catalog {
    private String catalogName;
    private String message;
    private BookCache bookCache;
    private PersonCache personCache;

    //anonymous class
    class MessageManager{
        public String getMessage() {
            return "";
        }
    }

    public Catalog(String catalogName) {
        this.catalogName = catalogName;

        MessageManager messageManager = new MessageManager() {
            @Override
            public String getMessage() {
                return "book and person are added";
            }
        };
        this.message = messageManager.getMessage();

        this.bookCache = new BookCache();
        this.personCache = new PersonCache();
    }

    public void add(Person person, String book) {
        this.bookCache.append(book);
        this.personCache.append(person);

        System.out.println(this.message);
    }

    @Override
    public String toString() {
        String res = "[";
        boolean isStart = true;
        for(String book_str: this.bookCache.getBookArr()) {
            if(isStart) {
                res += book_str;
                isStart = false;
            }
            else {
                res += "," + book_str;
            }
        }
        res += "]\n[";

        isStart = true;
        for(Person person: this.personCache.getPersonArr()) {
            if(isStart) {
                res += person.toString();
                isStart = false;
            }
            else {
                res += "," + person.toString();
            }
        }

        return res + "]";
    }

    private class BookCache {
        private List<String> bookArr;

        public BookCache() {
            this.bookArr = new ArrayList<String>();
        }

        public List<String> getBookArr() { return this.bookArr; }

        public void append(String book_str) {
            this.bookArr.add(book_str);
        }
    }

    private static class PersonCache {
        private  List<Person> personArr;

        public PersonCache() {
            this.personArr = new ArrayList<Person>();
        }

        public List<Person> getPersonArr() { return this.personArr; }

        public void append(Person person) {
            this.personArr.add(person);
        }
    }
}
