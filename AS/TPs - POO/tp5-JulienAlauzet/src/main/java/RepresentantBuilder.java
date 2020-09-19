public class RepresentantBuilder {
    private double numeroSecuSociale;
    private String nom;
    private String prenom;
    private int echelon;
    private double base;
    private double nbHeures;
    private double chiffreAffaires;
    private double tauxComission;

    public RepresentantBuilder setNumeroSecuSociale(double numeroSecuSociale) {
        this.numeroSecuSociale = numeroSecuSociale;
        return this;
    }

    public RepresentantBuilder setNom(String nom) {
        this.nom = nom;
        return this;
    }

    public RepresentantBuilder setPrenom(String prenom) {
        this.prenom = prenom;
        return this;
    }

    public RepresentantBuilder setEchelon(int echelon) {
        this.echelon = echelon;
        return this;
    }

    public RepresentantBuilder setBase(double base) {
        this.base = base;
        return this;
    }

    public RepresentantBuilder setNbHeures(double nbHeures) {
        this.nbHeures = nbHeures;
        return this;
    }

    public RepresentantBuilder setChiffreAffaires(double chiffreAffaires) {
        this.chiffreAffaires = chiffreAffaires;
        return this;
    }

    public RepresentantBuilder setTauxComission(double tauxComission) {
        this.tauxComission = tauxComission;
        return this;
    }

    public Representant createRepresentant() {
        return new Representant(numeroSecuSociale, nom, prenom, echelon, base, nbHeures, chiffreAffaires, tauxComission);
    }
}