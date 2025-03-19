package _36_middle_earth.races;

import _36_middle_earth.Character;
import _36_middle_earth.Side;

public class Human extends Character {

    public Human(String name) {
        super(name, Side.GOOD);
    }

    @Override
    public int getStrenght() {
        return 30 + 6 * getLevel();
    }
}