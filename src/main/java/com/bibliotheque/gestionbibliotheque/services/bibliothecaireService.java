package com.bibliotheque.gestionbibliotheque.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bibliotheque.gestionbibliotheque.entities.bibliothecaire;

import com.bibliotheque.gestionbibliotheque.Repository.bibliothecaireRepository;

@Service

public class bibliothecaireService {
    @Autowired
    private bibliothecaireRepository bibliothecaireRepository;

    public bibliothecaire saveBiblio(bibliothecaire bibliothecaire) {
        return bibliothecaireRepository.save(bibliothecaire);
    }

    public bibliothecaire findBiblioById(Long id) {
        return bibliothecaireRepository.findById(id).orElse(null);
    }

    public List<bibliothecaire> findAll() {
        return bibliothecaireRepository.findAll();
    }

    public bibliothecaire updateBiblio(bibliothecaire bibliothecaire) {
        if (bibliothecaire.getId() == null) {
            throw new IllegalArgumentException("La bibliothecaire doit avoir un ID");
        }
        return bibliothecaireRepository.save(bibliothecaire);
    }

    public void deleteBiblio(Long id) {
        bibliothecaireRepository.deleteById(id);
    }
}
