package org.module;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ProductRepoTest {

    private ProductRepo productRepo;
    private List<Product> products;

    @BeforeEach
    public void setup() {
        Product product1 = new Product(1, "Product1");
        Product product2 = new Product(2, "Product2");
        products = new ArrayList<>(Arrays.asList(product1, product2));
        productRepo = new ProductRepo(products);
    }

    @ParameterizedTest
    @MethodSource("provideTestCasesForGetProduct")
    public void testGetProductById(int id, Product expectedProduct) {
        Product resultProduct = productRepo.getProduct(id);
        assertEquals(expectedProduct, resultProduct);
    }

    @ParameterizedTest
    @MethodSource("provideTestCasesForGetProduct")
    public void testGetProductByName(String name, Product expectedProduct) {
        Product resultProduct = productRepo.getProduct(name);
        assertEquals(expectedProduct, resultProduct);
    }

    // Assume Product class has appropriate equals and hashCode methods
    private static Stream<Object[]> provideTestCasesForGetProduct() {
        Product product1 = new Product(1, "Product1");
        Product product2 = new Product(2, "Product2");
        return Stream.of(
            new Object[]{1, product1},
            new Object[]{2, product2},
            new Object[]{3, null},
            new Object[]{"Product1", product1},
            new Object[]{"Product2", product2},
            new Object[]{"Product3", null}
        );
    }
}
