package _19_porto;

public class Boat {
    private final String name;
    private final String nation; // lungh stazza tipo (vela o motore)
    private final int length;
    private final int beam;
    private final int type; //1 = vela, 2 = motore

    public Boat(String name, String nation, int length, int beam, int type) {
        this.name = name;
        this.nation = nation;
        this.length = length;
        this.beam = beam;
        this.type = type;
    }
}