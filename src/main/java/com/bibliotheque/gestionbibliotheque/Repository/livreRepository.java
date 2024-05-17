package com.bibliotheque.gestionbibliotheque.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bibliotheque.gestionbibliotheque.entities.livre;

@Repository
public interface livreRepository extends JpaRepository<livre, Long> {

}
