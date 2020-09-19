package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.CardType;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;

import java.util.List;

/**
 * Carte Avant-coureur (Harbinger)
 *
 * +1 Carte.
 * +1 Action.
 * Regardez dans votre défausse, vous pouvez prendre une carte et la mettre sur votre deck.
 */
public class Harbinger extends Card {
    public Harbinger() {
        super("Harbinger", 3);
    }

    @Override
    public void play(Player p) {
        p.incrementActions(1);
        p.addToHand(p.drawCard());

        String str = p.chooseCard("Choisissez une carte de votre defausse, elle sera mise dans votre deck\nvotre defausse : " + p.getDiscard(),p.getDiscard(),true);
        if(!str.equals(""))
        {
            Card c = p.getDiscard().remove(str);
            p.addToDraw(c);
        }


    }

    @Override
    public List<CardType> getTypes() {
        List <CardType> types = super.getTypes();
        types.add(CardType.Action);
        return types;
    }
}