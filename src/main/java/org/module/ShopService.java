package org.module;

import java.util.Map;

public class ShopService implements Product{
    private final ProductRepo productRepo;
    private final OrderRepo orderRepo;

    public ShopService() {

        this.productRepo = new ProductRepo();
        this.orderRepo = new OrderRepo();
    }

    public String getProduct(String name) {
        return this.productRepo.getProduct(name);
    }
    public Map<String, String> listProducts() {
        return this.productRepo.listProducts();
    }

    public void addOrder(Order order) {
        orderRepo.addOrder(order);
    }

    public Order getOrder(String id) {
        return orderRepo.getOrder(id);
    }

    public Map<String, Order> listOrders() {
        return orderRepo.listOrders();
    }


}
