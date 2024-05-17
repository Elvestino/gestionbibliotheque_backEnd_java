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
@Table(name = "adherent")
public class adherent implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "adherent_sequence")

    @SequenceGenerator(name = "adherent_sequence", sequenceName = "adherent_sequence", allocationSize = 100)
    private Long id;
    private String nom_Adh;
    private String prenom_Adh;
    private Date dt_adhesion;
    private String adrs_Adh;
    private String categorie;
    private String tel_Adh;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getnom_Adh() {
        return nom_Adh;
    }

    public void setnom_Adh(String nom_Adh) {
        this.nom_Adh = nom_Adh;
    }

    public String getprenom_Adh() {
        return prenom_Adh;
    }

    public void setprenom_Adh(String prenom_Adh) {
        this.prenom_Adh = prenom_Adh;
    }

    public Date getdt_adhesion() {
        return dt_adhesion;
    }

    public void setdt_adhesion(Date dt_adhesion) {
        this.dt_adhesion = dt_adhesion;
    }

    public String getcategorie() {
        return categorie;
    }

    public void setcategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getadrs_Adh() {
        return adrs_Adh;
    }

    public void setadrs_Adh(String adrs_Adh) {
        this.adrs_Adh = adrs_Adh;
    }

    public String gettel_Adh() {
        return tel_Adh;
    }

    public void settel_Adh(String tel_Adh) {
        this.tel_Adh = tel_Adh;
    }

}
