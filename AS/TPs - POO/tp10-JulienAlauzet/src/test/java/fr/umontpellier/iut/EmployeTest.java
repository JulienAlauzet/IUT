package fr.umontpellier.iut;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

class EmployeTest {

    @Test
    public void test_employe_non_embauche() {
        Employe e = new EmployeBuilder()
                .setNom("Jean")
                .setPrenom("Jean")
                .createEmploye();
        assertThrows(NullPointerException.class, () -> e.getMoisAnciennete(),"Employé non-embauché");
    }

    @Test
    public void test_employe_embauche_dans_le_mois() {
        Employe e = new EmployeBuilder()
                .createEmploye();
        e.setDateEmbauche(LocalDate.of(2019, Month.APRIL, 1));
        assertEquals(e.getMoisAnciennete(), 0);
    }

    @Test
    public void test_employe_embauche_il_y_a_un_an() {
        Employe e = new EmployeBuilder()
                .createEmploye();
        e.setDateEmbauche(LocalDate.of(2018, Month.APRIL, 9));
        assertEquals(e.getMoisAnciennete(), 12);
    }

    @Test
    public void test_employe_embauche_il_y_a_364_jours() {
        Employe e = new EmployeBuilder()
                .createEmploye();
        e.setDateEmbauche(LocalDate.of(2018, Month.APRIL, 16));
        assertEquals(e.getMoisAnciennete(), 11);
    }

    @Test
    public void test_employe_embauche_dans_le_futur_proche() {
        Employe e = new EmployeBuilder()
                .createEmploye();
        e.setDateEmbauche(LocalDate.of(2019, Month.APRIL, 10));
        assertEquals(e.getMoisAnciennete(), 0);
    }

    @Test
    public void test_employe_embauche_dans_le_futur() {
        Employe e = new EmployeBuilder()
                .createEmploye();
        e.setDateEmbauche(LocalDate.of(2019, Month.MAY, 15));
        assertEquals(e.getMoisAnciennete(), -1);
    }

    @Test
    public void test_indemnites_Montpellier_egal_0() {
        Employe e = new EmployeBuilder()
                .setBase(2)
                .createEmploye();
        e.setAdresse("Montpellier");
        assertEquals(e.getIndemniteTransport(), 0);
    }

    @Test
    public void test_indemnites_Sète_base_1_egal_36() {
        Employe e = new EmployeBuilder()
                .setBase(1)
                .createEmploye();
        e.setAdresse("Sète");
        assertEquals(e.getIndemniteTransport(), 36);
    }

    @Test
    public void test_indemnites_Sète_base_2_egal_72() {
        Employe e = new EmployeBuilder()
                .setBase(2)
                .createEmploye();
        e.setAdresse("Sète");
        assertEquals(e.getIndemniteTransport(), 72);
    }


}