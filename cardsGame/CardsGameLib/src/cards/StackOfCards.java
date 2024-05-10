package cards;

import java.util.Random;

import static cards.Card.faces;
import static cards.Card.suits;

public class StackOfCards {
    private Card[] cards; // масив от всички карти в тестето от карти
    private Card[] smallerPack; // масив на по-малкото тесте делени карти
    private Card[] largerPack; // масив на второто тесте делени карти
    private Card[] hand; // текущо изтеглена ръка от 12 карти
    private Random random; // генератор на случайни числа
    private int currentCard; // брой карти изтеглени текущо от cards
    private int[] faceCounters = new int[8]; // масив за брой на честотата на сила в hand

    public StackOfCards() {
        cards = new Card[64];
        int counter = 0;
        for (int i = 0; i < suits.length; i++) {
            for (int j = 0; j < faces.length; j++) {
                cards[counter++] = new Card(j, i);
                cards[counter++] = new Card(j, i);
            }
        }
    }

    public void shuffleCards() {
        random = new Random();
        Card temp;

        for (int i = 0; i < cards.length; i++) {
            int rand = random.nextInt(cards.length);
            temp = cards[i];
            cards[i] = cards[rand];
            cards[rand] = temp;
        }
        currentCard = 0;
    }

    public String printCards(){
        String string = "";
        string += String.format("%s, %s, %s%n%s, %s, %s%n%s, %s, %s%n%s, %s, %s%n", hand[0].toString(), hand[1].toString(),
                hand[2].toString(), hand[3].toString(), hand[4].toString(), hand[5].toString(), hand[6].toString(),
                hand[7].toString(), hand[8].toString(), hand[9].toString(), hand[10].toString(), hand[11].toString());

        return string;
    }

    public void make2packs() {
        shuffleCards();
        int n = new Random().nextInt(20, 31);
        int remaining = 64 - n;
        int index = 0;
        smallerPack = new Card[n];
        largerPack = new Card[remaining];

        for (int i = 0; i < n; i++) {
            smallerPack[i] = cards[index++];
        }
        for (int j = 0; j < remaining; j++) {
            largerPack[j] = cards[index++];
        }
    }

    public boolean dealHand() {
        hand = new Card[12];
        for (int i = 0; i < 8; i++) {
            faceCounters[i] = 0;
        }
        if (cards.length - currentCard >= 12) {
            for (int i = 0; i < 12; i++) {
                if (currentCard < smallerPack.length) {
                    hand[i] = smallerPack[currentCard];
                    faceCounters[hand[i].getFace()]++;
                } else {
                    hand[i] = largerPack[currentCard - smallerPack.length];
                    faceCounters[hand[i].getFace()]++;
                }
                currentCard++;
            }
            return true;

        } else {
            return false;
        }
    }

    public boolean hasQueenAndKing() {
        return faceCounters[2] > 0 && faceCounters[3] > 0;
    }
    public boolean hasFiveQueen(){
        return faceCounters[3] == 5;
    }








}
