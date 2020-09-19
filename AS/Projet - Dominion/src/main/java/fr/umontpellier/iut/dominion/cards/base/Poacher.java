package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.CardType;
import fr.umontpellier.iut.dominion.ListOfCards;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;

import java.util.List;

/**
 * Carte Braconnier (Poacher)
 *
 * +1 Action.
 * +1 Carte.
 * +1 Pièce.
 * Défaussez une carte de votre main par pile de réserve épuisée.
 */
public class Poacher extends Card {
    public Poacher() {
        super("Poacher", 4);
    }

    @Override
    public void play(Player p) {

        p.incrementActions(1);
        p.incrementMoney(1);
        p.drawToHand();
        String nomCarteADefausser;
        for (int i = p.getGame().emptyStacks(); i > 0; i--) {
            nomCarteADefausser = p.chooseCard("Vous devez défausser " + i + " cartes de votre main. Laquelle défausser?", p.getCardsInHand(), false);
            p.discardCard(p.removeFromHand(nomCarteADefausser));
        }

    }

    @Override
    public List<CardType> getTypes() {
        List <CardType> types = super.getTypes();
        types.add(CardType.Action);
        return types;
    }

}
