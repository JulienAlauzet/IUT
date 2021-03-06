package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.CardType;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;

import java.util.List;

/**
 * Carte Festival
 *
 * +2 Actions.
 * +1 Achat.
 * +2 Pièces.
 */
public class Festival extends Card {
    public Festival() {
        super("Festival", 5);
    }

    public void play(Player p) {
        p.incrementActions(2);
        p.incrementBuys(1);
        p.incrementMoney(2);
    }

    @Override
    public List<CardType> getTypes() {
        List <CardType> types = super.getTypes();
        types.add(CardType.Action);
        return types;
    }
}