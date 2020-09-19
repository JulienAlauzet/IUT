public class FabricantBuilder {
    private double numeroSecuSociale;
    private String nom;
    private String prenom;
    private int echelon;
    private double base;
    private double nbHeures;
    private int nbUnitesProduites;
    private double tauxComissionUnite;

    public FabricantBuilder setNumeroSecuSociale(double numeroSecuSociale) {
        this.numeroSecuSociale = numeroSecuSociale;
        return this;
    }

    public FabricantBuilder setNom(String nom) {
        this.nom = nom;
        return this;
    }

    public FabricantBuilder setPrenom(String prenom) {
        this.prenom = prenom;
        return this;
    }

    public FabricantBuilder setEchelon(int echelon) {
        this.echelon = echelon;
        return this;
    }

    public FabricantBuilder setBase(double base) {
        this.base = base;
        return this;
    }

    public FabricantBuilder setNbHeures(double nbHeures) {
        this.nbHeures = nbHeures;
        return this;
    }

    public FabricantBuilder setNbUnitesProduites(int nbUnitesProduites) {
        this.nbUnitesProduites = nbUnitesProduites;
        return this;
    }

    public FabricantBuilder setTauxComissionUnite(double tauxComissionUnite) {
        this.tauxComissionUnite = tauxComissionUnite;
        return this;
    }

    public Fabricant createFabricant() {
        return new Fabricant(numeroSecuSociale, nom, prenom, echelon, base, nbHeures, nbUnitesProduites, tauxComissionUnite);
    }
}