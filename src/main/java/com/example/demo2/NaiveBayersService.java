package com.example.demo2;

import java.io.IOException;
import java.util.Properties;
import javax.mail.*;
import javax.activation.*;


public class NaiveBayersService {

    public static void getmail() throws MessagingException, IOException {
        // Création de l'objet Properties
        Properties props = new Properties();

// Configuration des propriétés de la connexion
        props.put("mail.store.protocol", "imaps");
        props.put("mail.imaps.host", "outlook.office365.com");
        props.put("mail.imaps.port", "993");
        props.put("mail.imaps.ssl.enable", "true");

// Création de la session
        Session session = Session.getInstance(props);

// Création de la store
        Store store = session.getStore();

        // fonction sha-256 pour le mot de passe qui retourne mdp cripté
        store.connect( "testSpam3ILProject@outlook.com", "3ILTeSTserver;");
        // envoie un mail à l'adresse mail de l'utilisateur avec le store

        // Création du folder
        Folder folder = store.getFolder("INBOX");
        folder.open(Folder.READ_ONLY);

        // Création du message
        Message message = folder.getMessage(1);
        System.out.println("Sujet du message : " + message.getSubject());
        System.out.println("Contenu du message : " + message.getContent());


// Connexion à la store
        Folder inbox = store.getFolder("INBOX");


// Fermeture de la boîte de réception
        inbox.close(false);


    }


    public static void main(String[] args) throws MessagingException, IOException {
        getmail();
    }
}
