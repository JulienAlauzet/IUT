public class Employe {

    private double numeroSecuSociale;
    private String nom;
    private String prenom;
    private int echelon;
    private double base;
    private double nbHeures;

    public Employe(double numeroSecuSociale, String nom, String prenom, int echelon, double base, double nbHeures) {
        this.numeroSecuSociale = numeroSecuSociale;
        this.nom = nom;
        this.prenom = prenom;
        this.echelon = echelon;
        this.base = base;
        this.nbHeures = nbHeures;
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
                "numeroSecuSociale=" + numeroSecuSociale +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", echelon=" + echelon +
                ", base=" + base +
                ", nbHeures=" + nbHeures +
                ", salaire brut=" + getSalaireBrut() +
                ", salaire net=" + getSalaireNet() +
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
}
