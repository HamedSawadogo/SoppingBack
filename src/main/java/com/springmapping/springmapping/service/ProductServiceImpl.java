package com.springmapping.springmapping.service;
import com.springmapping.springmapping.Exceptions.ProductNotFoundExecption;
import com.springmapping.springmapping.entities.Categorie;
import com.springmapping.springmapping.entities.Dto.ProductDto;
import com.springmapping.springmapping.entities.Product;
import com.springmapping.springmapping.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Transactional
@Service
public class ProductServiceImpl implements ProductServive,IDto<Product, ProductDto> {

    ProductRepository repository;
    ModelMapper modelMapper;

    public  ProductServiceImpl(ProductRepository repository, ModelMapper modelMapper){
        this.repository=repository;
        this.modelMapper=modelMapper;
    }

    @Override
    public ProductDto convertEntityToDto(Product product) {
        /**return ProductDto.builder()
                .id(product.getId())
                .url(product.getUrl())
                .prix(product.getPrix())
                .categorie(product.getCategorie().getNomCategorie())
                .designation(product.getDesignation())
                .build();**/
      return   modelMapper.map(product,ProductDto.class);
    }

    @Override
    public Product convertDtoToEntity(ProductDto dto) {
        /**Product product=new Product();
        product.setUrl(dto.getUrl());
        Categorie categorie=new Categorie();
        categorie.setNomCategorie(dto.getCategorie());
        product.setCategorie(categorie);
        product.setDesignation(dto.getDesignation());
        product.setPrix(dto.getPrix());
        product.setId(dto.getId());
        return product;**/
        return  modelMapper.map(dto,Product.class);
    }

    /**
     * rechercher un produit par son Identifiant
     * @param id
     * @return
     * @throws ProductNotFoundExecption
     */
    @Override
    public ProductDto findEntityByid(Long id) throws ProductNotFoundExecption {
        Optional<Product>optionalProduct=this.repository.findById(id);
        return this.convertEntityToDto(optionalProduct.
                orElseThrow(()->new  ProductNotFoundExecption("ce produit n'existe pas"))) ;
    }

    /**
     * renvoie la liste des prouits DTO
     * @return List<ProductDTO>
     */
    @Override
    public List<ProductDto> getEntities() {
        return this.repository.findAll().stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    /**
     * supprimer un produit DTO
     * @param aLong
     */
    @Override
    public void deleteEntityById(Long id) throws ProductNotFoundExecption {
        Optional<Product>product=this.repository.findById(id);
        if(product.isPresent()){
            this.repository.deleteById(id);
            return;
        }
        throw new ProductNotFoundExecption("ce produit n'existe pas");
    }
    /**
     * enregistrer un produit DTO
     * @param productDto
     * @return
     */
    @Override
    public ProductDto saveEntity(ProductDto productDto) throws ProductNotFoundExecption {
        if(productDto==null){
            throw new ProductNotFoundExecption("une erreur est survenue");
        }
        Product product=this.convertDtoToEntity(productDto);
        return this.convertEntityToDto(this.repository.save(product));
    }

    /**
     * renvoie la liste des produits DTO por nom
     * @param name
     * @return
     */
    @Override
    public List<ProductDto> findAllByName(String designation) {
        return this.repository.findAllByDesignation(designation)
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    /**
     * mettre a jour un Produit
     * @param aLong
     * @param entity
     */
    @Override
    public void updateEntity(Long id, ProductDto dto) throws ProductNotFoundExecption {
        Optional<Product> product=this.repository.findById(id);
        if(product.isPresent()){
            ProductDto productDto=this.convertEntityToDto(product.get());

            //productDto.setCategorie(dto.getCategorie());
            productDto.setDesignation(dto.getDesignation());
            productDto.setPrix(dto.getPrix());
            //convertir et enregistrer le Produit DTO dans la base de donnée
            this.repository.save(this.convertDtoToEntity(productDto));
        }else{
            throw new ProductNotFoundExecption("ce produit n'existe pas");
        }
    }
    @Override
    public ProductDto findByName(String name) {
        return this.convertEntityToDto(this.repository.findByName(name));
    }
}
