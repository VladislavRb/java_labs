package com.company;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StellarSystemTest {

    @Test
    void planetsAmount() {
        Star sun = new Star("Sun", 20, 696340);



        Planet earth = new Planet("Earth", 59, 6371, 1);

        OrbitalBody moon = new OrbitalBody("Moon", earth, 73, 1737);
        OrbitalBody[] earthMoons = {moon};

        PlanetSet earthSet = new PlanetSet(earth, earthMoons);



        Planet mars = new Planet("Mars", 6, 3390, 2);

        OrbitalBody deimos = new OrbitalBody("Deimos", mars, 1, 6200);
        OrbitalBody phobos = new OrbitalBody("Phobos", mars, 2, 11267);
        OrbitalBody[] marsMoons = {deimos, phobos};

        PlanetSet marsSet = new PlanetSet(mars, marsMoons);



        PlanetSet[] planetSets = {earthSet, marsSet};
        StellarSystem minimizedSolarSystem = new StellarSystem(sun, planetSets);

        int expected = 2;
        int actual = minimizedSolarSystem.planetsAmount();
        Assert.assertEquals(expected, actual);
    }
}