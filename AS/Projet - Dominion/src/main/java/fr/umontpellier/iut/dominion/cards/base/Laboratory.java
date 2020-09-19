package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.CardType;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;

import java.util.List;

/**
 * Carte Laboratoire (Laboratory)
 *
 * +2 Cartes.
 * +1 Action.
 */
public class Laboratory extends Card {
    public Laboratory() {
        super("Laboratory", 5);
    }

    public void play(Player p){
        p.incrementActions(1);

        for(int i=0; i<2; i++)
            p.drawToHand();
    }

    @Override
    public List<CardType> getTypes() {
        List <CardType> types = super.getTypes();
        types.add(CardType.Action);
        return types;
    }
}