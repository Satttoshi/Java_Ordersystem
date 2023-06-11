package org.module;

import java.util.Map;

public interface Product {
    String getProduct(String name);
    Map<String, String> listProducts();
}
