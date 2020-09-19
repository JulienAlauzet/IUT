package fr.umontpellier.iut.exo3;

import fr.umontpellier.iut.exo2.Note;

import java.time.LocalDate;
import java.util.ArrayList;

public class EtudiantTelescopique {
    private String nom;
    private String prenom;
    private LocalDate dob;
    private String adresseMail;
    private String adressePostale;
    private ArrayList<Note> listeNotes;

    public EtudiantTelescopique(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public EtudiantTelescopique(String nom, String prenom, LocalDate dob) {
        this.nom = nom;
        this.prenom = prenom;
        this.dob = dob;
    }

    public EtudiantTelescopique(String nom, String prenom, String adresseMail) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresseMail = adresseMail;
    }

    @Override
    public String toString() {
        return "EtudiantTelescopique{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", dob=" + dob +
                ", adresseMail='" + adresseMail + '\'' +
                ", adressePostale='" + adressePostale + '\'' +
                ", listeNotes=" + listeNotes +
                '}';
    }
}

// Impossible de créer deux constructeurs différents qui ont la même signature