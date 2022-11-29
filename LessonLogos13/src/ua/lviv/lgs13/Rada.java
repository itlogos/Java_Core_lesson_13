package ua.lviv.lgs13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Rada {
    List<Faction> factions = new ArrayList<>();
    Scanner scan = new Scanner(System.in);
    Faction faction = new Faction();

    public void addAllDeputyToFaction() {
        Iterator<Faction> iterator = factions.iterator();

        while (iterator.hasNext()) {
            Faction fakty = iterator.next();
            if (fakty.getNameFaction().equals("Green")) {
                fakty.addAllDeputy("Petrenko", "Igor");
                fakty.addAllDeputy("Semenenko", "Ulia");
                fakty.addAllDeputy("Mavenko", "Oleg");
                fakty.addAllDeputy("Sonko", "Aleks");
            }
            if (fakty.getNameFaction().equals("White")) {
                fakty.addAllDeputy("Savchenko", "Oleg");
                fakty.addAllDeputy("Poronko", "Aleks");
            }
            if (fakty.getNameFaction().equals("Neutral")) {
                fakty.addAllDeputy("Franko", "Igor");
                fakty.addAllDeputy("Drim", "Luda");
            }
        }
        System.out.println("Before :");
        for (Faction facty : factions) {
            System.out.println(facty);

        }
    }

    public void addFaction() {

        String text = "Enter the  name of the faction : ";
        String nameFaction = readText(text);
        factions.addAll(Collections.singletonList(new Faction(nameFaction)));
        System.out.println("After :");

        for (Faction facty : factions) {
            System.out.println(facty);
        }
    }

    public void addDeputyToSpecificFaction() {

        Iterator<Faction> iterator = factions.iterator();
        String text1 = "Enter name of the faction : ";
        String nameFaction1 = readText(text1);

        while (iterator.hasNext()) {
            Faction fakty = iterator.next();
            if (fakty.getNameFaction().equals(nameFaction1)) {
                fakty.addDeputy();
            }
        }
        System.out.println("After :");
        for (Faction facty : factions) {
            System.out.println(facty);

        }

    }

    public void removeFaction() {

        System.out.println("Before :");
        for (Faction facty : factions) {
            System.out.println(facty);
        }

        Iterator<Faction> iterator = factions.iterator();
        String text = "Enter name of the faction : ";
        String nameFaction = readText(text);

        while (iterator.hasNext()) {
            Faction fakty = iterator.next();
            if (fakty.getNameFaction().equals(nameFaction)) {
                iterator.remove();
            }
        }
        System.out.println("After :");
        for (Faction facty : factions) {
            System.out.println(facty);
        }

    }

    public void bringOutAllFactions() {
        System.out.println("nameFaction:");
        for (Faction facty : factions) {
            System.out.println(facty.getNameFaction());
        }
    }

    public void clearSpecificFaction() {

        Iterator<Faction> iterator = factions.iterator();
        String text = "Enter name of the faction : ";
        String nameFaction = readText(text);

        while (iterator.hasNext()) {
            Faction fakty = iterator.next();
            if (fakty.getNameFaction().equals(nameFaction)) {
                System.out.println(fakty);
                fakty.clearDeputy();
            }
        }
        System.out.println("After :");
        for (Faction facty : factions) {
            System.out.println(facty);
        }
    }

    public void bringOutFaction() {

        Iterator<Faction> iterator = factions.iterator();
        String text = "Enter name of the faction : ";
        String nameFaction = readText(text);

        while (iterator.hasNext()) {
            Faction fakty = iterator.next();
            if (fakty.getNameFaction().equals(nameFaction)) {
                System.out.println(fakty);
            }
        }
    }

    public void removeDeputy() {
        Iterator<Faction> iterator = factions.iterator();
        String text = "Enter name of the faction : ";
        String nameFaction = readText(text);

        while (iterator.hasNext()) {
            Faction fakty = iterator.next();
            if (fakty.getNameFaction().equals(nameFaction)) {
                fakty.removeDeputy();
            }
        }

        System.out.println("After :");
        for (Faction facty : factions) {
            System.out.println(facty);
        }

    }

    public void bringOutAllBriberTakersFromFaction() {
        Iterator<Faction> iterator = factions.iterator();
        String text = "Enter name of the faction : ";
        String nameFaction = readText(text);

        while (iterator.hasNext()) {
            Faction fakty = iterator.next();
            if (fakty.getNameFaction().equals(nameFaction)) {
                fakty.bringOutBribeTakerInTheFaction();
            }
        }
    }

    public void bringOutTheBiggestBriberTakersFromFaction() {
        Iterator<Faction> iterator = factions.iterator();
        String text = "Enter name of the faction : ";
        String nameFaction = readText(text);

        while (iterator.hasNext()) {
            Faction fakty = iterator.next();
            if (fakty.getNameFaction().equals(nameFaction)) {
                fakty.bringOutTheBiggestBribeTakerInTheFaction();

            }
        }

    }

    public void giveBribe() {
        String text = "Enter name of the faction : ";
        String nameFaction = readText(text);
        for (Faction facty : factions) {
            if (facty.getNameFaction().equals(nameFaction)) {
                facty.giveBribe();
            }
        }
    }

    public String readText(String text) {
        System.out.println(text);
        String input = scan.next();
        return input;
    }

    public Rada() {

        factions.add(new Faction("Green"));
        factions.add(new Faction("White"));
        factions.add(new Faction("Neutral"));
    }

}

