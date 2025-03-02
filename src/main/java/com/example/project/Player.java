package com.example.project;
import java.util.ArrayList;
import java.util.Collections;

public class Player{
    private ArrayList<Card> hand; 
    // list to store the player's hand of cards
    private ArrayList<Card> allCards; 
    // ist to store all cards (hand + community cards)
    String[] suits  = Utility.getSuits(); 
    // array holding the suit names 
    String[] ranks = Utility.getRanks(); // array holding the rank names 
    
    // constructor to initialize hand and allCards as empty lists
    public Player(){
        hand = new ArrayList<>();
        allCards = new ArrayList<>();
    }

    // getter method for hand 
    public ArrayList<Card> getHand(){ return hand; }

    // getter method for all cards 
    public ArrayList<Card> getAllCards(){ return allCards; }

    // method to add a card tohand
    public void addCard(Card c){
        hand.add(c);
    }

    // method to evaluate hand based on the community cards
    public String playHand(ArrayList<Card> communityCards){    
       // Clear allCards before adding new cards
    allCards.clear();

    // Combine hand and community cards into allCards
    allCards.addAll(hand);
    allCards.addAll(communityCards);

    // Get the frequency of suits and ranks in allCards
    ArrayList<Integer> suitsFrequency = findSuitFrequency();
    ArrayList<Integer> rankfreq = findRankingFrequency();

    // Check for flush
    boolean flush = suitsFrequency.contains(5) || suitsFrequency.contains(6) || suitsFrequency.contains(7);

    // Check for straight and royal flush
    boolean straight = false;
    boolean royal = false;
    int consecutiveNum = 1;

        // Sort all cards by their rank value to check for consecutive numbers
    sortAllCards();
        

        // list of sorted ranks 
        ArrayList<Integer> sortedRanks = new ArrayList<>();
        for (Card card : allCards) {
            sortedRanks.add(Utility.getRankValue(card.getRank())); // convert card rank to its integer value
        }

        // check for a straight 
        for (int i = 1; i < sortedRanks.size(); i++) {
            if (sortedRanks.get(i) == sortedRanks.get(i - 1) + 1) {
                consecutiveNum++; // increment the consecutive num
                if (consecutiveNum >= 5) {
                    straight = true; // True if a straight is found

                    // Check if the straight includes an Ace
                    if (sortedRanks.get(i) == 14) { 
                        royal = true; //true if it is a Royal Flush
                        break; 
                    }
                }
            } else if (sortedRanks.get(i) != sortedRanks.get(i - 1)) {
                consecutiveNum = 1; // reset the consecutive count if consective streak is broken
            }
        }

        // return the hand based on the best hand found
        if (royal && flush) 
            return "Royal Flush"; // royal Flush is the highest possible hand
        if (flush && straight) 
            return "Straight Flush"; // straight Flush is a straight and flush combined
        if (rankfreq.contains(4)) 
            return "Four of a Kind"; // four card of the same rank
        if (rankfreq.contains(3) && rankfreq.contains(2)) 
            return "Full House"; // three of a kind amd a pair
        if (flush)
            return "Flush"; // five cards of the same suit
        if (straight)
            return "Straight"; // five consecutive cards of any suit
        if (rankfreq.contains(3))
            return "Three of a Kind"; // Three cards of the same rank
        if (Collections.frequency(rankfreq, 2) >= 2)
            return "Two Pair"; // wwo pairs of cards of the same rank
        if (rankfreq.contains(2))
            return "A Pair"; // a single pair of cards of the same rank
        if (communityCards.contains(allCards.get(allCards.size() - 1)))
            return "Nothing"; // if no valid hand is found, return "Nothing"
        return "High Card"; // if no valid hands, return "High Card"
    }

    // method to sort all cards in ascending order based on their rank values
    public void sortAllCards()
    {
        for(int i = 0; i < allCards.size()-1; i++)
        {
            //selective sort need min
            int min = i;
            for(int j = i+1; j < allCards.size(); j++)
            {
                // compare the rank values of the cards and find the minimum 
                if(Utility.getRankValue(allCards.get(min).getRank()) > Utility.getRankValue(allCards.get(j).getRank()))
                {
                    min = j; // update min index if a smaller rank is found
                }
            }
            // swap the cards to sort them by rank
            Card temp = allCards.get(i);
            allCards.set(i, allCards.get(min));
            allCards.set(min, temp);
        }
    }
    //helper method for sort hands
    public void sortCards()
    {
        for(int i = 0; i < hand.size()-1; i++)
        {
            //selective sort need min
            int min = i;
            for(int j = i+1; j < hand.size(); j++)
            {
                // compare the rank values of the cards and find the minimum 
                if(Utility.getRankValue(hand.get(min).getRank()) > Utility.getRankValue(hand.get(j).getRank()))
                {
                    min = j; // update min index if a smaller rank is found
                }
            }
            // swap the cards to sort them by rank
            Card temp = hand.get(i);
            hand.set(i, hand.get(min));
            hand.set(min, temp);
        }
    }
    // method to find the frequency of each rank in the hand
    public ArrayList<Integer> findRankingFrequency(){
        ArrayList<Integer> freq = new ArrayList<>(13);
        for (int i = 0; i < 13; i++) {
            freq.add(0);  // Initialize with 0
        }
        // count the frequency of each rank in the allCards list
        for(int j = 0; j < allCards.size(); j++)
        {
            for(int i = 0; i < 13; i++)
            {
                if(allCards.get(j).getRank().equals(ranks[i]))
                {
                    freq.set(i, freq.get(i)+1); // increment the frequency count for the rank
                }
            }
        }
        return freq; 
    }

    //mMethod to find the frequency of each suit in the hand 
    public ArrayList<Integer> findSuitFrequency(){
        ArrayList<Integer> freq = new ArrayList<>(4);
        for (int i = 0; i < 4; i++) {
            freq.add(0);  // Initialize with 0
        }
        // count the frequency of each suit in the allCards list
        for(int j = 0; j < allCards.size(); j++)
        {
            for(int i = 0; i < 4; i++)
            {
                if(allCards.get(j).getSuit().equals(suits[i]))
                {
                    freq.set(i, freq.get(i)+1); // Increment the frequency count for the suit
                }
            }
        }
        return freq; // Return the frequency list for suits
    }

    
    @Override
    public String toString(){
        return hand.toString(); // Return a string representation of the player's hand
    }
}
