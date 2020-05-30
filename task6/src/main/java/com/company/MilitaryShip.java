package main.java.com.company;

import main.java.com.company.Ship;

public abstract class MilitaryShip implements Ship {
    public int getMass() {
        return 0;
    }

    public String getModel() {
        return null;
    }

    public String getName() {
        return null;
    }

    public abstract int getCaliber();

    public abstract int getGunsAmount();
}
