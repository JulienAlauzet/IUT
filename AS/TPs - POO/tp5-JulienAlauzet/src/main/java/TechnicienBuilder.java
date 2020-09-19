public class TechnicienBuilder {
    private double numeroSecuSociale;
    private String nom;
    private String prenom;
    private int echelon;
    private double base;
    private double nbHeures;

    public TechnicienBuilder setNumeroSecuSociale(double numeroSecuSociale) {
        this.numeroSecuSociale = numeroSecuSociale;
        return this;
    }

    public TechnicienBuilder setNom(String nom) {
        this.nom = nom;
        return this;
    }

    public TechnicienBuilder setPrenom(String prenom) {
        this.prenom = prenom;
        return this;
    }

    public TechnicienBuilder setEchelon(int echelon) {
        this.echelon = echelon;
        return this;
    }

    public TechnicienBuilder setBase(double base) {
        this.base = base;
        return this;
    }

    public TechnicienBuilder setNbHeures(double nbHeures) {
        this.nbHeures = nbHeures;
        return this;
    }

    public Technicien createTechnicien() {
        return new Technicien(numeroSecuSociale, nom, prenom, echelon, base, nbHeures);
    }
}