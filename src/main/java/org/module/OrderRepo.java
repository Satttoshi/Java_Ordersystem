package org.module;

import java.util.List;

public class OrderRepo {

    List<Order> orders;

    public OrderRepo(){}

    public OrderRepo(List<Order> orders) {
        this.orders = orders;
    }

    public Order getOrderById(int id) {
        for (Order order : orders) {
            if (order.id == id) {
                return order;
            }
        }
        return null;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }
}
