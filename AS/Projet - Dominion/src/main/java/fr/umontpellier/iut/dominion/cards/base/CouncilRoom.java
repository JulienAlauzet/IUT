package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.CardType;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;
import fr.umontpellier.iut.dominion.Game;
import java.util.ArrayList;
import java.util.List;

/**
 * Carte Chambre du conseil (Council Room)
 *
 * +4 Cartes.
 * +1 Achat.
 * Tous vos adversaires piochent 1 carte.
 */
public class CouncilRoom extends Card {
    public CouncilRoom() {
        super("Council Room", 5);
    }


    @Override
    public void play(Player p) {

        //+4 Cartes
        for (int i = 0; i<4;i++)
        {
            p.addToHand(p.drawCard());

        }
        //incrementer achat
        p.incrementBuys(1);

        //adversaires piochent 1 carte.
        for (Player player : p.getOtherPlayers()) {
            player.addToHand(player.drawCard());
        }

    }

    @Override
    public List<CardType> getTypes() {
        List <CardType> types = super.getTypes();
        types.add(CardType.Action);
        return types;
    }
}