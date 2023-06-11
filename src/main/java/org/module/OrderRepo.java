package org.module;

import java.util.*;

public class OrderRepo {

    Map<String, Order> orders;

    public OrderRepo(){
        this.orders = new HashMap<>();
    }

    public OrderRepo(Map<String, Order> orders) {
        this.orders = orders;
    }

    public Map<String, Order> listOrders() {
        return orders;
    }

    public Order getOrder(String id) {
        try {
            return Optional.ofNullable(orders.get(id)).orElseThrow(NoSuchElementException::new);
        } catch (NoSuchElementException e) {
            return new Order(String.valueOf(orders.size() + 1), new HashMap<>());
        }
    }

    void addOrder(Order order) {orders.put(order.id, order);
    }
}
