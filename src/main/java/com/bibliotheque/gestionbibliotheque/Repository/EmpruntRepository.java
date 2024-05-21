package com.bibliotheque.gestionbibliotheque.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bibliotheque.gestionbibliotheque.entities.Emprunt;

@Repository
public interface EmpruntRepository extends JpaRepository<Emprunt, Long> {

}
