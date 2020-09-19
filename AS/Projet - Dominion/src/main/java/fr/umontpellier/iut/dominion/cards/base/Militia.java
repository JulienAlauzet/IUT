package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.CardType;
import fr.umontpellier.iut.dominion.Game;
import fr.umontpellier.iut.dominion.ListOfCards;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;

import java.util.List;

/**
 * Carte Milice (Militia)
 *
 * +2 Pièces.
 * Tous vos adversaires défaussent leurs cartes de façon à n'avoir que 3 cartes en main.
 */
public class Militia extends Card {
    public Militia() {
        super("Militia", 4);
    }

    public void play(Player p){
        p.incrementMoney(2);

        List<Player> autreJoueurs = p.getOtherPlayers();
        for (Player x :
                autreJoueurs) {
            if (x.reactMoat())
                    autreJoueurs.remove(x);
        }

        for (Player x: autreJoueurs) {
            while (x.getCardsInHand().size() > 3){
                ListOfCards choices = x.getCardsInHand();
                String carte = x.chooseCard("Quelle carte voulez-vous défausser ?", choices, false);

                x.discardCard(x.removeFromHand(carte));
            }
        }
    }
    @Override
    public List<CardType> getTypes() {
        List <CardType> types = super.getTypes();
        types.add(CardType.Action);
        types.add(CardType.Attack);
        return types;
    }
}