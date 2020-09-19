package fr.umontpellier.iut.exo3;

import fr.umontpellier.iut.exo2.Matiere;
import fr.umontpellier.iut.exo2.Note;

import java.time.LocalDate;
import java.util.ArrayList;

class Etudiant {
    private String nom;
    private String prenom;
    private LocalDate dob;
    private String adresseMail;
    private String adressePostale;
    private ArrayList<Note> listeNotes;

    public static class EtudiantBuilder {
        private String nom;
        private String prenom;
        private LocalDate dob;
        private String adresseMail;
        private String adressePostale;
        private ArrayList<Note> listeNotes;

        public EtudiantBuilder setNom(String nom) {
            this.nom = nom;
            return this;
        }

        public EtudiantBuilder setPrenom(String prenom) {
            this.prenom = prenom;
            return this;
        }

        public EtudiantBuilder setdob(LocalDate dob) {
            this.dob = dob;
            return this;
        }

        public EtudiantBuilder setAdresseMail(String adresseMail) {
            this.adresseMail = adresseMail;
            return this;
        }

        public EtudiantBuilder setAdressePostale(String adressePostale) {
            this.adressePostale = adressePostale;
            return this;
        }

        public Etudiant createEtudiant() {
            return new Etudiant(nom, prenom, dob, adresseMail, adressePostale);
        }
    }

    private Etudiant(String nom, String prenom, LocalDate dob, String adresseMail, String adressePostale) {
        this.nom = nom;
        this.prenom = prenom;
        this.dob = dob;
        this.adresseMail = adresseMail;
        this.adressePostale = adressePostale;
        this.listeNotes = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Etudiant{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", dob=" + dob +
                ", adresseMail='" + adresseMail + '\'' +
                ", adressePostale='" + adressePostale + '\'' +
                ", listeNotes=" + listeNotes +
                '}';
    }

    public void setNom(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public void noter (Matiere matiere, double valeur) {
        Note nvNote = new Note(matiere, valeur);
        this.listeNotes.add(nvNote);
    }

    public double moyenne() {
        double resultat = 0;
        double poids = 0;
        if (!this.listeNotes.isEmpty()) {
            for (Note note : this.listeNotes) {
                resultat += note.getValeur() * note.getMatiere().getCoefficient();
                poids += note.getMatiere().getCoefficient();
            }
            resultat /= poids;
        }
        return resultat;
    }
}