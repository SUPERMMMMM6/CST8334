import java.util.List;

class SolitaireGame {
    private Deck deck;
    private Tableau tableau;
    private Foundation[] foundations;
    private Stockpile stockpile;
    private TalonPile talonPile;
    private int score;

    public SolitaireGame() {
        deck = new Deck();
        tableau = new Tableau(7);
        foundations = new Foundation[4];
        for (int i = 0; i < 4; i++) {
            foundations[i] = new Foundation(Suit.values()[i]);
        }
        stockpile = new Stockpile();
        talonPile = new TalonPile();
        score = 0;
    }

    public void startNewGame() {
        deck.shuffle();
        initializeTableau();
        initializeStockpile();
        score = 0;
    }

    private void initializeTableau() {
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j <= i; j++) {
                Card card = deck.drawCard();
                if (j == i) {
                    card.flip();
                }
                tableau.addCard(i, card);
            }
        }
    }

    private void initializeStockpile() {
        for (int i = 0; i < deck.size(); i++) {
            Card card = deck.drawCard();
            stockpile.addCard(card);
        }
    }

    public boolean moveCard(int sourcePileIndex, int destinationPileIndex) {
        if (checkMoveValidity(sourcePileIndex, destinationPileIndex)) {
            Card card = tableau.removeCard(sourcePileIndex);
            tableau.addCard(destinationPileIndex, card);
            updateScore();
            return true;
        }
        return false;
    }

    public void flipCard(int pileIndex) {
        List<Card> pile = tableau.getPile(pileIndex);
        if (!pile.isEmpty()) {
            Card topCard = pile.get(pile.size() - 1);
            if (!topCard.isFaceUp()) {
                topCard.flip();
                updateScore();
            }
        }
    }

    private boolean checkMoveValidity(int sourcePileIndex, int destinationPileIndex) {
        List<Card> sourcePile = tableau.getPile(sourcePileIndex);
        List<Card> destinationPile = tableau.getPile(destinationPileIndex);
        if (sourcePile.isEmpty()) {
            return false;
        }
        Card sourceCard = sourcePile.get(sourcePile.size() - 1);
        if (destinationPile.isEmpty()) {
            return sourceCard.getRank() == Rank.KING;
        }
        Card destinationCard = destinationPile.get(destinationPile.size() - 1);
        return sourceCard.isDifferentColor(destinationCard) && sourceCard.getRank().ordinal() == destinationCard.getRank().ordinal() - 1;
    }

    private void updateScore() {
        score++;
    }

    // Additional methods can be added as per your requirements
}