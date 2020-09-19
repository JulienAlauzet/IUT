package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.CardType;
import fr.umontpellier.iut.dominion.ListOfCards;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;

import java.util.List;

/**
 * Carte Mine
 *
 * Écartez une carte Trésor de votre main. Recevez une carte Trésor coûtant jusqu'à 3 Pièces de plus ;
 * ajoutez cette carte à votre main.
 */
public class Mine extends Card {
    public Mine() {
        super("Mine", 5);
    }

    @Override
    public void play(Player p) {

        ListOfCards choixCarte = p.getCardsInHand();
        choixCarte.removeIf(card -> !card.getTypes().contains(CardType.Treasure));
        Card carteAEcarter;
        String nomCarteAEcarter = p.chooseCard("Choisissez une carte trésor à écarter", choixCarte, true);
        carteAEcarter = p.getCardsInHand().getCard(nomCarteAEcarter);
        if (carteAEcarter != null) {
            int coutCarteEcartee = carteAEcarter.getCost();
            p.getGame().addToTrash(p.removeFromHand(nomCarteAEcarter));
            choixCarte = p.getGame().availableSupplyCards();
            choixCarte.removeIf(card -> !card.getTypes().contains(CardType.Treasure));
            choixCarte.removeIf(card -> card.getCost() > coutCarteEcartee + 3);
            String nomCarteChoisie = p.chooseCard("Choisissez une carte trésor à mettre dans votre main", choixCarte, false);
            p.addToHand(p.getGame().removeFromSupply(nomCarteChoisie));
        }

    }

    @Override
    public List<CardType> getTypes() {
        List <CardType> types = super.getTypes();
        types.add(CardType.Action);
        return types;
    }

}