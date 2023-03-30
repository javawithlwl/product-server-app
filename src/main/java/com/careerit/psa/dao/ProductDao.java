package com.careerit.psa.dao;

import com.careerit.psa.domain.Product;

import java.util.List;

public interface ProductDao {

    Product insertProduct(Product product);
    List<Product> selectProducts();
    Product selectProduct(Long id);
    Product updateProduct(Product product);
    boolean deleteProduct(Long id);
}
