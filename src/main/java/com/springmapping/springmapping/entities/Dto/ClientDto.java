package com.springmapping.springmapping.entities.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
public class ClientDto {
    private String id;
    private String nom;
    private String email;
    private String telephone;
}
