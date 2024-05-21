package com.bibliotheque.gestionbibliotheque.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bibliotheque.gestionbibliotheque.Repository.EmpruntRepository;
import com.bibliotheque.gestionbibliotheque.entities.Emprunt;

import java.util.List;
import java.util.Optional;

@Service
public class EmpruntService {
    private final EmpruntRepository empruntRepository;

    @Autowired
    public EmpruntService(EmpruntRepository empruntRepository) {
        this.empruntRepository = empruntRepository;
    }

    public List<Emprunt> getAllEmprunts() {
        return empruntRepository.findAll();
    }

    public Optional<Emprunt> getEmpruntById(Long id) {
        return empruntRepository.findById(id);
    }

    public Emprunt createEmprunt(Emprunt emprunt) {
        return empruntRepository.save(emprunt);
    }

    public Emprunt updateEmprunt(Long id, Emprunt updatedEmprunt) {
        updatedEmprunt.setId(id);
        return empruntRepository.save(updatedEmprunt);
    }

    public void deleteEmprunt(Long id) {
        empruntRepository.deleteById(id);
    }
}
