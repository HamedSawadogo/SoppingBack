package com.springmapping.springmapping.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@DynamicUpdate
@Table
@NoArgsConstructor @AllArgsConstructor
public class Client {

    @Id
    private String id;

    @Column(length = 30,nullable = false)
    private String nom;

    private String email;

    private String telephone;

    @OneToMany(mappedBy = "client")
    private List<Commande> commandes=new ArrayList<>();

    public  void addCommande(Commande commande){
        this.commandes.add(commande);
        commande.setClient(this);
    }
}
