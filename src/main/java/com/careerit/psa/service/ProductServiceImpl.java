package com.careerit.psa.service;

import com.careerit.psa.dao.ProductDao;
import com.careerit.psa.domain.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements  ProductService{

  private final ProductDao productDao;

  @Override
  public Product addProduct(Product product) {
    Assert.notNull(product,"Product can not be null");
    Product savedProduct = productDao.insertProduct(product);
    log.info("Product is added with id {}",savedProduct.getId());
    return product;
  }

  @Override
  public List<Product> getProducts() {
    List<Product> list = productDao.selectProducts();
    log.info("Product count is :{}",list.size());
    return list;
  }

  @Override
  public Product getProduct(Long id) {
    return null;
  }

  @Override
  public Product updateProduct(Product product) {
    return null;
  }

  @Override
  public boolean deleteProduct(Long id) {
    return false;
  }
}
