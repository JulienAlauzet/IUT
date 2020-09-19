package fr.umontpellier.iut;

import java.util.ArrayList;

public class Compte {

    private String pseudo;
    private String email;
    private String adresse;
    private double solde;
    private ArrayList<OffreEnchere> listeEncheres;

    public Compte(String pseudo, String email, String adresse) {
        this.pseudo = pseudo;
        this.email = email;
        this.adresse = adresse;
        this.solde = 0;
        this.listeEncheres = new ArrayList<>();
    }

    public void créditerCompte(double sommeAjoutee) {
        this.solde += sommeAjoutee;
    }

    @Override
    public String toString() {
        return "Compte{" +
                "pseudo='" + pseudo + '\'' +
                ", email='" + email + '\'' +
                ", adresse='" + adresse + '\'' +
                ", solde=" + solde +
                '}';
    }

    public void creerOffre(Produit produit, double prixCourant, double prixMax) {
        if (prixMax >= prixCourant && prixMax <= solde) {
            OffreEnchere offreCree = new OffreEnchere(prixCourant, prixMax, produit);
            produit.ajouterOffre(offreCree);
            this.listeEncheres.add(offreCree);
        }
    }
}
