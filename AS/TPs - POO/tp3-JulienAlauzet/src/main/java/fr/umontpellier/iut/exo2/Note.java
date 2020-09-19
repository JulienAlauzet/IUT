package fr.umontpellier.iut.exo2;

public class Note {
    private Matiere matiere;
    private double valeur;

    public Note(Matiere matiere, double valeur) {
        this.matiere = matiere;
        this.valeur = valeur;
    }

    @Override
    public String toString() {
        return "Note{" +
                "matiere=" + matiere +
                ", valeur=" + valeur +
                '}';
    }

    public Matiere getMatiere() {
        return matiere;
    }

    public double getValeur() {
        return valeur;
    }
}
