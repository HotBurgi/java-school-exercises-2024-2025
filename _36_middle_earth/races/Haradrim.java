package _36_middle_earth.races;

import _36_middle_earth.Character;
import _36_middle_earth.Side;

public class Haradrim extends Character {

    public Haradrim(String name) {
        super(name, Side.EVIL);
    }

    @Override
    public int getStrenght() {
        return 40 + 5 * getLevel();
    }
}
