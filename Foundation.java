import java.util.ArrayList;
import java.util.List;

class Foundation {
    private List<Card> cards;
    private Suit suit;

    public Foundation(Suit suit) {
        this.suit = suit;
        cards = new ArrayList<>();
    }

    public boolean canAddCard(Card card) {
        if (cards.isEmpty()) {
            return card.getRank() == Rank.ACE && card.getSuit() == suit;
        } else {
            Card topCard = cards.get(cards.size() - 1);
            return card.getSuit() == suit && card.getRank().ordinal() == topCard.getRank().ordinal() + 1;
        }
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public Card removeCard() {
        if (!cards.isEmpty()) {
            return cards.remove(cards.size() - 1);
        }
        return null;
    }

    public Suit getSuit() {
        return suit;
    }

    public List<Card> getCards() {
        return cards;
    }

    public boolean isComplete() {
        return cards.size() == Rank.values().length;
    }
}