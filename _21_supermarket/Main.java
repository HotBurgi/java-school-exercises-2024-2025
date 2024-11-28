package _21_supermarket;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Product[] supermarket = new Product[100];
        String codeToRemove;
        int stack = 0, pick;

        do {
            System.out.println("1. Add product");

            pick = scanner.nextInt();
            switch (pick) {
                case 1:
                    System.out.println("Enter product description: ");
                    String description = scanner.next();
                    System.out.println("Enter product price: ");
                    double price = scanner.nextDouble();
                    System.out.println("Enter quantity in shop: ");
                    int quantityInShop = scanner.nextInt();
                    System.out.println("Enter quantity in stock: ");
                    int quantityInStock = scanner.nextInt();

                    supermarket[stack] = new Product(description, price, quantityInShop, quantityInStock);
                    stack++;
                    break;
                case 2:
                    System.out.println("Enter product code to remove: ");
                    codeToRemove = scanner.next();
                    for (int i = 0; i < stack; i++) {
                        if (supermarket[i].getCode().equals(codeToRemove)) {
                            for (int j = i; j < stack - 1; j++) {
                                supermarket[j] = supermarket[j + 1];
                            }
                            supermarket[stack - 1] = null;
                            stack--;
                            break;
                        }
                    }
                    break;
                case 3:
                    System.out.println("Enter product code to remove: ");
                    codeToRemove = scanner.next();
                    System.out.println("Enter quantity to move: ");
                    int quantityToRemove = scanner.nextInt();
                    System.out.println("(1) to stock, (2) to supermarket: ");
                    int move = scanner.nextInt();
                    for (int i = 0; i < stack; i++) {
                        if (supermarket[i].getCode().equals(codeToRemove)) {
                            if (move == 1) {
                                System.out.println(supermarket[i].moveToStock(quantityToRemove));
                            } else {
                                System.out.println(supermarket[i].moveToShop(quantityToRemove));
                            }
                            break;
                        }
                    }
                    break;
                case 4:
                    System.out.println("Enter product code to remove: ");
                    codeToRemove = scanner.next();
                    for (int i = 0; i < stack; i++) {
                        if (supermarket[i].getCode().equals(codeToRemove)) {
                            System.out.println(supermarket[i].printQuantity());
                            break;
                        }
                    }
                    break;
                case 5:
                    System.out.println("Enter product quantity: ");
                    int quantity = scanner.nextInt();
                    for (int i = 0; i < stack; i++) {
                        if (supermarket[i].getQuantity() <= quantity) {
                            System.out.println(supermarket[i].toString());
                            break;
                        }
                    }
                    break;
            }
        } while (pick != 0);
    }
}
