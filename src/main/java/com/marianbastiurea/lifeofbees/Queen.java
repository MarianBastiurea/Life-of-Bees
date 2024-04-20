package com.marianbastiurea.lifeofbees;
import java.util.Scanner;
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

import java.util.Scanner;

public class Queen {
    private int ageOfQueen = 1;

    public int getAgeOfQueen() {
        return ageOfQueen;
    }

    public void makeEggs(Hive hive, Environment environment) {
        int numberOfEggs = (int) (2000 */* honeyIndex * */environment.getWeather().getTemperature() * ageOfQueenIndex(ageOfQueen));

        hive.addEggs(numberOfEggs);
    }

    public static double ageOfQueenIndex(int ageOfQueen) {
        /* a queen lives 3-5 years. We will consider 1 years old for our queen. At age 5,
    beekeper will have to replace this queen with new one.Depending on age of queen will choose an fertility index
     between 0 and 1. When index is 0, queen is too old to lay eggs and she have to be replaced. Whenn index is 1,
     fertility of queen is at maximum and she can lay upon 2000 eggs daily
         */
        Scanner scanner = new Scanner(System.in);
        String answer;
        boolean isValidAnswer = false;

        switch (ageOfQueen) {
            case 0, 1, 2, 3:
                return 1;
            case 4:
                System.out.println("""
                        Your queen is 4 years old.
                        You have to change hive's queen this year or next year at last.
                        Please choose one option from bellow:
                        1) You want to change this year?
                        2) You want to let the bees to decide when it's right time to change?
                        That means your hive population of bees will decrease and honey productivity will go down.
                        """);
                do {
                    System.out.print("Your choice (1 or 2): ");
                    answer = scanner.nextLine();

                    if (answer.equals("1") || answer.equals("2")) {
                        isValidAnswer = true;
                    } else {
                        System.out.println("Invalid input. Please enter '1' or '2'.");
                    }
                } while (!isValidAnswer);

                System.out.println("Thank you for your response!");
                scanner.close();
                if(answer.equals("1")){
                    ageOfQueen=0;
                    return 1;
                }else if (answer.equals("2")){
                return 0.75;}
            case 5:
                return 0.25;
            default:
                break;
        }
        return 0;
    }

}
