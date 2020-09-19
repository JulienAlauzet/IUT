public class CommercialBuilder {
    private double numeroSecuSociale;
    private String nom;
    private String prenom;
    private int echelon;
    private double base;
    private double nbHeures;
    private double chiffreAffaires;
    private double tauxComission;

    public CommercialBuilder setNumeroSecuSociale(double numeroSecuSociale) {
        this.numeroSecuSociale = numeroSecuSociale;
        return this;
    }

    public CommercialBuilder setNom(String nom) {
        this.nom = nom;
        return this;
    }

    public CommercialBuilder setPrenom(String prenom) {
        this.prenom = prenom;
        return this;
    }

    public CommercialBuilder setEchelon(int echelon) {
        this.echelon = echelon;
        return this;
    }

    public CommercialBuilder setBase(double base) {
        this.base = base;
        return this;
    }

    public CommercialBuilder setNbHeures(double nbHeures) {
        this.nbHeures = nbHeures;
        return this;
    }

    public CommercialBuilder setChiffreAffaires(double chiffreAffaires) {
        this.chiffreAffaires = chiffreAffaires;
        return this;
    }

    public CommercialBuilder setTauxComission(double tauxComission) {
        this.tauxComission = tauxComission;
        return this;
    }

    /*public Commercial createCommercial() {
        return new Commercial(numeroSecuSociale, nom, prenom, echelon, base, nbHeures, chiffreAffaires, tauxComission);
    }*/
}