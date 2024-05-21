package com.bibliotheque.gestionbibliotheque.entities;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.*;

@Data
@ToString
@Entity
@Table(name = "emprunt")
public class Emprunt implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "emprunt_sequence")
    @SequenceGenerator(name = "emprunt_sequence", sequenceName = "emprunt_sequence", allocationSize = 100)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "adherent_id")
    private adherent adherent;

    @ManyToOne
    @JoinColumn(name = "livre_id")
    private livre livre;

    private LocalDate dateEmprunt;
    private LocalDate dateRetour;

}