package com.bibliotheque.gestionbibliotheque.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.bibliotheque.gestionbibliotheque.entities.livre;
import com.bibliotheque.gestionbibliotheque.services.livreService;

// @CrossOrigin("*")

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/livre")
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
}
