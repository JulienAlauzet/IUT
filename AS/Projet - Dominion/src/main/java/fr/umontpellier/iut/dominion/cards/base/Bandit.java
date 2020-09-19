package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.CardType;
import fr.umontpellier.iut.dominion.Game;
import fr.umontpellier.iut.dominion.ListOfCards;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;

import java.util.List;

/**
 * Carte Bandit
 *
 * Gagnez un Or.
 * Chaque joueur révèle les deux premières cartes de son deck, écarte un trésor autre que Cuivre et défausse le reste.
 */
public class Bandit extends Card {
    public Bandit() {
        super("Bandit", 5);
    }

    @Override
    public void play(Player p) {

        p.gainFromSupply("Gold");

        Game partie = p.getGame();

        List<Player> joueurs = p.getOtherPlayers();
        joueurs.add(p);
        for (Player x :
                joueurs) {
            if (x.reactMoat())
                joueurs.remove(x);
        }

        for (Player x : joueurs) {

            ListOfCards drawCardsToDiscard = new ListOfCards();
            drawCardsToDiscard.add(x.drawCard());
            drawCardsToDiscard.add(x.drawCard());

            ListOfCards toTrash = new ListOfCards();
            for (Card c : drawCardsToDiscard) {
                if (cardIsTreasureOtherThanCopper(c)) {
                    toTrash.add(c);
                }
            }

            if(toTrash.size() == 2){
                String cardToTrash = x.chooseCard("Quelle carte voulez-vous écarter ?", toTrash, false);
                partie.addToTrash(toTrash.getCard(cardToTrash));
                drawCardsToDiscard.remove(cardToTrash);
            } else if (toTrash.size() == 1){
                partie.addToTrash(toTrash.get(0));
                drawCardsToDiscard.remove(toTrash.get(0));
            }

            for (Card c : drawCardsToDiscard) {
                x.discardCard(c);
            }

        }
    }

    private boolean cardIsTreasureOtherThanCopper(Card pioche){
        return pioche.getTypes().contains(CardType.Treasure) && !pioche.getName().equals("Copper");
    }


    @Override
    public List<CardType> getTypes() {
        List <CardType> types = super.getTypes();
        types.add(CardType.Action);
        types.add(CardType.Attack);
        return types;
    }
}
