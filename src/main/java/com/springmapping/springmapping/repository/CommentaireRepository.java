package com.springmapping.springmapping.repository;
import com.springmapping.springmapping.entities.Commentaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentaireRepository  extends JpaRepository<Commentaire,Long> {
}
