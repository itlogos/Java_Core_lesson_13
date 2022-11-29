package ua.lviv.lgs13;

import java.util.Scanner;

public class Deputy extends Person {

    private String surname;
    private String name;
    private int age;
    private boolean corrupt; 
    private int bribeAmount;

    Scanner scan = new Scanner(System.in);

    public Deputy(String surname, String name, int age, boolean corrupt, int bribeAmount, int weight, int height) {
        super(weight, height);
        this.surname = surname;
        this.name = name;
        this.age = age;
        this.corrupt = corrupt;
        this.bribeAmount = bribeAmount;
    }

    public Deputy(int weight, int height) {
        super(weight, height);

    }

    public void takeBribe(boolean corrupt, int bribeAmount) {
        if (!corrupt) {
            System.out.println("I'm not a bribe taker");
        } else {
            String text2 = "Enter the amount of the bribe";
            int summaBribe = readText2(text2);
            if (summaBribe < 5000) {
                bribeAmount += summaBribe;
                this.bribeAmount = bribeAmount;
                System.out.println("Amount of bribes " + this.surname + " became: " + this.bribeAmount);
            } else if (summaBribe >= 5000) {
                System.out.println("The police arrive");
            }
        }
    }

    public int readText2(String text) {
        System.out.println(text);
        int input = scan.nextInt();
        return input;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isCorrupt() {
        return corrupt;
    }

    public void setCorrupt(boolean corrupt) {
        this.corrupt = corrupt;
    }

    public int getBribeAmount() {
        return bribeAmount;
    }

    public void setBribeAmount(int bribeAmount) {
        this.bribeAmount = bribeAmount;
    }

    @Override
    public String toString() {
        return "\n surname=" + surname + ", name=" + name + ", age=" + age + ", corrupt=" + corrupt + ", bribeAmount="
                + bribeAmount + ", weight=" + this.getWeight() + ", height=" + this.getHeight();
    }

}
