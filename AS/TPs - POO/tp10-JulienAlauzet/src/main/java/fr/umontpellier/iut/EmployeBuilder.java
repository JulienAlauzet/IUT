package fr.umontpellier.iut;

import java.time.LocalDate;

public class EmployeBuilder {
    private String nINSEE;
    private String nom;
    private String prenom;
    private int echelon;
    private double base;
    private double nbHeures;
    private LocalDate dateEmbauche;

    public EmployeBuilder setnINSEE(String nINSEE) {
        this.nINSEE = nINSEE;
        return this;
    }

    public EmployeBuilder setNom(String nom) {
        this.nom = nom;
        return this;
    }

    public EmployeBuilder setPrenom(String prenom) {
        this.prenom = prenom;
        return this;
    }

    public EmployeBuilder setEchelon(int echelon) {
        this.echelon = echelon;
        return this;
    }

    public EmployeBuilder setBase(double base) {
        this.base = base;
        return this;
    }

    public EmployeBuilder setNbHeures(double nbHeures) {
        this.nbHeures = nbHeures;
        return this;
    }

    public Employe createEmploye() {
        return new Employe(nINSEE, nom, prenom, echelon, base, nbHeures);
    }
}