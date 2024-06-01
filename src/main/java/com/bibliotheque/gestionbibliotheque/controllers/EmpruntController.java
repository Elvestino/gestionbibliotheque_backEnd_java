package com.bibliotheque.gestionbibliotheque.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bibliotheque.gestionbibliotheque.dto.EmpruntRequestDTO;
import com.bibliotheque.gestionbibliotheque.entities.*;
import com.bibliotheque.gestionbibliotheque.services.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/emprunts")
public class EmpruntController {

    @Autowired
    private EmpruntService empruntService;

    @Autowired
    private adherentService adherentService;

    @Autowired
    private livreService livreService;

    public EmpruntController(EmpruntService empruntService, adherentService adherentService,
            livreService livreService) {
        this.empruntService = empruntService;
        this.adherentService = adherentService;
        this.livreService = livreService;
    }

    @GetMapping
    public List<Emprunt> getAllEmprunts() {
        return empruntService.getAllEmprunts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Emprunt> getEmpruntById(@PathVariable Long id) {
        Optional<Emprunt> emprunt = empruntService.getEmpruntById(id);
        return emprunt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/save")
    public ResponseEntity<Emprunt> createEmprunt(@RequestBody EmpruntRequestDTO empruntRequest) {

        Optional<adherent> adherentOpt = adherentService.findById(empruntRequest.getAdherentId());

        Optional<livre> livreOpt = livreService.findById(empruntRequest.getLivreId());

        if (adherentOpt.isPresent() && livreOpt.isPresent()) {

            Emprunt emprunt = new Emprunt();
            emprunt.setAdherent(adherentOpt.get());
            emprunt.setLivre(livreOpt.get());
            emprunt.setJoursEmprunt(empruntRequest.getJoursEmprunt());
            livre livreEntity = livreOpt.get();
            livreEntity.setDisponible(false);
            livreService.saveLivre(livreEntity);
            Emprunt createdEmprunt = empruntService.createEmprunt(emprunt);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdEmprunt);
        } else {

            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/return/{id}")
    public ResponseEntity<Emprunt> returnLivre(@PathVariable Long id) {
        Emprunt updatedEmprunt = empruntService.returnLivre(id);
        return ResponseEntity.ok(updatedEmprunt);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Emprunt> updateEmprunt(@PathVariable Long id, @RequestBody Emprunt updatedEmprunt) {
        Optional<adherent> adherent = adherentService.findById(updatedEmprunt.getAdherent().getId());
        Optional<livre> livre = livreService.findById(updatedEmprunt.getLivre().getId());

        if (adherent.isPresent() && livre.isPresent()) {
            updatedEmprunt.setAdherent(adherent.get());
            updatedEmprunt.setLivre(livre.get());
            Emprunt emprunt = empruntService.updateEmprunt(id, updatedEmprunt);
            return ResponseEntity.ok(emprunt);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmprunt(@PathVariable Long id) {
        empruntService.deleteEmprunt(id);
        return ResponseEntity.noContent().build();
    }
}
