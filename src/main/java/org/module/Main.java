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
        System.out.println("Do you want to view a Product?");
        if(userChoice()) {
            System.out.println("Enter the ID of the product you want to view: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.println(shopService.getProduct(id));
        }




        System.out.println(shopService.getProducts());


    }

    public static boolean userChoice() {
        System.out.println("Yes or No?: ");
        String choice = scanner.nextLine();
        String choiceLower = choice.toLowerCase();
        if (choiceLower.equals("yes") || choiceLower.equals("y")) {
            return true;
        } else if (choiceLower.equals("no") || choiceLower.equals("n")) {
            return false;
        } else {
            System.out.println("Invalid input, please try again.");
            return userChoice();
        }
    }
}
