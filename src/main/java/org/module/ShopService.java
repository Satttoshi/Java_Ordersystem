package org.module;

import java.util.List;

public class ShopService {
    ProductRepo productRepo;
    OrderRepo orderRepo;

    public List<Product> getProducts() {
        return productRepo.getProducts();
    }

    public Product getProduct(int id) {
        return productRepo.getProduct(id);
    }

    public void addOrder(Order order) {
        orderRepo.addOrder(order);
    }

    public Order getOrder(int id) {
        return orderRepo.getOrder(id);
    }

    public List<Order> listOrders() {
        return orderRepo.listOrders();
    }

}
