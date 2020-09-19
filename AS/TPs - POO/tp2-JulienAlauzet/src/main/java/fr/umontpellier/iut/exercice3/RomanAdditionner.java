package fr.umontpellier.iut.exercice3;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class RomanAdditionner {

    String compute(String operation) {
        Queue<String> operandes = new PriorityQueue<>();
        Queue<Integer> operateurs = new PriorityQueue<>();
        int lastIndex = -1;
        int somme = 0;
        RomanToNumeral romanToNumeral = new RomanToNumeral();
        NumeralToRoman numeralToRoman = new NumeralToRoman();
        operation = operation.replaceAll(" ", "");
        if (operation.charAt(0) == '-') {
            operation = operation.substring(1);
            operateurs.add(-1);
        }
        else
            operateurs.add(1);
        for (int i = 0; i < operation.length(); i++) {
            if (operation.charAt(i) == '+' || operation.charAt(i) == '-')  {
                if (operation.charAt(i) == '+')
                    operateurs.add(1);
                else
                    operateurs.add(-1);
                operandes.add(operation.substring(lastIndex + 1, i));
                lastIndex = i;
            }
            if (i == operation.length() - 1)
                operandes.add(operation.substring(lastIndex + 1));
        }
        while (!operandes.isEmpty() && !operateurs.isEmpty()) {
            somme += operateurs.poll() * romanToNumeral.getNumeral(operandes.poll());
        }
        return numeralToRoman.getRoman(somme);
    }
}
