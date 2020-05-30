package com.company;

public class Star extends CosmicObject{
    private int radius;

    public Star(String name, int mass, int radius) {
        super(name, mass);

        this.radius = radius;
    }

    public Star() {
        this("", 0, 0);
    }

    public int getRadius() { return this.radius; }

    @Override
    public String toString() {
        return "Star " + super.getName() +
                ", mass: " + super.getMass() + "E29 kg" +
                ", radius: " + this.radius + " km";
    }

    @Override
    public int hashCode() {
        return (int)(super.getMass() + this.radius + ((super.getName() == null) ? 0 : super.hashCode()));
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;

        Star s = (Star) obj;
        return super.equals(s) && this.radius == s.radius;
    }
}
