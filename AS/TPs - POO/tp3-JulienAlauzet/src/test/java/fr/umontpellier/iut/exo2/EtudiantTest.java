package fr.umontpellier.iut.exo2;

import fr.umontpellier.iut.exo2.Etudiant;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

class EtudiantTest {

    @Test
    public void test_no_note_should_print_zero() {
        Etudiant julien = new Etudiant("Dupont", "Pierre", LocalDate.of (1996, Month.SEPTEMBER, 10), "alauzet.julien@gmail.com", "45 rue Esculape");
        double result = julien.moyenne();
        assertEquals(result,0);
    }

    @Test
    public void test_20_plus_0_should_print_ten() {
        Etudiant julien = new Etudiant("Dupont", "Pierre", LocalDate.of (1996, Month.SEPTEMBER, 10), "alauzet.julien@gmail.com", "45 rue Esculape");
        Professeur prof1 = new Professeur("Valicov", "Petru");
        Professeur prof2 = new Professeur("Croitoru", "Madalina");
        Matiere mat1 = new Matiere("Prog Objet", 1, prof1);
        Matiere mat2 = new Matiere("Présence", 1, prof2);
        julien.noter(mat1, 20);
        julien.noter(mat2, 0);
        double result = julien.moyenne();
        assertEquals(result,10);
    }

    @Test
    public void test_15_plus_15_plus_14_should_print_fourteen_point_seven() {
        Etudiant julien = new Etudiant("Dupont", "Pierre", LocalDate.of (1996, Month.SEPTEMBER, 10), "alauzet.julien@gmail.com", "45 rue Esculape");
        Professeur prof1 = new Professeur("Valicov", "Petru");
        Professeur prof2 = new Professeur("Croitoru", "Madalina");
        Matiere mat1 = new Matiere("Prog Objet", 1, prof1);
        Matiere mat2 = new Matiere("Présence", 1, prof2);
        Matiere mat3 = new Matiere("Autre", 1 , prof1);
        julien.noter(mat1, 15);
        julien.noter(mat2, 15);
        julien.noter(mat3, 14);
        double result = julien.moyenne();
        assertEquals(result,(double)44/3);
    }

    @Test
    public void test_20_coeff_2_plus_0_x_2_coeff1_should_print_ten() {
        Etudiant julien = new Etudiant("Dupont", "Pierre", LocalDate.of (1996, Month.SEPTEMBER, 10), "alauzet.julien@gmail.com", "45 rue Esculape");
        Professeur prof1 = new Professeur("Valicov", "Petru");
        Professeur prof2 = new Professeur("Croitoru", "Madalina");
        Matiere mat1 = new Matiere("Prog Objet", 2, prof1);
        Matiere mat2 = new Matiere("Présence", 1, prof2);
        Matiere mat3 = new Matiere("Autre", 1 , prof1);
        julien.noter(mat1, 20);
        julien.noter(mat2, 0);
        julien.noter(mat3, 0);
        double result = julien.moyenne();
        assertEquals(result,10);
    }
}