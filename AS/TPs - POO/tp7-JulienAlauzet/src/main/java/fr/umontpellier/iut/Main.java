package fr.umontpellier.iut;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Hanoi h1 = new Hanoi(8);
        System.out.println(h1);
        Contexte c1 = new Contexte(h1);
        c1.resoudre();
        System.out.println(c1);
    }
}
