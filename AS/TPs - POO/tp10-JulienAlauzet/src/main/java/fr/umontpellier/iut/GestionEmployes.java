package fr.umontpellier.iut;

import java.time.LocalDate;
import java.time.Month;

public class GestionEmployes {

    public static void main(String[] args) {
        Entreprise ent = new Entreprise();
        ent.setBonusTotal(50);
        Employe e1 = new EmployeBuilder()
                .setNom("Toto")
                .setPrenom("Lolo")
                .setnINSEE("1234")
                .createEmploye();
        Employe e2 = new EmployeBuilder()
                .setNom("Tata")
                .setPrenom("Lala")
                .setnINSEE("5678")
                .createEmploye();
        Employe e3 = new EmployeBuilder()
                .setNom("Tutu")
                .setPrenom("Lulu")
                .setnINSEE("9101112")
                .createEmploye();
        System.out.println("Début :\n" + ent.toString());
        ent.embaucher(e1, LocalDate.of(2018, Month.JANUARY, 28));
        System.out.println("\nEmbauche e1 :\n" + ent.toString());
        ent.embaucher(e2, LocalDate.of(2018, Month.SEPTEMBER, 10));
        System.out.println("\nEmbauche e2 :\n" + ent.toString());
        ent.embaucher(e3, LocalDate.of(2018, Month.APRIL, 8));
        System.out.println("\nEmbauche e3 :\n" + ent.toString());
        ent.licencier(e2);
        System.out.println("\nLicenciement e2 :\n" + ent.toString());
        ent.distribuerBonus();
        System.out.println("\nAprès distribution bonus:\n" + ent.toString());
    }

}
