package fr.umontpellier.iut.exo3;

import java.time.LocalDate;
import java.time.Month;

public class GestionEtudiants {

    public static void main(String[] strings) {
        EtudiantTelescopique etud1 = new EtudiantTelescopique("Dupont", "Pierre");
        EtudiantTelescopique etud2 = new EtudiantTelescopique("Dupont", "Pierre", LocalDate.of(1996, Month.APRIL, 10));
        EtudiantTelescopique etud3 = new EtudiantTelescopique("Dupont", "Pierre", "dupont@gmail.com");
        System.out.println(etud1);
        System.out.println(etud2);
        System.out.println(etud3);
        EtudiantJavaBeans etud4 = new EtudiantJavaBeans();
        System.out.println(etud4);
        etud4.setNom("Dupont");
        System.out.println(etud4);
    }
}
