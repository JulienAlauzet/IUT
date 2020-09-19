package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.CardType;
import fr.umontpellier.iut.dominion.ListOfCards;

import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;

import java.util.List;

/**
 * Carte Salle du trône (Throne Room)
 *
 * Choisissez 1 carte Action de votre main.
 * Jouez-la deux fois.
 */
public class ThroneRoom extends Card {
    public ThroneRoom() {
        super("Throne Room", 4);
    }

    @Override
    public void play(Player p) {

        ListOfCards choixCarte = new ListOfCards();
        for (Card c : p.getCardsInHand())
        {
            if (c.getTypes().contains(CardType.Action)) {
                choixCarte.add(c);
            }
        }
        String nomCarte = p.chooseCard("Choisir une carte action de votre main",choixCarte,true);
        Card c = p.getCardsInHand().getCard(nomCarte);
        if (c != null) {
            c.play(p);
            p.playCard(nomCarte);
        }

    }

    @Override
    public List<CardType> getTypes() {
        List <CardType> types = super.getTypes();
        types.add(CardType.Action);
        return types;
    }
}