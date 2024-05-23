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
    private int joursEmprunt;
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public adherent getAdherent() {
        return adherent;
    }

    public void setAdherent(adherent adherent) {
        this.adherent = adherent;
    }

    public livre getLivre() {
        return livre;
    }

    public void setLivre(livre livre) {
        this.livre = livre;
    }

    public LocalDate getDateEmprunt() {
        return dateEmprunt;
    }

    public void setDateEmprunt(LocalDate dateEmprunt) {
        this.dateEmprunt = dateEmprunt;
    }

    public LocalDate getDateRetour() {
        return dateRetour;
    }

    public void setDateRetour(LocalDate dateRetour) {
        this.dateRetour = dateRetour;
    }

    public int getJoursEmprunt() {
        return joursEmprunt;
    }

    public void setJoursEmprunt(int joursEmprunt) {
        this.joursEmprunt = joursEmprunt;
    }

    public String isStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}