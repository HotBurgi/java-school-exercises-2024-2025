package _29_queue;

import java.util.ArrayList;

public class Person {
    private String name;
    private ArrayList<String> shoppingList;

    public Person(String name, ArrayList<String> shoppingList) {
        this.name = name;
        this.shoppingList = shoppingList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getShoppingList() {
        return shoppingList;
    }

    public void setShoppingList(ArrayList<String> shoppingList) {
        this.shoppingList = shoppingList;
    }
}
