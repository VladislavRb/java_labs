package com.company;

import utils.Car;
import utils.Menu;
import utils.Parking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Parking parking = new Parking(5);
        ArrayList<Car> cars = new ArrayList<Car>();

        cars.add(new Car("opel", "1234AA5"));
        cars.add(new Car("peugeot", "3425KL7"));
        cars.add(new Car("kia", "7777TT7"));
        cars.add(new Car("mazda", "5678AZ7"));
        cars.add(new Car("volkswagen", "1984EE1"));
        cars.add(new Car("toyota", "1337HE4"));
        cars.add(new Car("nissan", "9436OX6"));

        Menu menu = new Menu(cars, parking);
        System.out.println(parking.toString());
        menu.initMenu();
    }
}
