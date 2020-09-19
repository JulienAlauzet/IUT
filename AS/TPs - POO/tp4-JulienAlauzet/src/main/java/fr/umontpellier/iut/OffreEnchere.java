package fr.umontpellier.iut;

import java.time.LocalDate;
import java.time.LocalTime;

public class OffreEnchere {

    private LocalDate date;
    private LocalTime heure;
    private double prixEnchere;
    private double prixMax;
    private Produit produit;

    public OffreEnchere(double prixEnchere, double prixMax, Produit produit) {
        this.prixEnchere = prixEnchere;
        this.prixMax = prixMax;
        this.produit = produit;
        this.date = LocalDate.now();
        this.heure = LocalTime.now();
    }

    @Override
    public String toString() {
        return "OffreEnchere{" +
                "date=" + date +
                ", heure=" + heure +
                ", prixEnchere=" + prixEnchere +
                ", prixMax=" + prixMax +
                '}';
    }

    public double getPrixMax() {
        return prixMax;
    }

    public double getPrixEnchere() {
        return prixEnchere;
    }

    public void setPrixEnchere(double prixEnchere) {
        this.prixEnchere = prixEnchere;
    }

    public boolean estValide () {
        return (this.prixEnchere - this.produit.getPrixCourant() >= Produit.getMontantPasEnchereMinimal() && this.produit.isDisponible());
    }
}
