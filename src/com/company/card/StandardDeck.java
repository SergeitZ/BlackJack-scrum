package com.company.card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StandardDeck implements Deck {
    private List<Card> cards = new ArrayList<>();
    public final String[] SUITS = {
            "Clubs", "Hearts", "Diamonds", "Spades"
    };
    public final String[] VALUES = {
            "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"
    };

    public void printDeck() {
        System.out.println(cards);
    }

    public StandardDeck() {
        for (String suit : SUITS) {
            for (String value : VALUES) {
                cards.add(new Card(suit, value));
            }
        }
    }

    @Override
    public void shuffle() {
        Collections.shuffle(cards);
    }

    @Override
    public Card deal() {
        return cards.remove(cards.size() - 1 );
    }
}
