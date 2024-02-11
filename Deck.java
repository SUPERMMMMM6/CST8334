import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Deck {
    private List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        initializeDeck();
    }

    private void initializeDeck() {
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new Card(suit, rank));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card drawCard() {
        if (cards.isEmpty()) {
            return cards.remove(cards.size() - 1);
        }
        return null;
    }

    public int size() {
        return cards.size();
    }
}
