package com.springmapping.springmapping.entities.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor @AllArgsConstructor
public class ProductDto {
    private Long id;
    private String designation;
    private Double prix;
    private String url;
    private CategorieDto categorie;
}
