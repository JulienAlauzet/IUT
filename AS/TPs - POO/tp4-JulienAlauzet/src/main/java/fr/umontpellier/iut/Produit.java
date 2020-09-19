package fr.umontpellier.iut;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Produit {

    private int numero;
    private String description;
    private double prixCourant;
    private LocalDate dateDebut;
    private LocalTime heureDebut;
    private static final double montantPasEnchereMinimal = 10;  // A modifier par l'utilisateur
    private double coutParticipation;
    private boolean disponible;
    private ArrayList <OffreEnchere> offresSurProduit;

    public Produit(int numero, String description, double prixCourant, double coutParticipation) {
        this.numero = numero;
        this.description = description;
        this.prixCourant = prixCourant;
        this.coutParticipation = coutParticipation;
        this.disponible = false;
        this.offresSurProduit = new ArrayList<>();
    }

    public static double getMontantPasEnchereMinimal() {
        return montantPasEnchereMinimal;
    }

    public double getPrixCourant() {
        return prixCourant;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void demarrerEnchere() {
        this.dateDebut = LocalDate.now();
        this.heureDebut = LocalTime.now();
        this.disponible = true;
    }

    public void arreterEnchere() {
        this.disponible = false;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "numero=" + numero +
                ", description='" + description + '\'' +
                ", prixCourant=" + prixCourant +
                ", dateDebut=" + dateDebut +
                ", heureDebut=" + heureDebut +
                ", coutParticipation=" + coutParticipation +
                ", disponible=" + disponible +
                ", ensemble des offres=" + offresSurProduit +
                ", offre gagante actuelle=" + calculerGagnant() +
                '}';
    }

    public void ajouterOffre(OffreEnchere offre) {
        if (offre.estValide()) {
            offresSurProduit.add(offre);
            this.prixCourant = offre.getPrixEnchere();
        }
    }

    public OffreEnchere calculerGagnant() {
        if (!offresSurProduit.isEmpty()) {
            OffreEnchere gagnant = null;
            boolean check;
            int i = 0;
            while (gagnant == null && i < offresSurProduit.size()) {
                check = true;
                for (int j = 0; j < offresSurProduit.size(); j++) {
                    if (i != j && offresSurProduit.get(j).getPrixMax() >= offresSurProduit.get(i).getPrixEnchere())
                        check = false;
                }
                if (check == true)
                    gagnant = offresSurProduit.get(i);
                i++;
            }
            return gagnant;
        }
        else
            return null;
    }
}
