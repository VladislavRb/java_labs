package com.company;

public class PlanetSet {
    private Planet planet;
    private OrbitalBody[] satellites;
    private boolean isEmpty;

    public PlanetSet(Planet planet, OrbitalBody ... satellites) {
        this.planet = planet;
        this.satellites = satellites;
        this.isEmpty = false;
    }

    public PlanetSet() {
        this(new Planet(), new OrbitalBody[0]);
        this.isEmpty = true;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public Planet getPlanet() { return this.planet; }

    public OrbitalBody[] getSatellites() {
        return this.satellites;
    }

    @Override
    public String toString() {
        String res = this.planet.toString() + "\nMoons:";

        for(OrbitalBody st : this.satellites) {
            res += "\n\t" + st.toString();
        }

        return res;
    }

    @Override
    public int hashCode() {
        int res = this.planet.hashCode();

        for(OrbitalBody st : this.satellites) {
            res += st.hashCode();
        }

        return res;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;

        PlanetSet ps = (PlanetSet) obj;
        if(!ps.planet.equals(this.planet)) { return false; }

        for(int i = 0; i < ps.satellites.length; i++) {
            if(!ps.satellites[i].equals(this.satellites[i])) { return false; }
        }

        return true;
    }
}
