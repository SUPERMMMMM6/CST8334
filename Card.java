enum Suit {
    CLUBS,
    DIAMONDS,
    HEARTS,
    SPADES
}

enum Rank {
    ACE,
    TWO,
    THREE,
    FOUR,
    FIVE,
    SIX,
    SEVEN,
    EIGHT,
    NINE,
    TEN,
    JACK,
    QUEEN,
    KING
}

class Card {
    private Suit suit;
    private Rank rank;
    private boolean faceUp;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
        this.faceUp = false;
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    public boolean isFaceUp() {
        return faceUp;
    }

    public void flip() {
        faceUp = !faceUp;
    }

    public boolean isDifferentColor(Card otherCard) {
        if ((this.suit == Suit.CLUBS || this.suit == Suit.SPADES) && (otherCard.suit == Suit.HEARTS || otherCard.suit == Suit.DIAMONDS)) {
            return true;
        }
        if ((this.suit == Suit.HEARTS || this.suit == Suit.DIAMONDS) && (otherCard.suit == Suit.CLUBS || otherCard.suit == Suit.SPADES)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String suitSymbol = "";
        switch (suit) {
            case CLUBS:
                suitSymbol = "\u2663";
                break;
            case DIAMONDS:
                suitSymbol = "\u2666";
                break;
            case HEARTS:
                suitSymbol = "\u2665";
                break;
            case SPADES:
                suitSymbol = "\u2660";
                break;
        }
        String rankSymbol = "";
        switch (rank) {
            case ACE:
                rankSymbol = "A";
                break;
            case JACK:
                rankSymbol = "J";
                break;
            case QUEEN:
                rankSymbol = "Q";
                break;
            case KING:
                rankSymbol = "K";
                break;
            default:
                rankSymbol = String.valueOf(rank.ordinal() + 1);
                break;
        }
        return rankSymbol + suitSymbol;
    }
}