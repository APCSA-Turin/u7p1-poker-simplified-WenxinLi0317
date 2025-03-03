package com.example.project;
import java.util.ArrayList;

/*“Player 1 wins!”
“Player 2 wins!”
“Tie!”
 */
public class Game{
    public static String determineWinner(Player p1, Player p2,String p1Hand, String p2Hand,ArrayList<Card> communityCards){
        int p1Score = Utility.getHandRanking(p1Hand);  // get player 1's hand ranking
        int p2Score = Utility.getHandRanking(p2Hand);  // get player 2's hand ranking

        if (p1Score > p2Score)  // if player 1 has a higher ranking hand
        {  
            return "Player 1 wins!";
        } 
        else if (p1Score < p2Score)  // if player 2 has a higher ranking hand
        {
            return "Player 2 wins!";
        } 

        else{
            ArrayList<Card> p1Cards = p1.getHand();  // get player 1's hand
            ArrayList<Card> p2Cards = p2.getHand();  // get player 2's hand
            p1.sortCards();  // sort player 1's hand
            p2.sortCards();  // sort player 2's hand
            Card p1HighestCard = p1Cards.get(p1Cards.size() - 1);  // get player 1's highest card
            Card p2HighestCard = p2Cards.get(p2Cards.size() - 1);  // get player 2's highest card
    
            int p1Highest = Utility.getRankValue(p1HighestCard.getRank());  // get rank value of player 1's highest card
            int p2Highest = Utility.getRankValue(p2HighestCard.getRank());  // get rank value of player 2's highest card
    
            
            if (p1Highest < p2Highest)  // if player 2 has the higher card
            {
                return "Player 2 wins!";
            }
            else if (p1Highest > p2Highest)  // if player 1 has the higher card
            {
                return "Player 1 wins!";
            }
    
            return "Tie!";  // if both players have the same highest card
        }
        
    
}

    public static void play(){ //simulate card playing
    
    }
        
        

}
