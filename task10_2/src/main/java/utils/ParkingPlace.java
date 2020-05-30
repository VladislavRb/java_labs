package utils;

public class ParkingPlace {
    private int number;
    private Car car = null;

    public ParkingPlace(int number, Car car) {
        this.number = number;
        this.car = car;
    }

    public boolean isFree() {
        return this.car == null;
    }

    public void putCar(Car car) {
        this.car = car;
    }

    public void releaseCar() {
        this.car = null;
    }

    @Override
    public String toString() {
        return "№" + this.number + ", " + (this.isFree() ? "free" : this.car.toString());
    }
}
