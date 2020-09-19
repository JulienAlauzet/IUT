package fr.umontpellier.iut.exo3;

import fr.umontpellier.iut.exo2.Note;

import java.time.LocalDate;
import java.util.ArrayList;

public class EtudiantJavaBeans {
    private String nom;
    private String prenom;
    private LocalDate dob;
    private String adresseMail;
    private String adressePostale;
    private ArrayList<Note> listeNotes;

    public EtudiantJavaBeans() {
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public void setAdresseMail(String adresseMail) {
        this.adresseMail = adresseMail;
    }

    public void setAdressePostale(String adressePostale) {
        this.adressePostale = adressePostale;
    }

    public void setListeNotes(ArrayList<Note> listeNotes) {
        this.listeNotes = listeNotes;
    }

    @Override
    public String toString() {
        return "EtudiantJavaBeans{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", dob=" + dob +
                ", adresseMail='" + adresseMail + '\'' +
                ", adressePostale='" + adressePostale + '\'' +
                ", listeNotes=" + listeNotes +
                '}';
    }
}

//Avantages : Il est possible de créer un objet sans lui donner de valeurs, et il est possible de choisir en précision ce que l'on souhaite faire
// Inconvénients : A COMPLETER