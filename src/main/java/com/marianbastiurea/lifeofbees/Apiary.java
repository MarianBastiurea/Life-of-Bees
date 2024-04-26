package com.marianbastiurea.lifeofbees;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Apiary {
    /* An apiary is a location where beehives of honey bees are kept.
    Our apiary will start with 1 beehive and we limit this number at 100.
    Our apiary will be in it's first year of existence and we will stop our iteration at year 100.
    At few years acacia or linden forest because of harsh weather will not have flower for bees
    and no honey from this two forest.

     */

    private List<Hive> hives;
    private List<Honey> honeys;

    public Apiary() {
        this.hives = new ArrayList<>();
        this.honeys=new ArrayList<>();
    }

    public Apiary(List<Hive> hives) {
        this.hives = hives;
    }

    public List<Hive> getHives() {
        return hives;
    }

    public void setHives(List<Hive> hives) {
        this.hives = hives;
    }

    public List<Honey> getHoneys() {
        return honeys;
    }

    public void setHoneys(List<Honey> honeys) {
        this.honeys = honeys;
    }

    // Add a hive to the apiary
    public void addHive(Hive hive) {
        hives.add(hive);
    }
    // Add a honey to the apiary
    public void addHoney(Honey honey) {
        honeys.add(honey);
    }
    private void splitHive(Hive hive) {
        // Create a new hive with half of the honey frames and half of the eggs frames
        Hive newHive = new Hive();
        newHive.setAgeOfQueen(0); // Set age of the new queen to 0

        int halfNumberOfHoneyFrame = hive.getNumberOfHoneyFrame() / 2;
        int halfNumberOfEggsFrame = hive.getNumberOfEggsFrame() / 2;

        newHive.setNumberOfHoneyFrame(halfNumberOfHoneyFrame);
        newHive.setNumberOfEggsFrame(halfNumberOfEggsFrame);

        // Transfer the new hive to the apiary
        hives.add(newHive);
    }


}