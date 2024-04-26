package com.marianbastiurea.lifeofbees;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Calendar;
/*
When the honeybee colony senses that it needs a new queen, perhaps because the queen is ailing or is preparing to
swarm, the worker bees will begin the process of raising new queen bees.
Feed with royal jelly.
Queen cell is place where new queen develops.
When the queen bee larva is ready to pupate (metamorphosize) into a queen, the worker bees will cap the cell, and
she will transform inside it.  At day 15, when she is fully developed, she will chew her way out of the cell with
the help of a few worker bees.
After the queen chews her way out of her queen cell, she has some dirty work to do...she instinctively sets out to
kill her sisters....the other new queens.
Once the battling is done, the queen will take a mating flight...a one-time flight from the hive to mate
with male drones.
After mating, she will return to the hive.  If her mother (the old queen) is still in the hive and nearing the end
of her life, the new queen will kill her (called 'supercedure').  If the old queen has left with a swarm, the new
queen will take over laying eggs.
In the summer, she can lay up to 2000 eggs a day!
A drone is a male bee. Unlike the female worker bee, a drone has no stinger.
 */

public class Queen {
    private int ageOfQueen;

    public Queen(int ageOfQueen) {
        this.ageOfQueen = ageOfQueen;
    }

    public Queen() {
    }

    public int getAgeOfQueen() {
        return ageOfQueen;
    }

    public void setAgeOfQueen(int ageOfQueen) {
        this.ageOfQueen = ageOfQueen;
    }

    public double ageOfQueenIndex() {
        Apiary apiary=new Apiary();

        /* a queen lives 3-5 years. When will build first 10 hives in apiary will use random to generate ageOfQueen
         between 1  and 5 years old for our queen. At age 5, will have to replace this queen with new one.
         Depending on age of queen will choose an fertility index between 0 and 1. When index is 0, queen is too old
         to lay eggs and she have to be replaced. Whenn index is 1,
     fertility of queen is at maximum and she can lay upon 2000 eggs daily
         */

        int ageOfQueen = apiary.getHives().getAgeOfQueen();
        double numberRandom = Math.random();
        switch (ageOfQueen) {
            case 0, 1, 2, 3:
                return 1;
            case 4:
                if (numberRandom < 0.5) {
                    hive.setAgeOfQueen(0);
                    return 1;
                } else
                    return 0.75;
            case 5:
                hive.setAgeOfQueen(0);
                return 0.25;
            default:
                break;
        }
        return 0;
    }

    public int makeEggs() {
        Queen queen = new Queen();
        int numberOfEggs = (int) (2000 * queen.ageOfQueenIndex());//*Whether.geWhetherIndex());
        // have to add another index, a  whetherIndex which will depend on quantity of honey made it
        System.out.println("eggs number is: "+numberOfEggs);
        return numberOfEggs;
    }

    // Method to make eggs and create a list of EggsBatch, which store daily
    // numberOfEggs and date from calendar when eggs are made
    public List<EggsBatch> makeBatchOfEggs(int numberOfEggs, Date date) {
        Hive hive = new Hive();
        List<EggsBatch> eggsBatches = new ArrayList<>();
        EggsBatch eggsBatch = new EggsBatch(numberOfEggs, date);
        eggsBatches.add(eggsBatch);
        return eggsBatches;
    }

    public void checkAgeOfQueen() {
    }
}





