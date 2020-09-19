package fr.umontpellier.iut.exercice2;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactors {
    public List<Integer> computeFactors(int number) {
        List<Integer> maListe = new ArrayList<>();
        if (number != 1) {
            int i = 2;
            while (i <= number / 2) {
                while (number % i == 0) {
                    maListe.add(i);
                    number /= i;
                }

                i++;
            }
            if (number != 1)
                maListe.add(number);
        }
        return maListe;
    }

}
