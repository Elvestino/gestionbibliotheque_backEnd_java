package com.bibliotheque.gestionbibliotheque.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.Set;

import lombok.*;

@Data
@ToString
@Entity
@Table(name = "livre")
public class livre implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "livre_sequence")

    @SequenceGenerator(name = "livre_sequence", sequenceName = "livre_sequence", allocationSize = 100)
    private Long id;
    private String titreLivre;
    private String auteurLivre;
    private Integer editionLivre;
    private String description;
    private String categorie;
    private String imageUrl;

    @OneToMany(mappedBy = "livre")
    private Set<Emprunt> emprunts;

}