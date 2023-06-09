package org.module;

import java.util.ArrayList;
import java.util.List;

public class OrderRepo {

    List<Order> orders;

    public OrderRepo(){
        this.orders = new ArrayList<>();
    }

    public OrderRepo(List<Order> orders) {
        this.orders = orders;
    }

    public Order getOrder(int id) {
        for (Order order : orders) {
            if (order.id == id) {
                return order;
            }
        }
        return null;
    }


    public List<Order> listOrders() {
        return orders;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }
}
