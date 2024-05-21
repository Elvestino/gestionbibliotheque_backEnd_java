// package com.bibliotheque.gestionbibliotheque.controllers;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;
// import com.bibliotheque.gestionbibliotheque.services.*;
// import com.bibliotheque.gestionbibliotheque.entities.*;
// import org.springframework.http.HttpHeaders;

// @CrossOrigin(origins = "http://localhost:4200")
// @RestController
// @RequestMapping("/enregistrement")
// public class UserController {

// @Autowired
// private UserService userService;

// @PostMapping("/login")
// public ResponseEntity<?> login(@RequestBody user user) {
// HttpHeaders headers = new HttpHeaders();
// headers.add("Access-Control-Allow-Origin", "http://localhost:4200"); //
// Remplacez par l'URL de votre client
// return ResponseEntity.ok().headers(headers).body("connexion réussie");

// }

// // @PostMapping("/save")
// // public user createUser(@RequestBody user user) {
// // return userService.registerUser(user);
// // }

// @GetMapping("/confirm")
// public user confirmUser(@RequestParam String token) {
// return userService.confirmUser(token);
// }
// }
