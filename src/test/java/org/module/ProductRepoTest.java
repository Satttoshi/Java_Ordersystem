package org.module;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ProductRepoTest {

    private ProductRepo productRepo;

    @BeforeEach
    void setUp() {
        Map<String, String> testProducts = new HashMap<>();
        testProducts.put("apple", "fruit");
        testProducts.put("carrot", "vegetable");
        productRepo = new ProductRepo(testProducts);
    }

    @Test
    void getProduct() {
        assertEquals("fruit", productRepo.getProduct("apple"));
        assertEquals("vegetable", productRepo.getProduct("carrot"));
        assertNull(productRepo.getProduct("nonexistent"));
    }

    @Test
    void listProducts() {
        Map<String, String> listedProducts = productRepo.listProducts();
        assertEquals(2, listedProducts.size());
        assertEquals("fruit", listedProducts.get("apple"));
        assertEquals("vegetable", listedProducts.get("carrot"));
    }
}
