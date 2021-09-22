package com.company.cardGame.blackJack;

public interface Actor {
    String getName();
    int getBalance();
    int getBet(int wallet);
    byte getAction(Hand hand);
}
