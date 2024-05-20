package com.bibliotheque.gestionbibliotheque.entities;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.*;

@Data
@ToString
@Entity
@Table(name = "bibliothecaire")
public class bibliothecaire implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bibliothecaire_sequence")

    @SequenceGenerator(name = "bibliothecaire_sequence", sequenceName = "bibliothecaire_sequence", allocationSize = 100)
    private Long id;
    private String nom_biblio;
    private String prenom_biblio;
    private LocalDate date_naissance;
    private String cin_biblio;
    private String lieu_naissance;
    private String tel_biblio;
}
