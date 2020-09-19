public class Fabricant extends Employe {

    private int nbUnitesProduites;
    private double tauxComissionUnite;

    public Fabricant(double numeroSecuSociale, String nom, String prenom, int echelon, double base, double nbHeures, int nbUnitesProduites, double tauxComissionUnite) {
        super(numeroSecuSociale, nom, prenom, echelon, base, nbHeures);
        this.nbUnitesProduites = nbUnitesProduites;
        this.tauxComissionUnite = tauxComissionUnite;
    }

    public void fabriquerProduit() {
        System.out.println("Je fabrique un produit");
    }

    public double getSalaireBrut() {
        return super.getSalaireBrut() + nbUnitesProduites * tauxComissionUnite;
    }

}
