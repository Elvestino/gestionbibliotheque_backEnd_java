package com.bibliotheque.gestionbibliotheque.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bibliotheque.gestionbibliotheque.Exception.ResourceNotFoundException;
import com.bibliotheque.gestionbibliotheque.Repository.EmpruntRepository;
import com.bibliotheque.gestionbibliotheque.entities.Emprunt;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EmpruntService {
    @Autowired
    private EmpruntRepository empruntRepository;

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
        emprunt.setDateEmprunt(LocalDate.now());
        emprunt.setDateRetour(LocalDate.now().plusDays(emprunt.getJoursEmprunt()));
        emprunt.setStatus(" Deja emprunter"); // Marquer comme emprunté
        return empruntRepository.save(emprunt);
    }

    public Emprunt returnLivre(Long empruntId) {
        Optional<Emprunt> empruntOpt = empruntRepository.findById(empruntId);
        if (empruntOpt.isPresent()) {
            Emprunt emprunt = empruntOpt.get();
            emprunt.setStatus("Deja Retourner"); // Marquer comme retourné
            return empruntRepository.save(emprunt);
        }
        throw new ResourceNotFoundException("Emprunt not found with id " + empruntId);
    }

    public Emprunt updateEmprunt(Long id, Emprunt updatedEmprunt) {
        updatedEmprunt.setId(id);
        return empruntRepository.save(updatedEmprunt);
    }

    public void deleteEmprunt(Long id) {
        empruntRepository.deleteById(id);
    }
}
