package fr.umontpellier.iut;

import java.util.ArrayList;
import java.util.Arrays;

public class Taquin implements JeuPuzzle {

    private int[][] plateau;

    public Taquin() {
        plateau = new int[3][3];
        plateau[0][0] = 1;
        plateau[0][1] = 3;
        plateau[0][2] = 7;
        plateau[1][0] = 8;
        plateau[1][1] = 0;
        plateau[1][2] = 5;
        plateau[2][0] = 6;
        plateau[2][1] = 2;
        plateau[2][2] = 4;
    }

    public Taquin(int[][] plateau) {
        this.plateau = plateau;
    }

    @Override
    public String toString(){
        String res = "Plateau:\n+- - - - -+\n";
        for(int i = 0; i < plateau.length ; i++) {
            res += ("|" + Arrays.toString(plateau[i]) + "|\n");
        }
        res += "+- - - - -+";
        return res;
    }

    public boolean estGagnant() {
        return (plateau[0][0] == 1 && plateau[0][1] == 2 && plateau[0][2] == 3 && plateau[1][0] == 4 && plateau[1][1] == 5 && plateau[1][2] == 6 && plateau[2][0] == 7 && plateau[2][1] == 8 && plateau[2][2] == 0);
    }

    public ArrayList<JeuPuzzle> genererFils() {
        ArrayList<JeuPuzzle> maListe= new ArrayList<>();
        int[]position0;
        int[]positionInter = new int[2];
        position0 = getPosition0();
        if (position0[0] !=0) {
            Taquin taquinHaut = new Taquin(copiePlateau());
            positionInter[0] = position0[0] - 1;
            positionInter[1] = position0[1];
            taquinHaut.echangerValeurs(position0, positionInter);
            maListe.add(taquinHaut);
        }
        if (position0[0] !=2) {
            Taquin taquinBas = new Taquin(copiePlateau());
            positionInter[0] = position0[0] + 1;
            positionInter[1] = position0[1];
            taquinBas.echangerValeurs(position0, positionInter);
            maListe.add(taquinBas);
        }
        if (position0[1] !=0) {
            Taquin taquinGauche = new Taquin(copiePlateau());
            positionInter[0] = position0[0];
            positionInter[1] = position0[1] - 1;
            taquinGauche.echangerValeurs(position0, positionInter);
            maListe.add(taquinGauche);
        }
        if (position0[1] !=2) {
            Taquin taquinDroite = new Taquin(copiePlateau());
            positionInter[0] = position0[0];
            positionInter[1] = position0[1] + 1;
            taquinDroite.echangerValeurs(position0, positionInter);
            maListe.add(taquinDroite);
        }
        return maListe;
    }

    private int[] getPosition0() {
        int []position0 = {0,0};
        boolean trouve = false;
        int i = 0;
        int j = 0;
        while (!trouve && i < plateau.length) {
            j = 0;
            while (!trouve && j < plateau[i].length) {
                if (plateau[i][j] == 0)
                {
                    position0[0] = i;
                    position0[1] = j;
                    trouve = true;
                }
                j++;
            }
            i++;
        }
        return position0;
    }

    private int[][] copiePlateau () {
        int [][] plateauRetour = new int[3][3];
        for (int i = 0 ; i < plateauRetour.length; i++) {
            for (int j = 0 ; j < plateauRetour[i].length; j++) {
                plateauRetour[i][j] = plateau[i][j];
            }
        }
        return plateauRetour;
    }

    private void echangerValeurs(int[]point1, int[]point2){
        int tampon = plateau[point1[0]][point1[1]];
        plateau[point1[0]][point1[1]] = plateau[point2[0]][point2[1]];
        plateau[point2[0]][point2[1]] = tampon;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Taquin)) return false;
        Taquin taquin = (Taquin) o;
        return Arrays.deepEquals(plateau, taquin.plateau);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(plateau);
    }
}
