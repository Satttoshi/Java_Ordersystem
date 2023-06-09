package org.module;

import java.util.List;

public class ShopService {
    ProductRepo productRepo;
    OrderRepo orderRepo;

    public List<Product> getProducts() {
        return productRepo.getProducts();
    }

    public Product getProductById(int id) {
        return productRepo.getProductById(id);
    }

    public void addOrder(Order order) {
        orderRepo.addOrder(order);
    }

    public Order getOrderById(int id) {
        return orderRepo.getOrderById(id);
    }

    public List<Order> getOrders() {
        return orderRepo.getOrders();
    }

}
