package com.careerit.psa.service;

import com.careerit.psa.domain.Product;

import java.util.List;

public interface ProductService {

    Product addProduct(Product product);
    List<Product> getProducts();
    Product getProduct(Long id);
    Product updateProduct(Product product);
    boolean deleteProduct(Long id);
}
