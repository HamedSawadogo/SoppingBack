package com.springmapping.springmapping.entities.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
public class CommandLineDto {
    private Long id;
    private ProductDto product;
    private int quantite;
}
