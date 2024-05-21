// package com.bibliotheque.gestionbibliotheque.entities;

// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.SequenceGenerator;
// import jakarta.persistence.Table;

// import java.io.Serializable;
// import lombok.*;

// @Data
// @ToString
// @Entity
// @Table(name = "user")
// public class user implements Serializable {
// @Id
// @GeneratedValue(strategy = GenerationType.SEQUENCE, generator =
// "user_sequence")
// @SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence",
// allocationSize = 100)
// private Long id;
// private String nomComplet;
// private String adresse;
// private String email;
// private String contact;
// private String nomUtilisateur;
// private String motDePasse;
// private boolean enabled = false;
// private String confirmationToken;
// }