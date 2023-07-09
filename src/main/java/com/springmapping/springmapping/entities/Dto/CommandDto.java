package com.springmapping.springmapping.entities.Dto;

import com.springmapping.springmapping.entities.Client;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Builder
@Data
@NoArgsConstructor @AllArgsConstructor
public class CommandDto {
    private Long id;
    private Date date;
    List<CommandLineDto>lignesCommande;
    ClientDto client;
}
