package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.CardType;
import fr.umontpellier.iut.dominion.ListOfCards;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;

import java.util.List;

/**
 * Carte Atelier (Workshop)
 *
 * Recevez une carte coûtant jusqu'à 4 Pièces.
 */
public class Workshop extends Card {
    public Workshop() {
        super("Workshop", 3);
    }

    @Override
    public void play(Player p) {

        ListOfCards choixCarte = p.getGame().availableSupplyCards();
        choixCarte.removeIf(card -> card.getCost() > 4);
        String nomCarteChoisie = p.chooseCard("Vous pouvez retirer de la réserve une carte de coût allant jusque 4. Laquelle choisissez vous?", choixCarte, false);
        p.discardCard(p.getGame().removeFromSupply(nomCarteChoisie));

    }

    @Override
    public List<CardType> getTypes() {
        List <CardType> types = super.getTypes();
        types.add(CardType.Action);
        return types;
    }
}
