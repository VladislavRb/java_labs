package com.company;

import connector.DBUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    static Logger logger = LogManager.getLogger(Main.class.getName());

    public static void main(String[] args) {
        DBUtils dbUtils = new DBUtils();

        Star sun = new Star("Sun", 20, 696340);

        //Earth
        Planet earth = dbUtils.getPlanetByName("Earth");

        OrbitalBody moon = new OrbitalBody("Moon", earth, 73, 1737);
        OrbitalBody[] earthMoons = {moon};

        PlanetSet earthSet = new PlanetSet(earth, earthMoons);

        //Mars
        Planet mars = dbUtils.getPlanetByName("Mars");

        OrbitalBody deimos = new OrbitalBody("Deimos", mars, 1, 6200);
        OrbitalBody phobos = new OrbitalBody("Phobos", mars, 2, 11267);
        OrbitalBody[] marsMoons = {deimos, phobos};

        PlanetSet marsSet = new PlanetSet(mars, marsMoons);

        PlanetSet[] planetSets = {earthSet, marsSet};
        StellarSystem minimizedSolarSystem = new StellarSystem(sun, planetSets);
        System.out.println(minimizedSolarSystem.toString() + "\n");

        System.out.println("amount of planets: " + minimizedSolarSystem.planetsAmount() + "\n");

        System.out.println("Star name: " + minimizedSolarSystem.getStar().getName() + "\n");

        //Jupiter
        Planet jupiter = dbUtils.getPlanetByName("Jupiter");

        OrbitalBody europe = new OrbitalBody("Europe", jupiter, 48, 1560);
        OrbitalBody io = new OrbitalBody("Io", jupiter, 89, 1821);
        OrbitalBody ganymede = new OrbitalBody("Ganymede", jupiter, 15, 2634);
        OrbitalBody callisto = new OrbitalBody("Callisto", jupiter, 100, 2410);
        OrbitalBody[] jupiterMoons = {europe, io, ganymede, callisto};

        PlanetSet jupiterSet = new PlanetSet(jupiter, jupiterMoons);

        try {
//            minimizedSolarSystem.addPlanetSet(new PlanetSet());
            minimizedSolarSystem.addPlanetSet(jupiterSet);
            System.out.println(minimizedSolarSystem.toString() + "\n");

            logger.info("completed without errors");
        }
        catch (Exception e) {
            logger.error(e.getMessage());
        }

        dbUtils.closeConnection();
    }
}
