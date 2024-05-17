package com.bibliotheque.gestionbibliotheque.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bibliotheque.gestionbibliotheque.Repository.adherentRepository;
import com.bibliotheque.gestionbibliotheque.entities.adherent;

@Service

public class adherentService {
    @Autowired
    private adherentRepository adherentRepository;

    public adherent saveBiblio(adherent adherent) {
        return adherentRepository.save(adherent);
    }

    public adherent findBiblioById(Long id) {
        return adherentRepository.findById(id).orElse(null);
    }

    public adherent updateBiblio(adherent adherent) {
        if (adherent.getId() == null) {
            throw new IllegalArgumentException("La adherent doit avoir un ID");
        }
        return adherentRepository.save(adherent);
    }

    public List<adherent> findAll() {
        return adherentRepository.findAll();
    }

    public void deleteBiblio(Long id) {
        adherentRepository.deleteById(id);
    }
}
