package fr.umontpellier.iut.exercice3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RomanAdditionnerTest {
    private RomanAdditionner romanAdditionner = new RomanAdditionner();

    @Test
    void compute_should_be_correct() {
        assertEquals(romanAdditionner.compute("MMMXL + XII - CIX"), "MMCMXLIII");
    }
}