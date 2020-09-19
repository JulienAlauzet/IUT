public abstract class Commercial extends Employe {

    private double chiffreAffaires;
    private double tauxComission;

    public Commercial(double numeroSecuSociale, String nom, String prenom, int echelon, double base, double nbHeures, double chiffreAffaires, double tauxComission) {
        super(numeroSecuSociale, nom, prenom, echelon, base, nbHeures);
        this.chiffreAffaires = chiffreAffaires;
        this.tauxComission = tauxComission;
    }

    public void negocierTransaction() {
        System.out.println("Je négocie une transaction");
    }

    public double getSalaireBrut() {
        return getBase() + 100 + tauxComission * chiffreAffaires;
    }

}
