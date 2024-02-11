import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Stockpile {
    private List<Card> cards;

    public Stockpile() {
        cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public Card drawCard() {
        if (!cards.isEmpty()) {
            return cards.remove(cards.size() - 1);
        }
        return null;
    }

    public boolean canDraw() {
        return !cards.isEmpty();
    }

    public void refill(List<Card> newCards) {
        cards.addAll(newCards);
        shuffle();
    }

    public int size() {
        return cards.size();
    }

    private void shuffle() {
        Collections.shuffle(cards);
    }
}