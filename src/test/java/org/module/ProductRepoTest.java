package org.module;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

public class ProductRepoTest {

    @ParameterizedTest
    @CsvSource({
        "1, Product1",
        "2, Product2",
        "3, ''" // Test für Produkt, das nicht existiert
    })
    public void testGetProductById(int id, String expectedName) {
        Product product1 = new Product(1, "Product1");
        Product product2 = new Product(2, "Product2");
        List<Product> products = Arrays.asList(product1, product2);
        ProductRepo productRepo = new ProductRepo(products);

        Product product = productRepo.getProduct(id);
        if (expectedName.isEmpty()) {
            assertNull(product);
        } else {
            assertNotNull(product);
            assertEquals(id, product.id);
            assertEquals(expectedName, product.name);
        }
    }

    @ParameterizedTest
    @CsvSource({
        "Product1, 1",
        "Product2, 2",
        "'Product3', ''" // Test für Produkt, das nicht existiert
    })
    public void testGetProductByName(String name, String expectedId) {
        Product product1 = new Product(1, "Product1");
        Product product2 = new Product(2, "Product2");
        List<Product> products = Arrays.asList(product1, product2);
        ProductRepo productRepo = new ProductRepo(products);

        Product product = productRepo.getProduct(name);
        if (expectedId.isEmpty()) {
            assertNull(product);
        } else {
            assertNotNull(product);
            assertEquals(Integer.parseInt(expectedId), product.id);
            assertEquals(name, product.name);
        }
    }

    @Test
    public void testGetProducts() {
        Product product1 = new Product(1, "Product1");
        Product product2 = new Product(2, "Product2");
        List<Product> products = Arrays.asList(product1, product2);
        ProductRepo productRepo = new ProductRepo(products);

        List<Product> returnedProducts = productRepo.getProducts();
        assertNotNull(returnedProducts); // The returned list should not be null
        assertEquals(2, returnedProducts.size()); // The returned list should have 2 products

        // Check that the returned products are the same as the ones we put in
        assertTrue(returnedProducts.containsAll(products));
    }
}
