package org.module;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        ShopService shopService =

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

        System.out.print("Do you also want to view all Products?? Yes/No: ");

        if(userChoice()) {
            System.out.println(shopService.getProducts());
        }

        System.out.print("Do you want to make an Order? Yes/No: ");

        if(userChoice()){

            List<Product> products = new ArrayList<>();

            boolean orderMore = true;
            while (orderMore) {

                System.out.print("Enter the ID product you want to order: ");
                int id = scanner.nextInt();
                Product product = shopService.getProduct(id);
                System.out.println("Do you want to Order " + product + "? Yes/No: ");
                if(!userChoice()) {
                    continue;
                }
                products.add(product);
                System.out.println("You have ordered: " + product);
                System.out.print("Do you want to order more products? Yes/No: ");
                if(!userChoice()) {
                    orderMore = false;
                }
            }

            System.out.println("Please enter an OrderID: ");
            int orderID = scanner.nextInt();

            Order order = new Order(orderID, products);
            shopService.addOrder(order);
            System.out.println("Order has been added" + order);
        }

        System.out.print("Do you want to view an Order? Yes/No: ");
        if (userChoice()) {
            System.out.print("Enter the ID of the order you want to view: ");
            int id = scanner.nextInt();
            System.out.println(shopService.getOrder(id));
        }
        System.out.println(shopService.listOrders());

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
