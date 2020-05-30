package utils;

import java.util.LinkedList;

public class Car {
    private String model;
    private String number;
    private int parkingPlaceNumber;

    public Car(String model, String number) {
        this.model = model;
        this.number = number;
        this.parkingPlaceNumber = -1;
    }

    public Car() {
        this("", "0000AA0");
    }

    public int getParkingPlaceNumber() {
        return this.parkingPlaceNumber;
    }

    public boolean findParkingPlace(Parking parking) {
        int i = 0;
        while(i < parking.getParkingLength()) {
            if(parking.isFreeAt(i)) {
                parking.putCarAtParkingPlace(i, this);
                this.parkingPlaceNumber = i;
                return true;
            }
            i++;
        }

        return false;
    }

    public void releaseParkingPlace(Parking parking) {
        parking.removeCarFromParkingPlace(this.parkingPlaceNumber);
        this.parkingPlaceNumber = -1;
    }

    @Override
    public String toString() {
        return this.model + ", " + this.number;
    }
}
