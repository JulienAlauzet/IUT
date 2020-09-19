public class Representant extends Commercial {
    public Representant(double numeroSecuSociale, String nom, String prenom, int echelon, double base, double nbHeures, double chiffreAffaires, double tauxComission) {
        super(numeroSecuSociale, nom, prenom, echelon, base, nbHeures, chiffreAffaires, tauxComission);
    }

    public double getSalaireBrut() {

        Technicien technicien = new TechnicienBuilder()
                .setEchelon(getEchelon())
                .setBase (getBase())
                .setNbHeures(getNbHeures())
                .createTechnicien();
        return technicien.getSalaireBrut();
    }

}
