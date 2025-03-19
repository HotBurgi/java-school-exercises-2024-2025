package _36_middle_earth.races;

import _36_middle_earth.Character;
import _36_middle_earth.Side;

public class Elf extends Character {

    public Elf(String name) {
        super(name, Side.GOOD);
    }

    @Override
    public int getStrenght() {
        if (getLevel() < 5) {
            return 20 + 3 * getLevel();
        }
        return 80 + 2 * getLevel();
    }
}
