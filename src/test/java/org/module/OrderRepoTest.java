package org.module;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class OrderRepoTest {

    private OrderRepo orderRepo;

    @BeforeEach
    public void setUp() {
        orderRepo = new OrderRepo();
    }

    @Test
    public void testListOrders_emptyRepo() {
        Map<String, Order> expectedOrders = new HashMap<>();
        Map<String, Order> actualOrders = orderRepo.listOrders();

        assertThat(actualOrders).isEqualTo(expectedOrders);
    }

    @Test
    public void testGetOrder_existingOrder() {
        Order order = new Order("1", new HashMap<>());
        orderRepo.addOrder(order);

        Order retrievedOrder = orderRepo.getOrder("1");

        assertThat(retrievedOrder).isEqualTo(order);
    }

    @Test
    public void testGetOrder_nonExistingOrder() {
        Order retrievedOrder = orderRepo.getOrder("non_existing");

        assertThat(retrievedOrder).isNotNull();
    }

    @Test
    public void testAddOrder() {
        Order order = new Order("1", new HashMap<>());

        orderRepo.addOrder(order);
        Map<String, Order> actualOrders = orderRepo.listOrders();

        assertThat(actualOrders).containsEntry("1", order);
    }
}
