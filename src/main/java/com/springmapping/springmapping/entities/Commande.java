package com.springmapping.springmapping.entities;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@DynamicUpdate
@Table
@NoArgsConstructor @AllArgsConstructor
public class Commande {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * les lignes de commandes  asccociés a cette commande
     */
    @OneToMany(mappedBy = "commande",cascade = CascadeType.ALL)
    private List<CommandLine>lignesCommande=new ArrayList<>();

    /**
     * la date de la commande
     */
    @Column(name = "date_commande")
    private Date date;

    /**
     * le Client propiétaire de la commande
     */
    @ManyToOne(cascade ={
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private  Client client;


}

