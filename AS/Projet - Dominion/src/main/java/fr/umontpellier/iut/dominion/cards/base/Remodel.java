package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.CardType;
import fr.umontpellier.iut.dominion.Game;
import fr.umontpellier.iut.dominion.ListOfCards;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;

import java.util.List;
import java.util.function.Predicate;

/**
 * Carte Rénovation (Remodel)
 *
 * Écartez une carte de votre main.
 * Recevez une carte coûtant jusqu'à 2 Pièces de plus que la carte écartée.
 */
public class Remodel extends Card {
    public Remodel() {
        super("Remodel", 4);
    }

    @Override
    public void play(Player p) {

        Game partie = p.getGame();
        ListOfCards choices = p.getCardsInHand();

        String card = p.chooseCard("Quelle carte voulez-vous écarter ?", choices, false);
        Card toTrash = p.removeFromHand(card);
        int costOfCard = toTrash.getCost();
        partie.addToTrash(toTrash);


        ListOfCards choicesCardTwoCoins = partie.availableSupplyCards();
        choicesCardTwoCoins.removeIf(card1 -> card1.getCost() > costOfCard + 2);

        String cardReceive = p.chooseCard("Quelle carte voulez-vous recevoir ?", choicesCardTwoCoins, false);
        p.gainFromSupply(cardReceive);



    }

    @Override
    public List<CardType> getTypes() {
        List <CardType> types = super.getTypes();
        types.add(CardType.Action);
        return types;
    }
}