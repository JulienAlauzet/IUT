package fr.umontpellier.iut;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class Employe {

    private String nINSEE;
    private String nom;
    private String prenom;
    private int echelon;
    private double base;
    private double nbHeures;
    private LocalDate dateEmbauche;
    private double bonus;
    private String adresse;

    public Employe(String nINSEE, String nom, String prenom, int echelon, double base, double nbHeures) {
        this.nINSEE = nINSEE;
        this.nom = nom;
        this.prenom = prenom;
        this.echelon = echelon;
        this.base = base;
        this.nbHeures = nbHeures;
    }

    public LocalDate getDateEmbauche() {
        return dateEmbauche;
    }

    public String getNINSEE() {
        return nINSEE;
    }

    public String getNom() {
        return nom;
    }

    public void setDateEmbauche(LocalDate dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }

    public double getSalaireBrut() {
        return base * nbHeures + 100;  // Exo1Question 4 : Une seule modif à faire // Exo2Question5 : Deux modifs à faire
    }

    public double getSalaireNet() {
        return getSalaireBrut()*0.8;
    }

    @Override
    public String toString() {
        return "Employe{" +
                "nINSEE=" + nINSEE +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", echelon=" + echelon +
                ", base=" + base +
                ", nbHeures=" + nbHeures +
                ", salaire brut=" + getSalaireBrut() +
                ", salaire net=" + getSalaireNet() +
                ", dateEmbauche=" + dateEmbauche +
                ", bonus =" + bonus +
                '}';
    }

    protected int getEchelon() {
        return echelon;
    }

    public double getBase() {
        return base;
    }

    public double getNbHeures() {
        return nbHeures;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employe employe = (Employe) o;
        return nINSEE.equals(employe.nINSEE);
    }

    @Override
    public int hashCode() {
        return nINSEE.hashCode();
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public int getMoisAnciennete() {
        try {
            return (int) ChronoUnit.MONTHS.between(dateEmbauche, LocalDate.now());
        } catch (NullPointerException e) {
            throw new NullPointerException("Employé non-embauché");
        }
    }

    public double getIndemniteTransport(){
        return base * GestionDistances.getDistance(adresse);
    }

}
