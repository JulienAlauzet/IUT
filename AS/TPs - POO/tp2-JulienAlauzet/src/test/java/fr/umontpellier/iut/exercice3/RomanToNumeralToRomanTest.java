package fr.umontpellier.iut.exercice3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class RomanToNumeralToRomanTest {

    private NumeralToRoman numeralToRoman = new NumeralToRoman();
    private RomanToNumeral romanToNumeral = new RomanToNumeral();
    @Test
    void MLXVI_should_give_MLXVI() {
        assertEquals(numeralToRoman.getRoman(romanToNumeral.getNumeral("MLXVI")), "MLXVI");
    }
}
