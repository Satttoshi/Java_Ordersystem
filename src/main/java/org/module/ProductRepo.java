package org.module;

import java.util.List;

public class ProductRepo{
    List<Product> products;

    public ProductRepo(List<Product> products) {
        this.products = products;
    }

    public Product getProduct(int id) {
        for (Product product : products) {
            if (product.id == id) {
                return product;
            }
        }
        return null;
    }

    public Product getProduct(String name) {
        for (Product product : products) {
            if (product.name.equals(name)) {
                return product;
            }
        }
        return null;
    }

    public List<Product> getProducts() {
        return products;
    }

}
