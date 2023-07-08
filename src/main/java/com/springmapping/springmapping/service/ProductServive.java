package com.springmapping.springmapping.service;

import com.springmapping.springmapping.entities.Product;


import java.util.List;

public interface ProductServive{
    Product addProduct(Product product);
    void deleteProduct(Long productId);
    List<Product>getProducts();
    Product findProductById(Long id);
    Product findProductByName(String name);
}
