package com.company.cardGame.actor;

import com.company.Utils.Console;
import com.company.cardGame.blackJack.Actor;
import com.company.cardGame.blackJack.Hand;

public class Player implements Actor {
    private final String name;
    private int balance = 1000;

    public Player(String name) {
        this.name = name;
    }

    public Player(String name, int startingBalance) {
        this.name = name;
        balance = startingBalance;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public int getBalance() {
        return balance;
    }

    @Override
    public int getBet() {
        return Console.getInt(1,
                balance,
                "Enter a bet between 1 and " + balance,
                "Invalid bet"
        );
    }

    public String getAvailableActions() {
        StringBuilder output = new StringBuilder();
        output.append("0. Quit\n1. Hit\n. Stand");
        //TODO: add logic for double
        //TODO: 1 confirm first turn
        //TODO: 2 Confirm enough funds
        //TODO: 3 add logic for split detect pair
        return output.toString();
    }

    @Override
    public byte getAction(Hand hand) {
        System.out.println(hand.displayHand());
        System.out.println(hand.getValue());
        //Display available actions
        System.out.println("1. Hit\n2. Stand\n0. Quit");
        return (byte) Console.getInt(0, 2, "", "Invalid action");
    }
}
