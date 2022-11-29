package ua.lviv.lgs13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Faction {

    private String nameFaction;
    List<Deputy> deputies = new ArrayList<>();
    Scanner scan = new Scanner(System.in);

    public void addAllDeputy(String surname, String name) {

        int age = getRandomValue(25, 82);
        boolean corrupt = getCorruptValue(age);
        int bribeAmount = getRandomValue(3000, 7000);
        int weight = getRandomValue(50, 110);
        int height = getRandomValue(160, 200);

        Deputy deput = new Deputy(surname, name, age, corrupt, bribeAmount, weight, height);
        deputies.addAll(Collections.singletonList(deput));

    }

    public void addDeputy() {

        int age = getRandomValue(25, 82);
        boolean corrupt = getCorruptValue(age);
        int bribeAmount = getRandomValue(250, 1000);
        int weight = getRandomValue(50, 110);
        int height = getRandomValue(160, 200);

        String text = "Enter the last name of the deputy (the rest of the data will be generated randomly): ";
        String surname = readText(text);
        text = "Enter the name of the deputy (the rest of the data will be generated randomly): ";
        String name = readText(text);

        Deputy deput = new Deputy(surname, name, age, corrupt, bribeAmount, weight, height);
        deputies.addAll(Collections.singletonList(deput));
        System.out.println("deput :");
        for (Deputy deputt : deputies) {
            System.out.println(deputt.getSurname());

        }
    }

    public void clearDeputy() {
        System.out.println(deputies);
        deputies.clear();
    }

    public void removeDeputy() {

        Iterator<Deputy> iterator = deputies.iterator();
        String text = "Enter the last name of the deputy";

        String surname1 = readText(text);

        while (iterator.hasNext()) {
            Deputy line = iterator.next();
            if (line.getSurname().equals(surname1)) {
                iterator.remove();
            }
        }
        System.out.println("After :");
        for (Deputy deputy : deputies) {
            System.out.println(deputy);
        }

    }

    public void bringOutBribeTakerInTheFaction() {
        Iterator<Deputy> iterator = deputies.iterator();
        while (iterator.hasNext()) {
            Deputy line = iterator.next();
            if (line.isCorrupt() == true) {
                System.out.println(line.getSurname());
            }
        }

    }

    public void bringOutTheBiggestBribeTakerInTheFaction() {

        Collections.sort(deputies, new BribeTakerComparator());
        System.out.println("Largest bribe-taker: " + deputies.get(deputies.size() - 1));
    }

    public void giveBribe() {
        String text1 = "Enter the last name of the deputy";
        String surname = readText(text1);

        for (Deputy deputy : deputies) {
            if (deputy.getSurname().equals(surname)) {
                int bribeAmount = deputy.getBribeAmount();
                deputy.takeBribe(deputy.isCorrupt(), bribeAmount);
            }
        }
    }

    public String readText(String text) {
        System.out.println(text);
        String input = scan.next();
        return input;
    }

    public int readText2(String text) {
        System.out.println(text);
        int input = scan.nextInt();
        return input;
    }

    public int getRandomValue(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("min value must be smaller than max value");
        }

        Random r = new Random();
        return r.nextInt(max - min + 1) + min;
    }

    public boolean getCorruptValue(int age) {
        if (age % 2 == 0) {
            return false;
        } else {
            return true;
        }
    }

    public Faction(Deputy deputy, String nameFaction) {
        this.nameFaction = nameFaction;
    }

    public Faction(List<Deputy> deputies, String nameFaction) {

        this.deputies = deputies;
        this.nameFaction = nameFaction;
    }

    public Faction() {
        super();

    }

    public Faction(String nameFaction) {
        this.nameFaction = nameFaction;
    }

    public String getNameFaction() {
        return nameFaction;
    }

    public void setNameFaction(String nameFaction) {
        this.nameFaction = nameFaction;
    }

    @Override
    public String toString() {
        return "nameFaction=" + nameFaction + ",\n deputies=" + deputies;
    }

}