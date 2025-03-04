package com.example.project;
import java.util.ArrayList;
public class Main
{
    public static void main(String[] args) {
        Player player = new Player();
        player.addCard(new Card("10", "♠"));
        player.addCard(new Card("J", "♠"));
        player.addCard(new Card("10", "♠"));
        player.addCard(new Card("J", "♠"));
        player.addCard(new Card("10", "♠"));
        player.addCard(new Card("J", "♠"));
        player.getAllCards().addAll(player.getHand());
        ArrayList<Integer>freq = player.findRankingFrequency();
        
        System.out.println(freq);
        boolean bool = player.containsTarget(freq,3);
        System.out.println(bool);
       //Deck deck = new Deck();
       //deck.play();
    }
}