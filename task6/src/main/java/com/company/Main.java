package com.company;

import main.java.com.company.Carrier;

public class Main {

    public static void main(String[] args) {
        Carrier carrier = new Carrier(100, "model1", "name1", 70, 4, 1000);
        System.out.println(
                "carrier1: mass = " + carrier.getMass() + " tons" +
                ", model = " + carrier.getModel() +
                ", name = " + carrier.getName() +
                ", caliber = " + carrier.getCaliber() + "mm" +
                ", amount of guns = " + carrier.getGunsAmount() +
                ", capacity = " + carrier.getCapacity() + " items");
    }
}
