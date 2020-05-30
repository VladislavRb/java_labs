package utils;

import java.util.LinkedList;

public class Parking {
    private int parkingLength;
    private LinkedList<ParkingPlace> parkingPlaces = new LinkedList<>();

    public Parking(int parkingLength) {
        this.parkingLength = parkingLength;
        for(int i = 0; i < parkingLength; i++) {
            this.parkingPlaces.add(new ParkingPlace(i, null));
        }
    }

    public int getParkingLength() {
        return this.parkingLength;
    }

    public boolean isFreeAt(int parkingPlaceNumber) {
        return this.parkingPlaces.get(parkingPlaceNumber).isFree();
    }

    public void putCarAtParkingPlace(int parkingPlaceNumber, Car car) {
        this.parkingPlaces.get(parkingPlaceNumber).putCar(car);
    }

    public void removeCarFromParkingPlace(int parkingPlaceNumber) {
        this.parkingPlaces.get(parkingPlaceNumber).releaseCar();
    }

    @Override
    public String toString() {
        String parkingStr = "Parking\n----------\n";
        for(ParkingPlace parkingPlace: this.parkingPlaces) {
            parkingStr += parkingPlace.toString() + "\n----------\n";
        }

        return parkingStr;
    }
}
