package com.springmapping.springmapping.service;

import com.springmapping.springmapping.entities.Product;
import com.springmapping.springmapping.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class ProductServiceImpl implements ProductServive{

    private final ProductRepository productRepository;

    public  ProductServiceImpl(ProductRepository productRepository){
        this.productRepository=productRepository;
    }

    @Override
    public Product addProduct(Product product) {
        return this.productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long productId) {
       this.productRepository.deleteById(productId);
    }

    @Override
    public List<Product> getProducts() {
        return this.productRepository.findAll();
    }

    @Override
    public Product findProductById(Long id) {
        return this.productRepository.findById(id).orElse(null);
    }

    @Override
    public Product findProductByName(String name) {
        return this.productRepository.findByName(name);
    }
}
