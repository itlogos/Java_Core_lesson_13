package ua.lviv.lgs13;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Rada rada = new Rada();
        rada.addAllDeputyToFaction();
        while (true) {
            String text = "Enter values:"

                    + "\n 1-For add a faction, " + "\n 2-For remove a faction, "
                    + "\n 3-For withdrawal of all faction, " + "\n 4-For clear a specific faction, "
                    + "\n 5-For withdrawal of a specific faction, " + "\n 6-For add a deputy to a faction, "
                    + "\n 7-For remove a deputy from a faction," + "\n 8-For withdrawal of all bribe-takers,"
                    + "\n 9-For withdrawal of the largest bribe-taker," + "\n 10-For To give a bribe to a deputy, \n";

            int choice = readText(text);

            switch (choice) {
            case 1:
                rada.addFaction();
                break;
            case 2:
                rada.removeFaction();
                break;

            case 3:
                rada.bringOutAllFactions();
                break;

            case 4:
                rada.clearSpecificFaction();
                break;
            case 5:
                rada.bringOutFaction();
                break;
            case 6:
                rada.addDeputyToSpecificFaction();
                break;
            case 7:
                rada.removeDeputy();
                break;
            case 8:
                rada.bringOutAllBriberTakersFromFaction();
                break;
            case 9:
                rada.bringOutTheBiggestBriberTakersFromFaction();
                break;
            case 10:
                rada.giveBribe();
                break;

            }
        }

    }

    public static int readText(String text) {
        Scanner scan = new Scanner(System.in);
        System.out.print(text);
        int input = scan.nextInt();
        return input;
    }

}
