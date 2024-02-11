import java.util.ArrayList;
import java.util.List;

class Tableau {
    private List<List<Card>> piles;

    public Tableau(int numPiles) {
        piles = new ArrayList<>();
        for (int i = 0; i < numPiles; i++) {
            piles.add(new ArrayList<>());
        }
    }

    public void addCard(int pileIndex, Card card) {
        piles.get(pileIndex).add(card);
    }

    public List<Card> getPile(int pileIndex) {
        return piles.get(pileIndex);
    }

    public Card removeCard(int pileIndex) {
        List<Card> pile = piles.get(pileIndex);
        if (!pile.isEmpty()) {
            return pile.remove(pile.size() - 1);
        }
        return null;
    }

    public boolean canAddCard(int pileIndex, Card card) {
        List<Card> pile = piles.get(pileIndex);
        if (pile.isEmpty()) {
            return card.getRank() == Rank.KING;
        } else {
            Card topCard = pile.get(pile.size() - 1);
            return card.isDifferentColor(topCard) && card.getRank().ordinal() == topCard.getRank().ordinal() - 1;
        }
    }
}