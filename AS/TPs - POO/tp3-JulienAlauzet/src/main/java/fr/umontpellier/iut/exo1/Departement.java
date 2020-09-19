package fr.umontpellier.iut.exo1;

import java.util.ArrayList;

public class Departement {
    private String specialite;
    private String adresse;
    private ArrayList<Etudiant> etudiantsInscrits;

    public Departement(String specialite, String adresse) {
        this.specialite = specialite;
        this.adresse = adresse;
        this.etudiantsInscrits = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Departement{" +
                "specialite='" + specialite + '\'' +
                ", adresse='" + adresse + '\'' +
                ", etudiantsInscrits=" + etudiantsInscrits +
                '}';
    }

    public void inscrire (Etudiant etudiant) {
        this.etudiantsInscrits.add(etudiant);
    }

    public void desinscrire (Etudiant etudiant) {
        this.etudiantsInscrits.removeIf(n -> (n == etudiant));
        }
}

