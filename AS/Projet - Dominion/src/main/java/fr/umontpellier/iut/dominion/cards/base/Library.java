package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.CardType;
import fr.umontpellier.iut.dominion.ListOfCards;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Carte Bibliothèque (Library)
 *
 * Piochez jusqu'à ce que vous ayez 7 cartes en main. Chaque carte Action piochée peut être mise de côté.
 * Défaussez les cartes mises de côté lorsque vous avez terminé de piocher.
 */
public class Library extends Card {
    public Library() {
        super("Library", 5);
    }

    @Override
    public void play(Player p) {
        ListOfCards miseDeCote = new ListOfCards();

        while(p.getCardsInHand().size() < 7)
        {
            Card cartePiochee = p.drawCard();

            if(cartePiochee.getTypes().contains(CardType.Action))
            {
                List<String> choices = Arrays.asList("y", "n");
                String choix = p.chooseOption("Voulez-vous mettre cette carte de côté ?", choices, false);

                if(choix.equals("y"))
                {
                    miseDeCote.add(cartePiochee);
                }
                else
                {
                    p.addToHand(cartePiochee);
                }

            }
            else
            {
                p.addToHand(cartePiochee);
            }
        }

        miseDeCote.putInDiscard(p);
    }

    @Override
    public List<CardType> getTypes() {
        List <CardType> types = super.getTypes();
        types.add(CardType.Action);
        return types;
    }
}