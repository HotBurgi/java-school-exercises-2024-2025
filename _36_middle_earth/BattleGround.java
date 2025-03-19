package _36_middle_earth;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class BattleGround {
    ArrayList<Character> goodArmy;
    ArrayList<Character> evilArmy;

    public BattleGround(ArrayList<Character> good, ArrayList<Character> evil) {
        this.goodArmy = good;
        this.evilArmy = evil;
    }

    public void startFight() {
        Random random = new Random();
        Character good = goodArmy.get(random.nextInt(goodArmy.size()));
        Character evil = evilArmy.get(random.nextInt(evilArmy.size()));

        if (good.getStrenght() > evil.getStrenght()) {
            System.out.println("Good wins!");
            evilArmy.remove(evil);
        } else if (good.getStrenght() < evil.getStrenght()) {
            System.out.println("Evil wins!");
            goodArmy.remove(good);
        } else {
            System.out.println("It's a draw!");
            goodArmy.remove(good);
            evilArmy.remove(evil);
        }

    }

    public void endGame() {
        int goodStr = 0;
        int evilStr = 0;

        for (Character c : goodArmy) {
            goodStr += c.getStrenght();
        }

        for (Character c : evilArmy) {
            evilStr += c.getStrenght();
        }

        if (goodStr > evilStr) {
            System.out.println("Good wins!");
        } else if (goodStr < evilStr) {
            System.out.println("Evil wins!");
        } else {
            System.out.println("It's a draw!");
        }
    }

    public void addCharacter(Character c) {
        if (c.getSide() == Side.GOOD) {
            goodArmy.add(c);
        } else if ((c.getSide() == Side.EVIL)) {
            evilArmy.add(c);
        } else {
            Scanner sc = new Scanner(System.in);
            System.out.println("The hero, is good or evil?");
            String side = sc.next().toLowerCase();
            if (side.equals("good")) {
                goodArmy.add(c);
            } else if (side.equals("evil")) {
                evilArmy.add(c);
            } else {
                System.out.println("Invalid side!");
            }
        }
    }
}
