package com.company;

public class Planet extends CosmicObject{
    private int radius, index;

    public Planet(String name, int mass, int radius, int index) {
        super(name, mass);

        this.radius = radius;
        this.index = index;
    }

    public Planet() {
        this("", 0, 0, 0);
    }

    public int getRadius() { return this.radius; }

    public int getIndex() { return this.index; }

    @Override
    public String toString() {
        return "Planet " + super.getName() +
                ", mass: " + super.getMass() + "E23 kg" +
                ", radius: " + this.radius + " km" +
                ", stellar system index: " + this.index;
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

        Planet p = (Planet) obj;
        return super.equals(p) && this.radius == p.radius && this.index == p.index;
    }
}
