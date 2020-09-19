package fr.umontpellier.iut;

import java.util.Comparator;

public class ComparateurEmploye implements Comparator<Employe> {

    @Override
    public int compare (Employe e1, Employe e2){
        if (e1.getNom().compareTo(e2.getNom()) != 0)
            return e1.getNom().compareTo(e2.getNom());
        return e2.getNINSEE().compareTo(e1.getNINSEE());
    }
}
