package com.company;

public class StellarSystem {
    private Star star;
    private PlanetSet[] planetSets;

    public StellarSystem(Star star, PlanetSet[] planetSets) {
        this.star = star;
        this.planetSets = planetSets;
    }

    public StellarSystem() {
        this(new Star(), new PlanetSet[0]);
    }

    public Star getStar() { return this.star; }

    public PlanetSet[] getPlanetSets() { return this.planetSets; }

    public int planetsAmount() {
        return this.planetSets.length;
    }

    public void addPlanetSet(PlanetSet newPlanetSet) throws Exception {
        if (!newPlanetSet.isEmpty()) {
            int n = this.planetSets.length;
            PlanetSet[] newPlanetSets = new PlanetSet[n + 1];

            for(int i = 0; i < n; i++) {
                newPlanetSets[i] = this.planetSets[i];
            }

            newPlanetSets[n] = newPlanetSet;

            this.planetSets = newPlanetSets;
        }
        else {
            throw new Exception("Error: new planet set is empty");
        }
    }

    @Override
    public String toString() {
        String res = "-----------------------------------------\n";
        res += this.star.toString();

        for(PlanetSet ps : this.planetSets) {
            res += "\n\n" + ps.toString();
        }

        return res;
    }

    @Override
    public int hashCode() {
        int res = this.star.hashCode();

        for(PlanetSet ps : this.planetSets) {
            res += ps.hashCode();
        }

        return res;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;

        StellarSystem ss = (StellarSystem) obj;
        if(!ss.star.equals(this.star)) { return false; }

        for(int i = 0; i < ss.planetSets.length; i++) {
            if(!ss.planetSets[i].equals(this.planetSets[i])) { return false; }
        }

        return true;
    }
}
