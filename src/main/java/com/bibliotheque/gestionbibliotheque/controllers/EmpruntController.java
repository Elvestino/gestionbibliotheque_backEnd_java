package com.bibliotheque.gestionbibliotheque.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bibliotheque.gestionbibliotheque.entities.Emprunt;
import com.bibliotheque.gestionbibliotheque.services.EmpruntService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/emprunts")
public class EmpruntController {
    private final EmpruntService empruntService;

    @Autowired
    public EmpruntController(EmpruntService empruntService) {
        this.empruntService = empruntService;
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

    @PostMapping
    public ResponseEntity<Emprunt> createEmprunt(@RequestBody Emprunt emprunt) {
        Emprunt createdEmprunt = empruntService.createEmprunt(emprunt);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEmprunt);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Emprunt> updateEmprunt(@PathVariable Long id, @RequestBody Emprunt updatedEmprunt) {
        Emprunt emprunt = empruntService.updateEmprunt(id, updatedEmprunt);
        return ResponseEntity.ok(emprunt);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmprunt(@PathVariable Long id) {
        empruntService.deleteEmprunt(id);
        return ResponseEntity.noContent().build();
    }
}
