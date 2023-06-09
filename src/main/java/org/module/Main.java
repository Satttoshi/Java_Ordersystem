package org.module;

import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        ShopService shopService = new ShopService(List.of(
            new Product(0, "Nike Shoes"),
            new Product(1, "Polo Shirt"),
            new Product(2, "Base Cap"),
            new Product(3, "Tennis Racket"),
            new Product(4, "Perfume")
        ));

        System.out.println("Welcome to the shop!");
        System.out.print("Do you want to view a Product? Yes/No: ");
        if(userChoice()) {
            System.out.print("Enter the ID or name of the product you want to view: ");
            try {
                int id = scanner.nextInt();
                System.out.println(shopService.getProduct(id));
            } catch (Exception e) {
                String name = scanner.nextLine();
                System.out.println(shopService.getProduct(name));
            }
        }

        System.out.print("Do you also want to view all Products? Yes/No: ");

        if(userChoice()) {
            System.out.println(shopService.getProducts());
        }

        System.out.println("Do you want to add an Order?");



    }


    public static boolean userChoice() {
        String choice = scanner.nextLine();
        String choiceLower = choice.toLowerCase();
        if (choiceLower.equals("yes") || choiceLower.equals("y")) {
            return true;
        } else if (choiceLower.equals("no") || choiceLower.equals("n")) {
            return false;
        } else {
            if(!choiceLower.equals("")) {
                System.out.println("Invalid input, please try again.");
            }
            return userChoice();
        }
    }
}
