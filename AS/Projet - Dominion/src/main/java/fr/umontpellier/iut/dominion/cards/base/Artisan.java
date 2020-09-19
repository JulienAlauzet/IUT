package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.CardType;
import fr.umontpellier.iut.dominion.Game;
import fr.umontpellier.iut.dominion.ListOfCards;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;
import fr.umontpellier.iut.dominion.cards.common.Duchy;

import java.util.ArrayList;
import java.util.List;

/**
 * Carte Artisan
 * <p>
 * Gagnez une carte coûtant jusqu'à 5 Pièces dans votre main.
 * Mettez une carte de votre main sur votre deck.
 */
public class Artisan extends Card {


    public Artisan() {
        super("Artisan", 6);
    }

    @Override
    public void play(Player p) {
        //gagner une carte


        ListOfCards choixGain = new ListOfCards();
        for (Card c : p.getGame().availableSupplyCards()) {
            if (c.getCost() <= 5) {
                choixGain.add(c);
            }
        }
        String nomCarte = p.chooseCard("Choisir une carte d'une valeur inferieur ou égale à 5", choixGain, false);

        p.gainInHand(nomCarte);

        // mettre une carte sur le deck
        String choixCarte = p.chooseCard("Choisir une carte de votre main", p.getHand(), false);
        p.addToDraw(p.getHand().getCard(choixCarte));
        p.getHand().remove(choixCarte);//suprimer la carte des main


    }

    @Override
    public List<CardType> getTypes() {
        List <CardType> types = super.getTypes();
        types.add(CardType.Action);
        return types;
    }


}