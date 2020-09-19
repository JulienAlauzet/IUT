package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.CardType;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;

import java.util.List;

/**
 * Carte Marché (Market)
 *
 * +1 Carte.
 * +1 Action.
 * +1 Achat.
 * +1 Pièce.
 */
public class Market extends Card {
    public Market() {
        super("Market", 5);
    }

    public void play(Player p){
        p.drawToHand();
        p.incrementActions(1);
        p.incrementBuys(1);
        p.incrementMoney(1);
    }

    @Override
    public List<CardType> getTypes() {
        List <CardType> types = super.getTypes();
        types.add(CardType.Action);
        return types;
    }
}