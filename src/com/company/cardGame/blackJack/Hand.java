package com.company.cardGame.blackJack;

import com.company.cardGame.deck.Card;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private List<Card> cards = new ArrayList<>();
    private int bet = 0;
    private Actor holder;

    public Hand(Actor holder) {
        this.holder = holder;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public String displayHand() {
        String output = "";
        for (Card card : cards) {
            output+= card.display() + " ";
        }

        return output.toString().trim();
    }

    public int getValue() {
        int score = 0;
        boolean hasAce11 = false;
        for (Card card : cards) {
            int value = card.getRank();

            switch (value) {
                case 1 -> {
                    value = score + 11 > 21 ? 1 : 11;
                    if (value == 11) {
                        hasAce11 = true;
                    }
                    score += value;
                }
                case 11, 12, 13 -> score += 10;
                default -> score += value;
            }
            if(score > 21 && hasAce11) {
                score -= 10;
                hasAce11 = false;
            }
        }
        return score;
    }

    //getting composition methods
    //getter with no setter
    //pass through method

    public byte getAction() {
        return holder.getAction(this);
    }

    public int size() { return cards.size(); }

    public int getBet() { return bet; }

    public boolean canSplit() {
        return cards.get(0).getRank() == cards.get(1).getRank();
    }

    public void doubleBet() {
        bet *= 2;
    }

}
