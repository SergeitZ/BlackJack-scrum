package com.company.cardGame.actor;

import com.company.Utils.Console;
import com.company.cardGame.blackJack.Actor;
import com.company.cardGame.blackJack.Hand;

public class Sergio implements Actor {
    private final String name = "Sergio";
    private int balance = 1000;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getBalance() {
        return balance;
    }

    @Override
    public int placeBet() {
        int bet = Console.getInt(
                "Enter a bet between 1 and " + balance, 1,
                balance,
                "invalid bet"
        );
        balance -= bet;
        return bet;
    }

    @Override
    public byte getAction(Hand hand, int dealer) {
        return 0;
    }

    @Override
    public void addBalance(int amt) {
        balance += amt;
    }
}
