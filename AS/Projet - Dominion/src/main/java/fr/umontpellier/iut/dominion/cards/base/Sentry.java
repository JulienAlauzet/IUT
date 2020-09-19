package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.CardType;
import fr.umontpellier.iut.dominion.ListOfCards;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;

import java.util.Arrays;
import java.util.List;

/**
 * Carte Sentinelle (Sentry)
 *
 * +1 Carte.
 * +1 Action.
 * Regardez les 2 premières cartes de votre deck. Écartez et/ou défaussez celles que vous voulez.
 * Replacez les autres sur votre deck dans l'ordre de votre choix.
 */
public class Sentry extends Card {
    public Sentry() {
        super("Sentry", 5);
    }

    @Override
    public void play(Player p) {
        p.incrementActions(1);
        p.drawToHand();

        ListOfCards drawCards = new ListOfCards();
        drawCards.add(p.drawCard());
        drawCards.add(p.drawCard());

        String nomCarteChoisie;
        Card carteChoisie;

        while (!drawCards.isEmpty()) {
            nomCarteChoisie = p.chooseCard("Quelle carte écarter?", drawCards, true);
            if (nomCarteChoisie.equals(""))
                break;
            p.getGame().addToTrash(drawCards.remove(nomCarteChoisie));
        }

        while (!drawCards.isEmpty()) {
            nomCarteChoisie = p.chooseCard("Quelle carte défausser?", drawCards, true);
            if (nomCarteChoisie.equals(""))
                break;
            p.discardCard(drawCards.remove(nomCarteChoisie));
        }

        if (drawCards.size() == 1)
            p.addToDraw(drawCards.remove(0));

        if (drawCards.size() == 2) {
            nomCarteChoisie = p.chooseCard("Quelle carte replacer en premier dans votre pioche?", drawCards, false);
            p.addToDraw(drawCards.remove(nomCarteChoisie));
            p.addToDraw(drawCards.remove(0));
        }

    }

    @Override
    public List<CardType> getTypes() {
        List <CardType> types = super.getTypes();
        types.add(CardType.Action);
        return types;
    }
}
