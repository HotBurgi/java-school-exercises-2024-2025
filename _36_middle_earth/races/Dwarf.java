package _36_middle_earth.races;

import _36_middle_earth.Character;
import _36_middle_earth.Side;

public class Dwarf extends Character {

    public Dwarf(String name) {
        super(name, Side.GOOD);
    }

    @Override
    public int getStrenght() {
        return 20 + 4 * getLevel();
    }
}