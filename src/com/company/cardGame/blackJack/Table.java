package com.company.cardGame.blackJack;

import com.company.cardGame.actor.Dealer;
import com.company.cardGame.actor.Player;
import com.company.cardGame.deck.Deck;
import com.company.cardGame.deck.StandardDeck;

public class Table {
    Hand player = new Hand(new Player("Player"));
    Hand dealer = new Hand(new Dealer());
    Deck deck;

    public void playRound() {
        deck = new StandardDeck();
        deck.shuffle();
        /*
        0. Take bets
        1. deal cards
        b2. see who won
        a2. players turn
        a3. dealers turn
        a4. see who won
         */
        deal();
        displayTable();
        turn(player);
        turn(dealer);
        determineWinner();
    }

    private void displayTable() {
        StringBuilder output = new StringBuilder();
        output.append("Dealer: ").append(dealer.displayHand()).append("\n");
        output.append("Player: ").append(player.displayHand());
        System.out.println(output);
    }

    public void deal() {
        for (int count = 0; count < 2; count++) {
            // list of hands
            dealer.addCard(deck.draw());
            player.addCard(deck.draw());
        }
    }

    private void determineWinner() {
        if (player.getValue() > dealer.getValue()) {
            System.out.println("Player Wins");
            return;
        }
        if (player.getValue() == dealer.getValue()) {
            System.out.println("Push");
            return;
        }
        System.out.println("Dealer Wins");
    }

    private void turn(Hand activeHand) {
        System.out.println("Dealer: " + dealer.displayHand());
        byte action = activeHand.getAction();
        switch (action) {
            case 0 -> stand(activeHand);
            case 1 ->  hit(activeHand);
            case 2 -> stand(activeHand);
            case 3 -> doubleDown(activeHand);
            case 4 -> split(activeHand);
            default -> System.out.println("ERROR bad action" + action);
        }
        System.out.println(activeHand.displayHand() + "\n" + activeHand.getValue());
    }

    private void hit(Hand activeHand) {
        //TODO: hit
        activeHand.addCard(deck.draw());
        System.out.println("Hit");
    }

    private void stand(Hand activeHand) {
        //TODO: stand
        System.out.println("Stand");
    }

    private void doubleDown(Hand activeHand) {
        //TODO: double
        activeHand.doubleBet();
        System.out.println("Bet doubled");
        hit(activeHand);
    }

    private void split(Hand activeHand) {
        doubleDown(activeHand);
    }

}
