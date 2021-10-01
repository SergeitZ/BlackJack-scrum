package com.company.cardGame.blackJack;

import com.company.cardGame.actor.Dealer;
import com.company.cardGame.actor.Player;
import com.company.cardGame.deck.Deck;
import com.company.cardGame.deck.StandardDeck;

import java.util.ArrayList;
import java.util.List;

public class Table {
    //TODO: remove this item.
    Hand player = new Hand(new Player("Sergio"));
    //TODO: Try to implement multiple hands.
    List<Hand> hands = new ArrayList<>();
    //TODO: More comfortable -> try to accomplish without the players list.
    List<Actor> players = new ArrayList<>();
    Hand dealer = new Hand(new Dealer());
    Deck deck;
    public static final int BUST_VALUE = 21;

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
        player.placeBet();
        deal();
        displayTable();
        while (turn(player)) {}
        System.out.println(player.displayHand());
        while(turn(dealer));
        displayTable();
        determineWinner();
        System.out.println(player.getBalance());
    }

    private void displayTable() {
        StringBuilder output = new StringBuilder();
        output.append(dealer.getName()).append(": ").append(dealer.displayHand()).append("\n");
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
        if (player.getValue() > BUST_VALUE) {
            System.out.println(player.getName() + " Busted");
            return;
        }
        if (player.getValue() > dealer.getValue() || dealer.getValue() > BUST_VALUE) {
            System.out.println(player.getName() + " Wins");
            player.payout(Hand.PUSHPAY);
            return;
        }
        System.out.println("Dealer Wins");
    }

    private boolean turn(Hand activeHand) {
        System.out.println(dealer.getName() + ": " + dealer.displayHand());
        byte action = activeHand.getAction();
        return switch (action) {
            case Actor.QUIT -> stand(activeHand);
            case Actor.HIT ->  hit(activeHand);
            case Actor.STAND -> stand(activeHand);
            case Actor.DOUBLE -> doubleDown(activeHand);
            case Actor.SPLIT -> split(activeHand);
            default -> false;
        };
    }

    private boolean hit(Hand activeHand) {
        //TODO: hit
        activeHand.addCard(deck.draw());
        System.out.println("Hit");
        if (activeHand.getValue() > BUST_VALUE) {
            System.out.println("Busted");
            return false;
        }
        return true;
    }

    private boolean stand(Hand activeHand) {
        //TODO: stand
        System.out.println("Stand");
        return false;
    }

    private boolean doubleDown(Hand activeHand) {
        //TODO: double
        activeHand.doubleBet();
        System.out.println("Bet doubled");
        hit(activeHand);
        return false;
    }

    private boolean split(Hand activeHand) {
        return doubleDown(activeHand);
    }
}
