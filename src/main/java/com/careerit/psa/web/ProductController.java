package com.careerit.psa.web;

import com.careerit.psa.domain.Product;
import com.careerit.psa.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping("/add")
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
      Product retProduct = productService.addProduct(product);
      return ResponseEntity.ok(retProduct);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Product>> getProducts(){
        List<Product> list = productService.getProducts();
        return ResponseEntity.ok(list);
    }
}
