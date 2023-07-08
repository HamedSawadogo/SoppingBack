package com.springmapping.springmapping.web;


import com.springmapping.springmapping.entities.Product;
import com.springmapping.springmapping.service.ProductServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {


    private ProductServiceImpl productService;

    public  ProductController(ProductServiceImpl productService){
        this.productService=productService;
    }

    @GetMapping("/api/products")
    public List<Product>getProducts(){
        return  this.productService.getProducts();
    }

    @PostMapping("/api/add/product")
    public Product addProduct(@RequestBody Product product){
        return  this.productService.addProduct(product);
    }

    @GetMapping("/api/product/{id}")
    public  Product getProductById(@PathVariable("id")Long id){
        return  this.productService.findProductById(id);
    }

    @GetMapping("/api/find/product/{name}")
    public Product getProductByName(@PathVariable("name")String name){
        return  this.productService.findProductByName(name);
    }

    @DeleteMapping("/api/delete/product/{id}")
    public  void deleteProductById(@PathVariable("id")Long id){
        this.productService.deleteProduct(id);
    }
}
