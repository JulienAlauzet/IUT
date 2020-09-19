package fr.umontpellier.iut;

import java.util.ArrayList;
import java.util.Objects;

public class Hanoi implements JeuPuzzle {
    private ArrayList<Integer> poto1;
    private ArrayList<Integer> poto2;
    private ArrayList<Integer> poto3;
    private int taille;

    public Hanoi(int taille) {
        this.taille = taille;
        poto1 = new ArrayList<>();
        poto2 = new ArrayList<>();
        poto3 = new ArrayList<>();
        for (int i = taille; i > 0; i--) {
            poto1.add(i);
        }
    }

    public Hanoi(ArrayList<Integer> poto1, ArrayList<Integer> poto2, ArrayList<Integer> poto3, int taille) {
        this.poto1 = poto1;
        this.poto2 = poto2;
        this.poto3 = poto3;
        this.taille = taille;
    }

    @Override
    public String toString() {
        String message = "\n";
        for (int i = taille; i > 0; i--) {
            if (poto1.size()-1 >= i-1)
                message += poto1.get(i-1);
            else
                message += '|';
            message += ' ';
            if (poto2.size()-1 >= i-1)
                message += poto2.get(i-1);
            else
                message += '|';
            message += ' ';
            if (poto3.size()-1 >= i-1)
                message += poto3.get(i-1);
            else
                message += '|';
            message += "\n";
        }
        return message;
    }

    @Override
    public boolean estGagnant() {
        return poto1.isEmpty() && poto2.isEmpty();
    }

    public boolean estLegal(ArrayList<Integer> potoA, ArrayList<Integer> potoB) {
        return !potoA.isEmpty() && (potoB.isEmpty() || potoA.get(potoA.size()-1) < potoB.get(potoB.size()-1));
    }

    public void permutation(ArrayList<Integer> potoA, ArrayList<Integer> potoB) {
        if (estLegal(potoA, potoB)) {
            potoB.add(potoA.get(potoA.size() - 1));
            potoA.remove(potoA.size() - 1);
        }
    }

    @Override
    public ArrayList<JeuPuzzle> genererFils() {
        ArrayList<JeuPuzzle> maListe = new ArrayList<>();
        if (estLegal(poto1,poto2)) {
            Hanoi hanoi12 = copieHanoi();
            hanoi12.permutation(hanoi12.poto1, hanoi12.poto2);
            maListe.add(hanoi12);
        }
        if (estLegal(poto2,poto1)) {
            Hanoi hanoi21 = copieHanoi();
            hanoi21.permutation(hanoi21.poto2, hanoi21.poto1);
            maListe.add(hanoi21);
        }
        if (estLegal(poto1,poto3)) {
            Hanoi hanoi13 = copieHanoi();
            hanoi13.permutation(hanoi13.poto1, hanoi13.poto3);
            maListe.add(hanoi13);
        }
        if (estLegal(poto3,poto1)) {
            Hanoi hanoi31 = copieHanoi();
            hanoi31.permutation(hanoi31.poto3, hanoi31.poto1);
            maListe.add(hanoi31);
        }
        if (estLegal(poto2,poto3)) {
            Hanoi hanoi23 = copieHanoi();
            hanoi23.permutation(hanoi23.poto2, hanoi23.poto3);
            maListe.add(hanoi23);
        }
        if (estLegal(poto3,poto2)) {
            Hanoi hanoi32 = copieHanoi();
            hanoi32.permutation(hanoi32.poto3, hanoi32.poto2);
            maListe.add(hanoi32);
        }
        return maListe;
    }

    public Hanoi copieHanoi () {
        ArrayList<Integer> poto1Bis = (ArrayList<Integer>) poto1.clone();
        ArrayList<Integer> poto2Bis = (ArrayList<Integer>) poto2.clone();
        ArrayList<Integer> poto3Bis = (ArrayList<Integer>) poto3.clone();
        Hanoi nvHanoi = new Hanoi(poto1Bis, poto2Bis, poto3Bis, taille);
        return nvHanoi;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hanoi hanoi = (Hanoi) o;
        return poto1.equals(hanoi.poto1) &&
                poto2.equals(hanoi.poto2) &&
                poto3.equals(hanoi.poto3);
    }

    @Override
    public int hashCode() {
        return Objects.hash(poto1, poto2, poto3);
    }
}
