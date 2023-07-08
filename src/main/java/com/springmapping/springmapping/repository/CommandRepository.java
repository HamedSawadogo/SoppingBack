package com.springmapping.springmapping.repository;

import com.springmapping.springmapping.entities.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandRepository  extends JpaRepository<Commande,Long> {
}
