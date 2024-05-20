package com.bibliotheque.gestionbibliotheque.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.bibliotheque.gestionbibliotheque.entities.bibliothecaire;
import com.bibliotheque.gestionbibliotheque.services.bibliothecaireService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/bibliothecaire")
public class bibliothecaireController {

    @Autowired
    private bibliothecaireService bibliothecaireService;

    @PostMapping("/save")
    public bibliothecaire createbibliothecaire(@RequestBody bibliothecaire bibliothecaire) {
        System.out.println("data : " + bibliothecaire);
        return bibliothecaireService.saveBiblio(bibliothecaire);
    }

    @GetMapping("/{id}")
    public bibliothecaire getbibliothecaireById(@PathVariable Long id) {
        return bibliothecaireService.findBiblioById(id);
    }

    @PutMapping("/{id}")
    public bibliothecaire updatebibliothecaire(@PathVariable Long id,
            @RequestBody bibliothecaire bibliothecaireDetails) {
        bibliothecaireDetails.setId(id);
        return bibliothecaireService.updateBiblio(bibliothecaireDetails);
    }

    @DeleteMapping("/{id}")
    public void deletebibliothecaire(@PathVariable Long id) {
        bibliothecaireService.deleteBiblio(id);
    }

    @GetMapping
    public List<bibliothecaire> getAllbibliothecaires() {
        return bibliothecaireService.findAll();
    }
}
