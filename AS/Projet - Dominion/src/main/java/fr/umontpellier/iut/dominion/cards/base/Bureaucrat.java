package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.CardType;
import fr.umontpellier.iut.dominion.Game;
import fr.umontpellier.iut.dominion.ListOfCards;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;

import java.util.ArrayList;
import java.util.List;

/**
 * Carte Bureaucrate (Bureaucrat)
 *
 * Recevez une carte Argent; placez-la sur votre deck.
 * Tous vos adversaires dévoilent une carte Victoire et la placent sur leur deck (sinon ils dévoilent leur
 * main afin que vous puissiez voir qu'ils n'ont pas de cartes Victoire).
 */
public class Bureaucrat extends Card {
    public Bureaucrat() {
        super("Bureaucrat", 4);
    }

    public void play(Player p) {
        //recevoir une carte argent
        p.addToDraw(p.getGame().removeFromSupply("Silver"));

        List<Player> joueurs = p.getOtherPlayers();
        for (Player x :
                joueurs) {
            if (x.reactMoat())
                joueurs.remove(x);
        }

        String nomCarteChoisie;

        for (Player x :
                joueurs) {
            ListOfCards choixPossibles = x.getCardsInHand();
            choixPossibles.removeIf(card -> !card.getTypes().contains(CardType.Victory));
            nomCarteChoisie = x.chooseCard("Quelle carte dévoiler puis metrre dans le deck?", choixPossibles, false);
            if (!nomCarteChoisie.equals(""))
                x.addToDraw(x.removeFromHand(nomCarteChoisie));
            else {
                System.out.println("Le joueur " + x.getName() + "a la main suivante :");
                ListOfCards mainDuJoueur = x.getCardsInHand();
                System.out.println(mainDuJoueur.toString());
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