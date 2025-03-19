package _36_middle_earth;

import _36_middle_earth.races.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    Scanner scanner = new Scanner(System.in);
    BattleGround battleGround;


    public Main() {
        Dwarf dwarf = new Dwarf("Gimli");
        Hobbit hobbit = new Hobbit("Frodo");
        Orc orc = new Orc("Uruk-hai");
        Haradrim haradrim = new Haradrim("Haradrim");
        Hero hero = new Hero("Aragorn", Side.GOOD);

        ArrayList<Character> good = new ArrayList<>();
        good.add(dwarf);
        good.add(hobbit);
        ArrayList<Character> evil = new ArrayList<>();
        evil.add(orc);
        evil.add(haradrim);

        battleGround = new BattleGround(good, evil); // Initialize the BattleGround

        int pick;

        do {
            System.out.println("1. Add Character\n2. Start Fight\n3. End Game\n0. Exit");
            pick = scanner.nextInt();

            switch (pick) {
                case 1:
                    battleGround.addCharacter(hero);
                    break;
                case 2:
                    battleGround.startFight();
                    break;
                case 3:
                    battleGround.endGame();
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        } while (pick != 0);

    }
}