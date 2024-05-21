// package com.bibliotheque.gestionbibliotheque.services;

// import org.springframework.beans.factory.annotation.Autowired;
// // import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.stereotype.Service;

// import com.bibliotheque.gestionbibliotheque.Repository.UserRepository;
// import com.bibliotheque.gestionbibliotheque.entities.*;

// import java.util.UUID;

// @Service
// public class UserService {

// @Autowired
// private UserRepository userRepository;

// @Autowired
// private EmailService emailService;

// // @Autowired
// // private PasswordEncoder passwordEncoder;

// // public user registerUser(user user) {
// // user.setMotDePasse(passwordEncoder.encode(user.getMotDePasse()));
// // user.setConfirmationToken(UUID.randomUUID().toString());
// // userRepository.save(user);
// // emailService.sendConfirmationEmail(user);
// // return user;
// // }

// public user confirmUser(String token) {
// user user = userRepository.findByConfirmationToken(token);
// if (user != null) {
// user.setEnabled(true);
// userRepository.save(user);
// }
// return user;
// }
// }
