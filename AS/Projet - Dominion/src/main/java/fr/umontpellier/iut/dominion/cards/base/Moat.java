package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.CardType;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;

import java.util.ArrayList;
import java.util.List;

/**
 * Carte Douves (Moat)
 *
 * +2 Cartes.
 * Lorsqu’un adversaire joue une carte Attaque, vous pouvez dévoiler cette carte de votre main. Dans ce
 * cas, l’Attaque n’a pas d’effet sur vous.
 */
public class Moat extends Card {
    public Moat() {
        super("Moat", 2);
    }

    @Override
    public void play(Player p) {
        p.drawToHand();
        p.drawToHand();
    }

    public boolean choixUtiliser (Player p) {
        ArrayList<String> choixPossibles = new ArrayList<>();
        choixPossibles.add("y");
        choixPossibles.add("n");
        String choix = p.chooseOption("Souhaitez vous-utiliser la réaction de Moat? (y/n)", choixPossibles, false);
        return choix.equals("y");
    }

    @Override
    public List<CardType> getTypes() {
        List <CardType> types = super.getTypes();
        types.add(CardType.Reaction);
        types.add(CardType.Action);
        return types;
    }
}