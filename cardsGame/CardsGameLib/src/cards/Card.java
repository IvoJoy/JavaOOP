package cards;

public class Card {
    private int face;
    private int suit;

    public static String[] faces = {"ACE", "TEN", "KING", "QUEEN", "JACK", "NINE", "EIGHT", "SEVEN"};

    public static String[] suits = {"CLUBS", "DIAMONDS", "HEARTS", "SPADES"};

    public Card(int face, int suit) {
        setFace(face);
        setSuit(suit);
    }

    public int getFace() {
        return face;
    }

    public void setFace(int face) {

        if (face < faces.length && face >= 0) {
            this.face = face;
        } else {
            this.face = 0;
        }
    }

    public int getSuit() {
        return suit;
    }

    public String getSuitName() {
        return suits[suit];
    }

    public void setSuit(int suit) {
        if (suit < suits.length && suit >= 0) {
            this.suit = suit;
        } else {
            this.suit = 0;
        }

    }

    @Override
    public String toString() {
        return String.format("%s of %s", faces[face], suits[suit]);
    }
}
