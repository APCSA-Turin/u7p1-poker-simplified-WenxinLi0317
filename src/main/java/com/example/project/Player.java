package com.example.project;
import java.util.ArrayList;


public class Player{
    private ArrayList<Card> hand;
    private ArrayList<Card> allCards; //the current community cards + hand
    String[] suits  = Utility.getSuits();
    String[] ranks = Utility.getRanks();
    
    public Player(){
        hand = new ArrayList<>();
    }

    public ArrayList<Card> getHand(){return hand;}
    public ArrayList<Card> getAllCards(){return allCards;}

    public void addCard(Card c){
        
    }

    public String playHand(ArrayList<Card> communityCards){      

        return "Nothing";
    }

    public void SortCards(){} 

    public ArrayList<Integer> findRankingFrequency(){
        ArrayList<Integer>freq = new ArrayList<>();
        //"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"]
        //
        for(int j = 0; j < 13; j++)
        {
            for(int i = 0; i < ranks.length; i++)
            {
                if(allCards.contains(ranks[i]))
                {
    
                }
            }
        }
        

        return new ArrayList<>(); 
    }

    public ArrayList<Integer> findSuitFrequency(){
        return new ArrayList<>(); 
    }

   
    @Override
    public String toString(){
        return hand.toString();
    }




}
