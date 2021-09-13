package com.company.card;

public class Card {
    public final String suit;
    public final String value;

    public Card(String suit, String value) {
        this.suit = suit;
        this.value = value;
    }

    @Override
    public String toString() {
        return "\n" + suit + " " + value;
    }
}
