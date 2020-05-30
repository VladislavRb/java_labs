package com.company;

public class CosmicObject {
    private String name;
    private int mass;

    public CosmicObject(String name, int mass) {
        this.name = name;
        this.mass = mass;
    }

    public CosmicObject() {
        this("undefined", 0);
    }

    public String getName() {  return this.name; }

    public int getMass() { return this.mass; }

    @Override
    public String toString() {
        return "Cosmic object " + this.name + " , mass: " + this.mass + " km";
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;

        CosmicObject co = (CosmicObject) obj;
        return this.name == co.name && this.mass == co.mass;
    }
}
