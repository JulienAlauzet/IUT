package fr.umontpellier.iut.exo2;

public class Matiere {
    private String nom;
    private double coefficient;
    private Professeur responsable;

    @Override
    public String toString() {
        return "Matiere{" +
                "nom='" + nom + '\'' +
                ", coefficient=" + coefficient +
                ", responsable=" + responsable +
                '}';
    }

    public Matiere(String nom, double coefficient, Professeur responsable) {
        this.nom = nom;
        this.coefficient = coefficient;
        this.responsable = responsable;
    }

    public double getCoefficient() {
        return coefficient;
    }
}
