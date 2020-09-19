package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.CardType;
import fr.umontpellier.iut.dominion.ListOfCards;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;

import java.util.List;

/**
 * Carte Cave (Cellar)
 *
 * +1 Action.
 * Défaussez autant de cartes que vous voulez.
 * +1 Carte par carte défaussée.
 */
public class Cellar extends Card {
    public Cellar() {
        super("Cellar", 2);
    }

    @Override
    public void play(Player p) {

        Card carteADefausser;
        int compteur = 0;

        while (true) {
            String nomCarteADefausser = p.chooseCard("Quelle carte défausser?", p.getCardsInHand(), true);
            if (nomCarteADefausser.equals(""))
                break;
            carteADefausser = p.removeFromHand(nomCarteADefausser);
            p.discardCard(carteADefausser);
            compteur++;
        }

        for (int i = 0; i < compteur; i++) {
            p.drawToHand();
        }

        p.incrementActions(1);

    }

    @Override
    public List<CardType> getTypes() {
        List <CardType> types = super.getTypes();
        types.add(CardType.Action);
        return types;
    }
}