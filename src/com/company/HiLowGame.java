package com.company;

import com.company.cardGame.deck.Card;
import com.company.cardGame.deck.Deck;
import com.company.cardGame.deck.StandardDeck;

import java.util.Scanner;

public class HiLowGame {
    Scanner scanner = new Scanner(System.in);
    Card card1;

    public void playGame() {
        Deck deck = new StandardDeck();
        deck.shuffle();
        if (card1 == null) {card1 = deck.draw();}
        System.out.println(card1.display());
        System.out.println("\nWill the next card (l)ower or (h)igher?");

        String input = scanner.nextLine();
        Card card2 = deck.draw();
        System.out.println(card2.display());

        if (input.equalsIgnoreCase("h")) {
            if (card1.getValue() < card2.getValue()) {
                System.out.println("Winner");
            }
            else {
                System.out.println("Loser");
            }

        }
        if (input.equalsIgnoreCase("l")) {
            if (card1.getValue() > card2.getValue()) {
                System.out.println("Winner");
            }
            else {
                System.out.println("Loser");
            }

        }
        card1 = card2;
        System.out.print("Do you want to stop playing? (y/n)");
        String quitGame =  scanner.nextLine();
        if (quitGame.equalsIgnoreCase("y")) {
            System.exit(200);
        }
    }

}
