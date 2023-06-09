package org.module;

import java.util.List;

public class ShopService {
    private final ProductRepo productRepo;
    private final OrderRepo orderRepo;

    public ShopService(List<Product> products) {
        this.productRepo = new ProductRepo(products);
        this.orderRepo = new OrderRepo();
    }

    public ShopService(List<Product> products, List<Order> orders) {
        this.productRepo = new ProductRepo(products);
        this.orderRepo = new OrderRepo(orders);
    }

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
