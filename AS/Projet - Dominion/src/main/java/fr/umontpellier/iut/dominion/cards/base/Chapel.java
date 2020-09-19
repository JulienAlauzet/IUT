package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.CardType;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;

import java.util.List;

/**
 * Carte Chapelle (Chapel)
 *
 * Écartez jusqu'à 4 cartes de votre main.
 */
public class Chapel extends Card {
    public Chapel() {
        super("Chapel", 2);
    }

    @Override
    public void play(Player p) {

        Card carteARetirer;
        int nbActions = 4;

        while (nbActions > 0) {
            String nomCarteARetirer = p.chooseCard("Vous pouvez encore écarter " + nbActions + " cartes de votre main. Quelle carte retirer?", p.getHand(), true);
            if (nomCarteARetirer.equals(""))
                break;
            carteARetirer = p.removeFromHand(nomCarteARetirer);
            p.getGame().addToTrash(carteARetirer);
            nbActions--;
        }

    }

    @Override
    public List<CardType> getTypes() {
        List <CardType> types = super.getTypes();
        types.add(CardType.Action);
        return types;
    }
}