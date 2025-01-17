package _28_masked_party;

import _15_coordinates.Coordinate;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class InviteList {
    private final ArrayList<Student> invites = new ArrayList<>();
    private int males = 0;
    private int females = 0;

    private LocalDateTime partyDate;
    private Coordinate partyCoordinates;
    private String partyLocation;
    private String City;

    public InviteList(LocalDateTime partyDate, Coordinate partyCoordinates, String partyLocation, String City) {
        this.partyDate = partyDate;
        this.partyCoordinates = partyCoordinates;
        this.partyLocation = partyLocation;
        this.City = City;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getPartyLocation() {
        return partyLocation;
    }

    public void setPartyLocation(String partyLocation) {
        this.partyLocation = partyLocation;
    }

    public Coordinate getPartyCoordinates() {
        return partyCoordinates;
    }

    public void setPartyCoordinates(Coordinate partyCoordinates) {
        this.partyCoordinates = partyCoordinates;
    }

    public LocalDateTime getPartyDate() {
        return partyDate;
    }

    public void setPartyDate(LocalDateTime partyDate) {
        this.partyDate = partyDate;
    }

    public boolean addStudent(Student student) {
        if (invites.size() <= 5) {
            invites.add(student);
            if (student.getSex() == 'm') {
                males++;
            } else {
                females++;
            }
            return true;
        }

        if (student.getSex() == 'f' && females < 0.45 * invites.size()) {
            invites.add(student);
            females++;
            return true;
        } else if (student.getSex() == 'm' && males < 0.45 * invites.size()) {
            invites.add(student);
            males++;
            return true;
        }

        System.out.println("The party is full.");
        return false;
    }

    public void printInviteList() {
        for (Student student : invites) {
            System.out.println(student.getName() + " (" + student.getSex() + ")");
        }
    }

    public ArrayList<Student> researchByMask(String mask) {
        ArrayList<Student> toReturn = new ArrayList<>();
        for (Student student : invites) {
            if (student.getMask().equals(mask)) {
                toReturn.add(student);
            }
        }
        return toReturn;
    }

    public void filterByAge(int age) {
        ArrayList<Integer> ages = new ArrayList<>();
        for (Student student : invites) {
            ages.add(student.getAge());
        }
        sortAges(ages);

        int count = 0;
        for (Integer elemnt : ages) {
            for (Student student : invites) {
                if (student.getAge() == elemnt) {
                    count++;
                }
            }
            System.out.println(elemnt + " years old: " + count + " students");
        }
    }

    private ArrayList<Integer> sortAges(ArrayList<Integer> ages) {
        for (int i = 0; i < ages.size(); i++) {
            for (int j = i + 1; j < ages.size(); j++) {
                if (ages.get(i) > ages.get(j)) {
                    int temp = ages.get(i);
                    ages.set(i, ages.get(j));
                    ages.set(j, temp);
                }
            }
        }
        return ages;
    }

    public ArrayList<Student> getInvites() {
        return invites;
    }
}