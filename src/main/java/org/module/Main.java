package org.module;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ShopService shopService = new ShopService(List.of(
            new Product(0, "Nike Shoes"),
            new Product(1, "Polo Shirt"),
            new Product(2, "Base Cap"),
            new Product(3, "Tennis Racket"),
            new Product(4, "Perfume")
        ));

        System.out.println("Welcome to the shop!");
        System.out.println("What do you want to do? :");


        System.out.println(shopService.getProducts());


    }
}
