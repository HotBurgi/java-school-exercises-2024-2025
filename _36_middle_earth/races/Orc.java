package _36_middle_earth.races;

import _36_middle_earth.Character;
import _36_middle_earth.Side;

public class Orc extends Character {

    public Orc(String name) {
        super(name, Side.EVIL);
    }

    @Override
    public int getStrenght() {
        if (getLevel() < 5) {
            return 30 + 2 * getLevel();
        }
        return 70 + 3 * getLevel();
    }
}
