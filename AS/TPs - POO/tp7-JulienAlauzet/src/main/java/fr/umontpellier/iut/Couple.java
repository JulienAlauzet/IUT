package fr.umontpellier.iut;

import java.util.*;

public class Couple {

    private JeuPuzzle jeuPuzzle;
    private Couple predecesseur;

    public Couple(JeuPuzzle jeuPuzzle, Couple predecesseur) {
        this.jeuPuzzle = jeuPuzzle;
        this.predecesseur = predecesseur;
    }

    public ArrayList<JeuPuzzle> getListeDeMouvements() {
        ArrayList<JeuPuzzle> listeTaquins = new ArrayList<>();
        Couple courant = new Couple(this.jeuPuzzle, this.predecesseur);
        listeTaquins.add(courant.jeuPuzzle);
        while (courant.predecesseur != null) {
            courant = courant.predecesseur;
            listeTaquins.add(0, courant.jeuPuzzle);
        }
        return listeTaquins;
    }

    public void mettreAJour(List<Couple> frontiere, ArrayList<JeuPuzzle> tab, Set<JeuPuzzle> dejaVus) {
        for (JeuPuzzle jeuPuzzle :
                tab) {
            if (dejaVus.add(jeuPuzzle))
                frontiere.add(new Couple(jeuPuzzle,this));
        }
    }

    public JeuPuzzle getJeuPuzzle() {
        return jeuPuzzle;
    }

    @Override
    public String toString() {
        return "Couple{" +
                "taquin=" + jeuPuzzle +
                ", predecesseur=" + predecesseur +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Couple)) return false;
        Couple couple = (Couple) o;
        return jeuPuzzle.equals(couple.jeuPuzzle) &&
                predecesseur.equals(couple.predecesseur);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jeuPuzzle, predecesseur);
    }
}
