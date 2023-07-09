package com.springmapping.springmapping.repository;

import com.springmapping.springmapping.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    /**
     * renvoie un produit par son Nom
     * @param designation
     * @return
     */
    @Query("select p from Product  p where p.designation  like :x")
    Product findByName(@Param("x")String designation);

    /**
     * renvoie la liste des produits par designation
     * @return
     */
    List<Product>findAllByDesignation(String designation);
}
