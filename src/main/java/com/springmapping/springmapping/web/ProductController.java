package com.springmapping.springmapping.web;
import com.springmapping.springmapping.Exceptions.ProductNotFoundExecption;
import com.springmapping.springmapping.entities.Dto.ProductDto;
import com.springmapping.springmapping.service.ProductServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class ProductController {

    ProductServiceImpl productService;

    public  ProductController(ProductServiceImpl productService){
        this.productService=productService;
    }

    @GetMapping("/api/products")
    public ResponseEntity<List<ProductDto>> getProducts(){
        try{
            return  ResponseEntity.ok().body(productService.getEntities());
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/api/add/product")
    public ResponseEntity<ProductDto> addProduct(@RequestBody ProductDto productDto){
        try {
            return  ResponseEntity.ok().body(this.productService.saveEntity(productDto));
        } catch (ProductNotFoundExecption e) {
            return  ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/api/product/{id}")
    public  ResponseEntity<ProductDto> getProductById(@PathVariable("id")Long id){
        try {
            return ResponseEntity.ok().body(this.productService.findEntityByid(id)) ;
        } catch (ProductNotFoundExecption e) {
            return  ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/api/find/product/{name}")
    public ResponseEntity<ProductDto> getProductByName(@PathVariable("name")String name){
        try{
            return  ResponseEntity.ok().body(this.productService.findByName(name));
        }catch (Exception e){
            return  ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/api/delete/product/{id}")
    public  ResponseEntity<String> deleteProductById(@PathVariable("id")Long id){
        try {
            this.productService.deleteEntityById(id);
            return  ResponseEntity.ok().body("Produit Supprimé avec success");
        } catch (ProductNotFoundExecption e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
