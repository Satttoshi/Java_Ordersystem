package org.module;

import java.util.HashMap;
import java.util.Map;

public class ProductRepo implements Product{
    private final Map<String, String> products;

    public ProductRepo() {
        this.products = new HashMap<>();
        this.products.put("1", "Apple");
        this.products.put("2", "Orange");
        this.products.put("3", "Banana");
        this.products.put("4", "Pineapple");
        this.products.put("5", "Kiwi");
    }

    public ProductRepo(Map<String, String> products) {
        this.products = products;
    }

    public String getProduct(String name) {
        return this.products.get(name);
    }

    public Map<String, String> listProducts() {
        return this.products;
    }

    @Override
    public String toString() {
        return "ProductRepo{" +
            "products=" + products +
            '}';
    }
}
