package org.module;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrderRepoTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3}) // The third value is a non-existent order ID
    public void testGetOrder(int id) {
        Product product1 = new Product(1, "Product1");
        Product product2 = new Product(2, "Product2");

        Order order1 = new Order(1, Arrays.asList(product1));
        Order order2 = new Order(2, Arrays.asList(product2));
        List<Order> orders = new ArrayList<>(Arrays.asList(order1, order2));

        OrderRepo orderRepo = new OrderRepo(orders);

        Order order = orderRepo.getOrder(id);

        if (id <= 2) {
            assertNotNull(order);
            assertEquals(id, order.id);
        } else {
            assertNull(order);
        }
    }

    @Test
    public void testListOrders() {
        Product product1 = new Product(1, "Product1");
        Product product2 = new Product(2, "Product2");

        Order order1 = new Order(1, Arrays.asList(product1));
        Order order2 = new Order(2, Arrays.asList(product2));
        List<Order> orders = new ArrayList<>(Arrays.asList(order1, order2));

        OrderRepo orderRepo = new OrderRepo(orders);

        List<Order> returnedOrders = orderRepo.listOrders();

        assertNotNull(returnedOrders);
        assertEquals(2, returnedOrders.size());
        assertTrue(returnedOrders.containsAll(orders));
    }

    @Test
    public void testAddOrder() {
        Product product1 = new Product(1, "Product1");
        Product product2 = new Product(2, "Product2");

        Order order1 = new Order(1, Arrays.asList(product1));
        Order order2 = new Order(2, Arrays.asList(product2));
        List<Order> orders = new ArrayList<>(Arrays.asList(order1, order2));

        OrderRepo orderRepo = new OrderRepo(orders);

        Product product3 = new Product(3, "Product3");
        Order order3 = new Order(3, Arrays.asList(product3));

        orderRepo.addOrder(order3);

        assertEquals(3, orderRepo.listOrders().size());
        assertTrue(orderRepo.listOrders().contains(order3));
    }
}
