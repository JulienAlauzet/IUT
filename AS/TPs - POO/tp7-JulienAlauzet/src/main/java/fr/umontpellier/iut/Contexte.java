package fr.umontpellier.iut;

import java.util.*;

public class Contexte {

    private JeuPuzzle jeuPuzzle;
    private ArrayList<JeuPuzzle> solution;

    public Contexte(JeuPuzzle jeuPuzzle) {
        this.jeuPuzzle = jeuPuzzle;
    }

    public void resoudre() { // Frontière gérée en file - Pas optimal car on ne trouve pas forcément la solution la plus courte
        if (!jeuPuzzle.estGagnant()) {
            Boolean gagne = false;
            int i = 1;
            Couple coupleDepart = new Couple(jeuPuzzle, null);
            ArrayList<JeuPuzzle> taquinsFils = jeuPuzzle.genererFils();
            List<Couple> frontiere = new LinkedList<>();
            Set<JeuPuzzle> dejaVus = new HashSet<>();
            dejaVus.add(jeuPuzzle);
            coupleDepart.mettreAJour(frontiere, taquinsFils, dejaVus);
            while (!(frontiere.isEmpty() || gagne)) {
                System.out.println("itération n° "+i);
                System.out.println("nombre de couples dans frontiere : "+frontiere.size()); // Ajout des sout pour vérifier qu'on n'est pas dans une boucle infinie
                //System.out.println(frontiere);
                System.out.println("nombre de situations dans dejaVus : "+dejaVus.size());
                //System.out.println(dejaVus);
                if (frontiere.get(0).getJeuPuzzle().estGagnant()) {
                    solution = frontiere.get(0).getListeDeMouvements();
                    gagne = true;
                }
                else {
                    taquinsFils  = frontiere.get(0).getJeuPuzzle().genererFils();
                    frontiere.get(0).mettreAJour(frontiere, taquinsFils, dejaVus);
                    frontiere.remove(0);
                }
                i++;
            }
            if (!gagne) {
                solution = new ArrayList<>();
            }
        }
    }

    @Override
    public String toString() {
        if (jeuPuzzle.estGagnant()) {
            return "Taquin déjà gagnant";
        }
        else if (solution.isEmpty()) {
            return "Aucune solution gagnante";
        }
        else {
            return "Contexte{" +
                    "taquin de départ =" + jeuPuzzle +
                    ", solution=" + solution +
                    '}';
        }
    }
}