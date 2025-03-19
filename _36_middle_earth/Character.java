package _36_middle_earth;

import java.util.Random;

public abstract class Character {
    private final String name;
    private final Side side;
    private final int level;
    private final int strenght;

    public Character(String name, Side side) {
        Random random = new Random();
        this.name = name;
        this.side = side;
        this.level = random.nextInt(10) + 1;
        this.strenght = getStrenght();
    }

    public int getLevel() {
        return level;
    }

    public Side getSide() {
        return side;
    }

    public abstract int getStrenght();
}