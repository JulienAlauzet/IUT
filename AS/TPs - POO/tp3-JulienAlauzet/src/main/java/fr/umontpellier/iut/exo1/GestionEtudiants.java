package fr.umontpellier.iut.exo1;

import java.time.LocalDate;
import java.time.Month;

public class GestionEtudiants {
    public static void main(String[] args) {
        Etudiant lolo, toto, riri, fifi;
        lolo = new Etudiant("Alauzet", "Julien", LocalDate.of(1996, Month.SEPTEMBER, 10), "julien.alauzet@etu.umontpellier.fr", "45 rue Esculape" );
        toto = lolo;
        System.out.println(lolo);
       //Question 5  System.out.println(toto == lolo); // toto et lolo ne sont visiblement pas le même objet
        lolo.setNom("Durand","Martin");
        System.out.println(toto);
        Departement monDepInfo = new Departement("Informatique", "Avenue Occitanie");
        monDepInfo.inscrire(toto);
        monDepInfo.inscrire(lolo);
        riri = new Etudiant("Dupont", "Jean", LocalDate.of(1996, Month.OCTOBER, 15), "jean.dupont@gmail.com", "Avenue de Paris");
        fifi = new Etudiant("DeGaulle", "Pierre", LocalDate.of(1995, Month.OCTOBER, 13), "pierret@gmail.com", "Avenue de Londres");
        monDepInfo.inscrire(riri);
        monDepInfo.inscrire(fifi);
        System.out.println(monDepInfo);
        monDepInfo.desinscrire(toto);
        System.out.println(monDepInfo); //toto et lolo sont tous les deux désinscrits car c'est le même objet
    }
}
