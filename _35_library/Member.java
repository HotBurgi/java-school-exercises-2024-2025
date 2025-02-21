package _35_library;

public class Member {
    private static int progressive = 0; // just for show
    private int id;
    private String name;

    public Member(String name) {
        this.name = name;
        this.id = progressive++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
