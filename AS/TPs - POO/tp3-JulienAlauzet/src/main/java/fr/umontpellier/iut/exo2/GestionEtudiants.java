package fr.umontpellier.iut.exo2;

import java.time.LocalDate;
import java.time.Month;

public class GestionEtudiants {
    public static void main(String[] args) {
        Etudiant fifi = new Etudiant("Martin", "Pierre", LocalDate.of(2000, Month.JANUARY, 1), "fifi@gmail.com", "Avenue de Berlin");
        Professeur prof = new Professeur("Valicov", "Petru");
        Matiere mat1 = new Matiere("Prog Objet", 3, prof);
        Matiere mat2 = new Matiere("Tp3", 2, prof);
        fifi.noter(mat1, 15);
        fifi.noter(mat2, 12);
        System.out.println(fifi);
        System.out.println("Moyenne : " + fifi.moyenne());
    }
}
