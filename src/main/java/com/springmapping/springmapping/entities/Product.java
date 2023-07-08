package com.springmapping.springmapping.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
@DynamicUpdate
@Table
@NoArgsConstructor @AllArgsConstructor
public class Product implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /***
     * l'Image du produit
     */
    private String url;

    @Column(nullable = false,length = 30)
    private String designation;

    private Double prix;

    /**
     * ne peut pas utiliser MappedBy car l'entité propriétaire qui définit
     *  Persister la catégorie du produit l'orsque le produit est créee
     *  pas besoin de sauvegarder la categorie
     */
    @ManyToOne(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    private Categorie categorie;

    /**
     * liste des commentaires du produit
     */
    @OneToMany(mappedBy = "product",cascade =CascadeType.ALL)
    private List<Commentaire>commentaires;

}
