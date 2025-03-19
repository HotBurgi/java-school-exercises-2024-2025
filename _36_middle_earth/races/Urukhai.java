package _36_middle_earth.races;

import _36_middle_earth.Character;
import _36_middle_earth.Side;

public class Urukhai extends Character {

    public Urukhai(String name) {
        super(name, Side.EVIL);
    }

    @Override
    public int getStrenght() {
        return 50 + 2 * getLevel();
    }
}
