package com.bibliotheque.gestionbibliotheque.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bibliotheque.gestionbibliotheque.entities.ScannedData;

@Repository
public interface ScannedDataRepository extends JpaRepository<ScannedData, Long> {
}