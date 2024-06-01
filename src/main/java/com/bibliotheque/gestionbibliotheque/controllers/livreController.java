package com.bibliotheque.gestionbibliotheque.controllers;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bibliotheque.gestionbibliotheque.entities.livre;
import com.bibliotheque.gestionbibliotheque.services.livreService;

// @CrossOrigin("*")

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/livre")
public class livreController {

    @Autowired
    private livreService livreService;

    @PostMapping("/save")
    public livre createLivre(@RequestBody livre livre) {

        return livreService.saveLivre(livre);
    }

    @GetMapping("/{id}")
    public Optional<livre> getLivreById(@PathVariable Long id) {
        return livreService.findById(id);
    }

    @PutMapping("/{id}")
    public livre updateLivre(@PathVariable Long id, @RequestBody livre livreDetails) {
        livreDetails.setId(id);
        return livreService.updateLivre(livreDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteLivre(@PathVariable Long id) {
        livreService.deleteLivre(id);
    }

    @GetMapping
    public List<livre> getAllLivres() {
        return livreService.findAll();
    }

    @GetMapping("/{id}/disponibilite")
    public ResponseEntity<Boolean> verifierDisponibilite(@PathVariable Long id) {
        boolean disponible = livreService.verifierDisponibilite(id);
        return ResponseEntity.ok(disponible);
    }

    @PutMapping("/{id}/disponibilite")
    public ResponseEntity<Void> updateDisponibilite(@PathVariable Long id, @RequestBody Map<String, Boolean> body) {
        boolean disponible = body.get("disponible");
        livreService.updateDisponibiliteLivre(id, disponible);
        return ResponseEntity.ok().build();
    }

}
