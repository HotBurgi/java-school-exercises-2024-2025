package _36_middle_earth.races;

import _36_middle_earth.Character;
import _36_middle_earth.Side;

public class Hobbit extends Character {

    public Hobbit(String name) {
        super(name, Side.GOOD);
    }

    @Override
    public int getStrenght() {
        return 10 + 3 * getLevel();
    }
}

