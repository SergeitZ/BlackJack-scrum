package com.company;

import com.company.card.CheatersDeck;
import com.company.card.Deck;
import com.company.card.StandardDeck;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Deck deck = new CheatersDeck();

        deck.shuffle();
        for (int i = 0; i < 5; i++) {
            System.out.println(deck.deal());
        }
    }
}
