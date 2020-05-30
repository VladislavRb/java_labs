package com.company;

public class OrbitalBody extends CosmicObject{
    private Planet planet;
    private int radius;

    public OrbitalBody(String name, Planet planet, int mass, int radius) {
        super(name, mass);
        this.planet = planet;
        this.radius = radius;
    }

    public OrbitalBody() {
        this("", new Planet(), 0, 0);
    }

    public Planet getPlanet() { return this.planet; }

    public int getRadius() { return this.radius; }

    @Override
    public String toString() {
        return super.getName() +
                ", planet " + this.planet.getName() +
                ", mass: " + super.getMass() + "E21 kg" +
                ", radius: " + this.radius + " km";
    }

    @Override
    public int hashCode() {
        return super.hashCode() + this.planet.hashCode() + this.radius;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;

        OrbitalBody ob = (OrbitalBody) obj;
        return super.equals(ob) && this.planet.equals(ob.planet) && this.radius == ob.radius;
    }
}
