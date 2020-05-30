package utils;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private ArrayList<Car> cars;
    private Parking parking;
    private Scanner in;

    public Menu(ArrayList<Car> cars, Parking parking) {
        this.cars = cars;
        this.parking = parking;
        this.in = new Scanner(System.in);
    }

    public void showCars() {
        for(int i = 0; i < this.cars.size(); i++) {
            System.out.println((i + 1) + ". " + this.cars.get(i).toString());
        }
    }

    public void initMenu() {
        System.out.println("Choose a car from the following list:");
        this.showCars();
        int option = this.in.nextInt();

        if(option > 0 && option <= this.cars.size()) {
            Car chosenCar = this.cars.get(option - 1);
            if(chosenCar.getParkingPlaceNumber() == -1) {
                System.out.println("Car doesn't have its parking place, looking for one");
                if(chosenCar.findParkingPlace(this.parking)) {
                    System.out.println("Car is parked at the parking place №" + chosenCar.getParkingPlaceNumber());
                    System.out.println(this.parking.toString());
                }
                else {
                    System.out.println("Sorry, parking is full");
                }
            }
            else {
                System.out.println("Car is at parking place №" + chosenCar.getParkingPlaceNumber() + ", releasing it");
                chosenCar.releaseParkingPlace(this.parking);
                System.out.println(this.parking.toString());
            }
        }
        else {
            System.out.println("Wrong input, try again");
        }

        this.initMenu();
    }
}
