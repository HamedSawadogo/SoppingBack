package com.springmapping.springmapping.entities;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

@Data
@Entity
@DynamicUpdate
@Table
@NoArgsConstructor @AllArgsConstructor
public class CommandLine {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * le produit référencé
     */
    @OneToOne(cascade =
            {CascadeType.MERGE,
            CascadeType.PERSIST})
    private Product product;

    /**
     * la commande référencée
     */

    @ManyToOne(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Commande commande;

    /**
     * la quantité de ce produit
     */
    private int quantite;
}
