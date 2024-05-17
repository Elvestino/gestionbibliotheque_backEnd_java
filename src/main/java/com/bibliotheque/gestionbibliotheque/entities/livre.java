package com.bibliotheque.gestionbibliotheque.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import java.io.Serializable;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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
    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String gettitreLivre() {
        return titreLivre;
    }

    public void settitreLivre(String titreLivre) {
        this.titreLivre = titreLivre;
    }

    public String getauteurLivre() {
        return auteurLivre;
    }

    public void setauteurLivre(String auteurLivre) {
        this.auteurLivre = auteurLivre;
    }

    public Integer geteditionLivre() {
        return editionLivre;
    }

    public void seteditionLivre(Integer editionLivre) {
        this.editionLivre = editionLivre;
    }

    public String getdescription() {
        return description;
    }

    public void setdescription(String description) {
        this.description = description;
    }

    public String getcategorie() {
        return categorie;
    }

    public void setcategorie(String categorie) {
        this.categorie = categorie;
    }

}