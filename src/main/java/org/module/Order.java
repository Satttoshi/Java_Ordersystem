package org.module;

import java.util.Map;
import java.util.Objects;

public class Order {
    public String id;
    private Map<String, String> products;

    public Order(String id, Map<String, String> products) {
        this.id = id;
        this.products = products;
    }

    @Override
    public String toString() {
        return "Order{" +
            "id=" + id +
            ", products=" + products +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Order order))
            return false;
        return id == order.id && Objects.equals(products, order.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, products);
    }

}
