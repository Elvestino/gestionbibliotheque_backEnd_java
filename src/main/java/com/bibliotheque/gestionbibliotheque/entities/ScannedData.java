package com.bibliotheque.gestionbibliotheque.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.*;

import java.io.Serializable;
import lombok.*;

@Data
@ToString
@Entity
@Table(name = "scanneddata")
public class ScannedData implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "scanneddata_sequence")
    @SequenceGenerator(name = "scanneddata_sequence", sequenceName = "scanneddata_sequence", allocationSize = 100)
    private Long id;
    private String text;
}