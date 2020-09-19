package fr.umontpellier.iut.exo1;

import java.time.LocalDate;

public class Etudiant {
    private String nom;
    private String prenom;
    private LocalDate dob;
    private String adresseMail;
    private String adressePostale;

    public Etudiant(String nom, String prenom, LocalDate dob, String adresseMail, String adressePostale) {
        this.nom = nom;
        this.prenom = prenom;
        this.dob = dob;
        this.adresseMail = adresseMail;
        this.adressePostale = adressePostale;
    }

    @Override
    public String toString() {
        return "Etudiant{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", dob=" + dob +
                ", adresseMail='" + adresseMail + '\'' +
                ", adressePostale='" + adressePostale + '\'' +
                '}';
    }

    public void setNom(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

}