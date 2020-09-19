public class Technicien extends Employe {

    public Technicien(double numeroSecuSociale, String nom, String prenom, int echelon, double base, double nbHeures) {
        super(numeroSecuSociale, nom, prenom, echelon, base, nbHeures);
    }

    public void effectuerTacheTechnique() {
        System.out.println("J'effectue une tache technique");
    }

    public double getSalaireBrut() {
        return super.getSalaireBrut() + 100 * getEchelon();
    }

}
