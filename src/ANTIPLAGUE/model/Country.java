package ANTIPLAGUE.model;

import java.util.ArrayList;

public class Country {
    String name;
    int population;
    String flag;
    boolean ships;
    boolean cars;
    boolean aeroplanes;
    int healthy;
    int infected;
    int recovered;
    int dead ;

    boolean vaccines;
    boolean curfew;
    boolean borderClosing;
    boolean masks;
    boolean advancedLab;
    boolean enteringPermission;
    boolean researchGrant;
    boolean schoolsClosing;
    boolean infoSpreading;

    boolean carRestriction ;
    boolean shipRestriction ;
    boolean aeroplaneRestriction;

    double carRestrictionRequirement;
    double shipRestrictionRequirement;
    double aeroplaneRestrictionRequirement;

    int upgrades;
    boolean infectionStopped;




    Country(String name, int population, String flag, boolean ships, boolean cars, boolean aeroplanes, double carRestrictionRequirement, double shipRestrictionRequirement, double aeroplaneRestrictionRequirement) {
        this.name = name;
        this.population = population;
        this.flag = flag;
        this.ships = ships;
        this.cars = cars;
        this.aeroplanes = aeroplanes;
        this.healthy = population;
        this.infected = 0;
        this.dead = 0;
        this.recovered = 0;
        this.vaccines = false;
        this.curfew = false;
        this.borderClosing = false;
        this.masks = false;
        this.advancedLab = false;
        this.enteringPermission = false;
        this.researchGrant = false;
        this.schoolsClosing = false;
        this.infoSpreading = false;


        this.carRestriction = false;
        this.shipRestriction = false;
        this.aeroplaneRestriction = false;


        this.carRestrictionRequirement = carRestrictionRequirement;
        this.shipRestrictionRequirement = shipRestrictionRequirement;
        this.aeroplaneRestrictionRequirement = aeroplaneRestrictionRequirement;

        this.upgrades = 0;
        this.infectionStopped = false;
    }


    public ArrayList<String> getUpgrades(){
        ArrayList<String> upgrades = new ArrayList<>();
        upgrades.add(String.valueOf(vaccines));
        upgrades.add(String.valueOf(curfew));
        upgrades.add(String.valueOf(borderClosing));
        upgrades.add(String.valueOf(masks));
        upgrades.add(String.valueOf(advancedLab));
        upgrades.add(String.valueOf(enteringPermission));
        upgrades.add(String.valueOf(researchGrant));
        upgrades.add(String.valueOf(schoolsClosing));
        upgrades.add(String.valueOf(infoSpreading));

        return upgrades;
    }

    public ArrayList<String> getStats(){
        ArrayList<String> stats = new ArrayList<>();
        stats.add(name);                            //0
        stats.add(Integer.toString(population));    //1
        stats.add(Integer.toString(healthy));       //2
        stats.add(Integer.toString(infected));      //3
        stats.add(flag);                            //4
        stats.add(Integer.toString(dead));          //5
        stats.add(Integer.toString(recovered));     //6
        stats.add(Boolean.toString(vaccines));      //7
        stats.add(Boolean.toString(curfew));
        stats.add(Boolean.toString(borderClosing));
        stats.add(Boolean.toString(masks));
        stats.add(Boolean.toString(advancedLab));
        stats.add(Boolean.toString(enteringPermission));
        stats.add(Boolean.toString(researchGrant));
        stats.add(Boolean.toString(schoolsClosing));
        stats.add(Boolean.toString(infoSpreading));  //15







        return stats;
    }

}
