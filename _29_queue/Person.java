package _29_queue;

import java.util.HashMap;

public class Person {
    private String name;
    private HashMap<Integer, String> shoppingList;

    public Person(String name, HashMap<Integer, String> shoppingList) {
        this.name = name;
        this.shoppingList = shoppingList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<Integer, String> getShoppingList() {
        return shoppingList;
    }

    public void setShoppingList(HashMap<Integer, String> shoppingList) {
        this.shoppingList = shoppingList;
    }

    public int getTotal() {
        int total = 0;
        for (Integer price : shoppingList.keySet()) {
            total += price;
        }
        return total;
    }
}
