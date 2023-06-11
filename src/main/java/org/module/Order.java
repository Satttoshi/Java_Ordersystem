package org.module;

import java.util.Date;
import java.util.Map;
import java.util.Objects;

public class Order {
    public String id;
    private Map<String, String> products;
    private Status orderStatus;
    private final Date date;

    public void toggleStatus() {
        switch (orderStatus) {
            case PENDING -> orderStatus = Status.COMPLETED;
            case COMPLETED -> orderStatus = Status.PENDING;
        }
    }


    public String getDate() {
        return date.toString();
    }

    public Order(String id, Map<String, String> products) {
        this.id = id;
        this.products = products;
        this.orderStatus = Status.PENDING;
        this.date = new Date();
    }


    @Override
    public String toString() {
        return "Order{" +
            "id='" + id + '\'' +
            ", products=" + products +
            ", orderStatus=" + orderStatus +
            ", date=" + date +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Order order))
            return false;
        return Objects.equals(id, order.id) && Objects.equals(products, order.products) && orderStatus == order.orderStatus && Objects.equals(date, order.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, products, orderStatus, date);
    }
}
