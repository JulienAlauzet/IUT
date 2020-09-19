package fr.umontpellier.iut;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.*;

class EntrepriseTest {

    @Test
    public void test_employes_are_serted_correctly_empty_lists() {
        Entreprise ent = new Entreprise();
        Collection<Employe> listeFactice = new ArrayList<>();
        Collection<Employe> listeResultat = ent.getEmployes();
        assertIterableEquals(listeResultat, listeFactice);
    }

    @Test
    public void test_employes_are_serted_correctly_1_employee() {
        Entreprise ent = new Entreprise();
        Employe e1 = new EmployeBuilder()
                .setPrenom("Jean")
                .setNom("Jean")
                .setnINSEE("1234")
                .createEmploye();
        ent.embaucher(e1, LocalDate.of(2019, 1,1));
        Collection<Employe> listeResultat = ent.getEmployes();
        Collection<Employe> listeFactice = new ArrayList<>();
        listeFactice.add(e1);
        assertIterableEquals(listeResultat, listeFactice);
    }

    @Test
    public void test_employes_are_serted_correctly_2_seperated_names() {
        Entreprise ent = new Entreprise();
        Employe e1 = new EmployeBuilder()
                .setPrenom("Jean")
                .setNom("Jean")
                .setnINSEE("1234")
                .createEmploye();
        Employe e2 = new EmployeBuilder()
                .setPrenom("Martin")
                .setNom("Martin")
                .setnINSEE("5678")
                .createEmploye();
        ent.embaucher(e1, LocalDate.of(2019, 1,1));
        ent.embaucher(e2, LocalDate.of(2019, 9, 10));
        Collection<Employe> listeResultat = ent.getEmployes();
        Collection<Employe> listeFactice = new ArrayList<>();
        listeFactice.add(e1);
        listeFactice.add(e2);
        assertIterableEquals(listeResultat, listeFactice);
    }

    @Test
    public void test_employes_are_serted_correctly_3_seperated_names() {
        Entreprise ent = new Entreprise();
        Employe e1 = new EmployeBuilder()
                .setPrenom("Jean")
                .setNom("Jean")
                .setnINSEE("1234")
                .createEmploye();
        Employe e2 = new EmployeBuilder()
                .setPrenom("Martin")
                .setNom("Martin")
                .setnINSEE("5678")
                .createEmploye();
        Employe e3 = new EmployeBuilder()
                .setPrenom("Alan")
                .setNom("Alan")
                .setnINSEE("1996")
                .createEmploye();
        ent.embaucher(e1, LocalDate.of(2019, 1,1));
        ent.embaucher(e2, LocalDate.of(2019, 9, 10));
        ent.embaucher(e3, LocalDate.of(2019, 2, 3));
        Collection<Employe> listeResultat = ent.getEmployes();
        Collection<Employe> listeFactice = new ArrayList<>();
        listeFactice.add(e3);
        listeFactice.add(e1);
        listeFactice.add(e2);
        assertIterableEquals(listeResultat, listeFactice);
    }

    @Test
    public void test_employes_are_serted_correctly_3_same_names() {
        Entreprise ent = new Entreprise();
        Employe e1 = new EmployeBuilder()
                .setPrenom("Jean")
                .setNom("Jean")
                .setnINSEE("1234")
                .createEmploye();
        Employe e2 = new EmployeBuilder()
                .setPrenom("Jean")
                .setNom("Jean")
                .setnINSEE("5678")
                .createEmploye();
        Employe e3 = new EmployeBuilder()
                .setPrenom("Alan")
                .setNom("Alan")
                .setnINSEE("1996")
                .createEmploye();
        ent.embaucher(e1, LocalDate.of(2019, 1,1));
        ent.embaucher(e2, LocalDate.of(2019, 9, 10));
        ent.embaucher(e3, LocalDate.of(2019, 2, 3));
        Collection<Employe> listeResultat = ent.getEmployes();
        Collection<Employe> listeFactice = new ArrayList<>();
        listeFactice.add(e3);
        listeFactice.add(e2);
        listeFactice.add(e1);
        assertIterableEquals(listeResultat, listeFactice);
    }

}