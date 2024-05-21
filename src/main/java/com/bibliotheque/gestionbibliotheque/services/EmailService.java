// package com.bibliotheque.gestionbibliotheque.services;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.mail.SimpleMailMessage;
// import org.springframework.mail.javamail.JavaMailSender;
// import org.springframework.stereotype.Service;
// import com.bibliotheque.gestionbibliotheque.entities.*;
// import com.bibliotheque.gestionbibliotheque.Config.AppConfig;

// @Service
// public class EmailService {

// @Autowired
// private JavaMailSender mailSender;

// @Autowired
// private AppConfig appConfig;

// public void sendConfirmationEmail(user user) {
// SimpleMailMessage message = new SimpleMailMessage();
// message.setTo(user.getEmail());
// message.setSubject("Confirmation de l'inscription");
// message.setText("Pour confirmer votre inscription, cliquez sur le lien
// suivant : " + appConfig.getAppUrl()
// + "/confirm?token=" + user.getConfirmationToken());
// mailSender.send(message);
// }
// }
