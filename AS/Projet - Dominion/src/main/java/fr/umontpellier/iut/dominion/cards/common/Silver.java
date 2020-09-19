package fr.umontpellier.iut.dominion.cards.common;

import fr.umontpellier.iut.dominion.CardType;
import fr.umontpellier.iut.dominion.ListOfCards;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;

import java.util.ArrayList;
import java.util.List;

/**
 * Carte Argent (Silver)
 *
 * 2 Pièces
 */
public class Silver extends Card {
    public Silver() {
        super("Silver", 3);
    }

    @Override
    public void play(Player p) {
        p.incrementMoney(2);
        ListOfCards silversInPlay = p.getCardsInPlay();
        silversInPlay.removeIf(card -> !card.getName().equals("Silver"));
        if (silversInPlay.size() == 1) {
            ListOfCards merchantsInPlay = p.getCardsInPlay();
            merchantsInPlay.removeIf(card -> !card.getName().equals("Merchant"));
            p.incrementMoney(merchantsInPlay.size() + p.getNumberOfMerchantsThroned());
        }
        p.incrementMerchantsThroned(-(p.getNumberOfMerchantsThroned()));
    }

    @Override
    public List<CardType> getTypes() {
        List <CardType> types = super.getTypes();
        types.add(CardType.Treasure);
        return types;
    }

}
