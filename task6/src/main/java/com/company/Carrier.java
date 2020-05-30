package main.java.com.company;

import main.java.com.company.MilitaryShip;

public class Carrier extends MilitaryShip {
    private int mass, caliber, gunsAmount, capacity;
    private String model, name;

    public Carrier(int mass, String model, String name, int caliber, int gunsAmount, int capacity) {
        this.mass = mass;
        this.caliber = caliber;
        this.gunsAmount = gunsAmount;
        this.capacity = capacity;
        this.model = model;
        this.name = name;
    }

    public Carrier() {
        this(0, "", "", 0, 0, 0);
    }

    @Override
    public int getMass() {
        return mass;
    }

    @Override
    public int getCaliber() {
        return caliber;
    }

    @Override
    public int getGunsAmount() {
        return gunsAmount;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }
}
