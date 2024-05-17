package com.bibliotheque.gestionbibliotheque.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bibliotheque.gestionbibliotheque.entities.adherent;

@Repository
public interface adherentRepository extends JpaRepository<adherent, Long> {

}
