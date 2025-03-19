package _36_middle_earth.races;

import _36_middle_earth.Character;
import _36_middle_earth.Side;

import java.util.Random;

public class Hero extends Character {
    private final int health;

    public Hero(String name, Side side) {
        Random random = new Random();
        super(name, side);
        this.health = random.nextInt(10) + 1;
    }

    @Override
    public int getStrenght() {
        return 50 * this.health + 50 * getLevel();
    }
}
