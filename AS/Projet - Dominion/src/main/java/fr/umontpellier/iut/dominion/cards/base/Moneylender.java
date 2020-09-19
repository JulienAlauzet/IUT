package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.CardType;
import fr.umontpellier.iut.dominion.ListOfCards;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;

import java.util.List;

/**
 * Carte Prêteur sur gages (Moneylender)
 *
 * Écartez une carte Cuivre de votre main.
 * Dans ce cas, +3 Pièces.
 */
public class Moneylender extends Card {
    public Moneylender() {
        super("Moneylender", 4);
    }

    @Override
    public void play(Player p) {

        ListOfCards choixCarte = p.getCardsInHand();
        choixCarte.removeIf(card -> !card.getName().equals("Copper"));
        String nomCopperARetirer = p.chooseCard("Vous pouvez écarter un cuivre de votre main pour obtenir 3 pièces", choixCarte, true);
        if (nomCopperARetirer.equals("Copper")) {
            p.getGame().addToTrash(p.removeFromHand("Copper"));
            p.incrementMoney(3);
        }

    }

    @Override
    public List<CardType> getTypes() {
        List <CardType> types = super.getTypes();
        types.add(CardType.Action);
        return types;
    }
}