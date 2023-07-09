package com.springmapping.springmapping.repository;

import com.springmapping.springmapping.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client,String> {

    Client findByNom(String nom);
    List<Client>findAllByNom(String clientName);
}
