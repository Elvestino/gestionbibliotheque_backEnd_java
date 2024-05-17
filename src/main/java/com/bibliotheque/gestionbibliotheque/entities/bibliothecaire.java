package com.bibliotheque.gestionbibliotheque.entities;

import java.io.Serializable;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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
    private Date date_naissance;
    private String cin_biblio;
    private String lieu_naissance;
    private String tel_biblio;
    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getnom_biblio() {
        return nom_biblio;
    }

    public void setnom_biblio(String nom_biblio) {
        this.nom_biblio = nom_biblio;
    }

    public String getprenom_biblio() {
        return prenom_biblio;
    }

    public void setprenom_biblio(String prenom_biblio) {
        this.prenom_biblio = prenom_biblio;
    }

    public Date getdate_naissance() {
        return date_naissance;
    }

    public void setdate_naissance(Date date_naissance) {
        this.date_naissance = date_naissance;
    }

    public String getlieu_naissance() {
        return lieu_naissance;
    }

    public void setlieu_naissance(String lieu_naissance) {
        this.lieu_naissance = lieu_naissance;
    }

    public String getcin_biblio() {
        return cin_biblio;
    }

    public void setcin_biblio(String cin_biblio) {
        this.cin_biblio = cin_biblio;
    }

    public String gettel_biblio() {
        return tel_biblio;
    }

    public void settel_biblio(String tel_biblio) {
        this.tel_biblio = tel_biblio;
    }

}
