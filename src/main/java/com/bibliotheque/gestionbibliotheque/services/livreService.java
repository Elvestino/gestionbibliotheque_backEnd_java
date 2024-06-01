package com.bibliotheque.gestionbibliotheque.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bibliotheque.gestionbibliotheque.Exception.ResourceNotFoundException;
import com.bibliotheque.gestionbibliotheque.Repository.livreRepository;
import com.bibliotheque.gestionbibliotheque.entities.livre;

@Service

public class livreService {
    @Autowired
    private livreRepository livreRepository;

    public livre saveLivre(livre livre) {
        return livreRepository.save(livre);
    }

    public Optional<livre> findById(Long id) {
        return livreRepository.findById(id);
    }

    public livre updateLivre(livre livre) {
        return livreRepository.save(livre);
    }

    public List<livre> findAll() {
        return livreRepository.findAll();
    }

    public void deleteLivre(Long id) {
        livreRepository.deleteById(id);
    }

    public void updateDisponibiliteLivre(Long id, boolean disponible) {
        Optional<livre> livreOpt = livreRepository.findById(id);
        if (livreOpt.isPresent()) {
            livre livre = livreOpt.get();
            livre.setDisponible(disponible);
            livreRepository.save(livre);
        } else {
            throw new ResourceNotFoundException("Livre not found with id " + id);
        }
    }

    public boolean verifierDisponibilite(Long id) {
        Optional<livre> livreOpt = livreRepository.findById(id);
        return livreOpt.map(livre::isDisponible).orElse(false);
    }
}
