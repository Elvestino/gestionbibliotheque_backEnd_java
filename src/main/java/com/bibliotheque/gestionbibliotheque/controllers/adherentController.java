package com.bibliotheque.gestionbibliotheque.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.bibliotheque.gestionbibliotheque.entities.adherent;
import com.bibliotheque.gestionbibliotheque.services.adherentService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/adherent")
public class adherentController {
    @Autowired
    private adherentService adherentService;

    @PostMapping("/save")
    public adherent createadherent(@RequestBody adherent adherent) {

        return adherentService.saveBiblio(adherent);
    }

    @GetMapping("/{id}")
    public Optional<adherent> getadherentById(@PathVariable Long id) {
        return adherentService.findById(id);
    }

    @PutMapping("/{id}")
    public adherent updateadherent(@PathVariable Long id, @RequestBody adherent adherentDetails) {
        adherentDetails.setId(id);
        return adherentService.updateBiblio(adherentDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteadherent(@PathVariable Long id) {
        adherentService.deleteBiblio(id);
    }

    @GetMapping
    public List<adherent> getAlladherents() {
        return adherentService.findAll();
    }
}
