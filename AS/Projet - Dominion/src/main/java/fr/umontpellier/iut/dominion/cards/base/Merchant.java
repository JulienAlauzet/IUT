package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.CardType;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;

import java.util.List;

/**
 * Carte Marchand (Merchant)
         *
         * +1 Carte.
         * +1 Action.
         * La première fois que vous jouez un argent pendant ce tour, +1 Pièce.
         */
public class Merchant extends Card {
    public Merchant() {
        super("Merchant", 3);
    }

    @Override
    public void play(Player p) {

        p.drawToHand();
        p.incrementActions(1);
        if (p.getCardsInPlay().get(p.getCardsInPlay().size() - 1).getName().equals("Throne Room"))
            p.incrementMerchantsThroned(1);

    }

    @Override
    public List<CardType> getTypes() {
        List <CardType> types = super.getTypes();
        types.add(CardType.Action);
        return types;
    }
}
