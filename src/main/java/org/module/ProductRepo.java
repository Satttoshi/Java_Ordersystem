package org.module;

import java.util.HashMap;
import java.util.Map;

public class ProductRepo implements Product{
    private final Map<String, String> products;

    public ProductRepo() {
        this.products = new HashMap<>();
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
