package org.module;

import java.util.List;

public class ProductRepo{
    List<Product> products;

    public ProductRepo(){}

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

    public List<Product> getProducts() {
        return products;
    }

}
