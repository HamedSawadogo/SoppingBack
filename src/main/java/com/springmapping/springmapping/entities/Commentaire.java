package com.springmapping.springmapping.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import java.util.Date;

@Data
@Entity
@DynamicUpdate
@Table
@NoArgsConstructor @AllArgsConstructor
public class Commentaire {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    /**
     * le corps du message
     */
    @Column(nullable = false,length = 100)
    private String message;

    /**
     * represente la date de creation du commentaire
     */
    @Column(name = "date_creation",nullable = false)
    private Date createdAt;

    /**
     * le produit cible du Commentaire
     */
    @ManyToOne(cascade ={
            CascadeType.MERGE,
            CascadeType.PERSIST
    })
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Product product;
}
