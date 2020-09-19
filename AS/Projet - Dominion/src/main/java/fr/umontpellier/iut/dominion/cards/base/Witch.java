package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.CardType;
import fr.umontpellier.iut.dominion.Game;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;

import java.util.List;

/**
 * Carte Sorcière (Witch)
 *
 * +2 Cartes.
 * Tous vos adversaires recoivent une carte Curse.
 */
public class Witch extends Card {
    public Witch() {
        super("Witch", 5);
    }

    @Override
    public void play(Player p)
    {
        p.drawToHand();
        p.drawToHand();
        Game g = p.getGame();


        for(Player x : p.getOtherPlayers())
        {
            if (!x.reactMoat())
                x.discardCard(g.removeFromSupply("Curse")); // à verifier si c'est dans la main du joueur.
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