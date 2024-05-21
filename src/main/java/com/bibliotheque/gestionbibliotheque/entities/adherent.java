package com.bibliotheque.gestionbibliotheque.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.*;

@Data
@ToString
@Entity
@Table(name = "adherent")
public class adherent implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "adherent_sequence")

    @SequenceGenerator(name = "adherent_sequence", sequenceName = "adherent_sequence", allocationSize = 100)
    private Long id;
    private String nom_Adh;
    private String prenom_Adh;
    private LocalDate dt_adhesion;
    private String adrs_Adh;
    private String categorie;
    private String tel_Adh;

    @OneToMany(mappedBy = "adherent")
    private Set<Emprunt> emprunts;

}
