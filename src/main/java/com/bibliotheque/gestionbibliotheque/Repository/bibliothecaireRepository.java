package com.bibliotheque.gestionbibliotheque.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bibliotheque.gestionbibliotheque.entities.bibliothecaire;

@Repository
public interface bibliothecaireRepository extends JpaRepository<bibliothecaire, Long> {

}
