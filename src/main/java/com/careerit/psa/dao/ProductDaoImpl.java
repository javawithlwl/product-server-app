package com.careerit.psa.dao;

import com.careerit.psa.domain.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
@RequiredArgsConstructor

public class ProductDaoImpl implements ProductDao {

  private final JdbcTemplate jdbcTemplate;

  @Override
  public Product insertProduct(Product product) {
    KeyHolder keyHolder = new GeneratedKeyHolder();
    jdbcTemplate.update(con -> {
      PreparedStatement pst = con.prepareStatement(ProductQueries.ADD_PRODUCT, new String[] { "id" });
      pst.setString(1, product.getName());
      pst.setString(2, product.getDescription());
      pst.setDouble(3, product.getPrice());
      pst.setDouble(4, product.getDiscount());
      return pst;
    }, keyHolder);
    Long id =  keyHolder.getKey().longValue();
    product.setId(id);
    return product;
  }

  @Override
  public List<Product> selectProducts() {
    List<Product> products = jdbcTemplate.query(ProductQueries.GET_PRODUCTS, productRowMapper());
    return products;
  }

  @Override
  public Product selectProduct(Long id) {
    List<Product> products = jdbcTemplate.query(ProductQueries.GET_PRODUCT,
        (ps) -> {
          ps.setLong(1, id);
        },
        productRowMapper());
    if (!CollectionUtils.isEmpty(products)) {
      return products.get(0);
    }
    throw new IllegalArgumentException("Product with given id is not found");
  }

  @Override
  public Product updateProduct(Product product) {
    jdbcTemplate.update(ProductQueries.UPDATE_PRODUCT, product.getName(),
        product.getDescription(), product.getPrice(),
        product.getDiscount(), product.getId());

    return product;
  }

  @Override
  public boolean deleteProduct(Long id) {
    int count = jdbcTemplate.update(ProductQueries.DELETE_PRODUCT, ps -> ps.setLong(1,id));
    return count != 0;
  }

  public RowMapper<Product> productRowMapper() {
    return (rs, rn) -> {
      Product product = new Product();
      product.setId(rs.getLong("id"));
      product.setName(rs.getString("name"));
      product.setDescription(rs.getString("description"));
      product.setPrice(rs.getDouble("price"));
      product.setDiscount(rs.getDouble("discount"));
      return product;
    };
  }
}
