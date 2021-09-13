package com.company.card;

import java.util.Arrays;
import java.util.Scanner;

public class CheatersDeck implements Deck {
    private Scanner scanner = new Scanner(System.in);

    public final String[] SUITS = {
            "Clubs", "Hearts", "Diamonds", "Spades"
    };
    public final String[] VALUES = {
            "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"
    };

    @Override
    public void shuffle() {
    }

    @Override
    public Card deal() {
        System.out.println(Arrays.toString(SUITS));
        System.out.println("Which suit? (1-4)");
        int suitIndex = Integer.parseInt(scanner.nextLine()) - 1;

        System.out.println(Arrays.toString(VALUES));
        System.out.println("Which value? (1-13)" );
        int valueIndex = Integer.parseInt(scanner.nextLine()) - 1;

        return  new Card(SUITS[suitIndex], VALUES[valueIndex]);
    }

    public void printDeck() {
    }
}
