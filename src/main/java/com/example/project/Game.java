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
        
        

        /* 
        if(Utility.getHandRanking(p1Hand)> Utility.getHandRanking(p2Hand))
        {
            return "Player 1 wins!";
        }
        else if( Utility.getHandRanking(p1Hand) < Utility.getHandRanking(p2Hand))
        {
            return "Player 2 wins!";
        }
    */
        /* 
        else{
            int ranking = Utility.getHandRanking(p1Hand);
            p1.playHand(communityCards);
            p2.playHand(communityCards);
            switch (ranking) {
                case 1:
                    return "Tie!";
            
                case 2:
                int p1HighCard = getHighest(p1.getAllCards());
                int p2HighCard = getHighest(p2.getAllCards());
                if (p1HighCard > p2HighCard) {
                    return "Player 1 wins!";
                } else if (p1HighCard < p2HighCard) {
                    return "Player 2 wins!";
                }
                    break;

                case 3:
                    
                    ArrayList<Integer> p1freq = p1.findRankingFrequency();
                    ArrayList<Integer> p2freq = p2.findRankingFrequency();
                    int max1 = 0;
                    for(int i = 0; i < p1freq.size();i++)
                    {
                        if(p1freq.get(i)==2)
                        {
                            max1 = i;
                            break;
                        }
                    }
                    int max2 = 0;
                    for(int i = 0; i < p2freq.size();i++)
                    {
                        if(p2freq.get(i)==2)
                        {
                            max2 = i;
                            break;
                        }
                    }
                    if(max1>max2){
                        return "Player 1 wins!";
                    }else if(max2>max1){
                        return "Player 2 wins!";
                    }else{
                        break;
                    }

                    
                    
                
                case 4:
                    
                    break;
                case 5:
                    
                    break;   
                case 6:
                    
                    break;   
                case 7:
                    
                    break;   
                case 8:
                    
                    break;   
                case 9:
                    
                    break;   
                case 10:
                    
                    break;   
                case 11:
                    
                    break;
            }
            return "Tie!";
        }
        
    }
*/
    
}
private static int getHighest(ArrayList<Card> hand) {
    int highest = 0;
    for (Card card : hand) {  // loop through all cards in the hand
        int rankValue = Utility.getRankValue(card.getRank());  // get rank value of each card
        if (rankValue > highest) {  // if the card's rank is higher than the current highest
            highest = rankValue;  // update the highest card rank
        }
    }
    return highest;  // return the highest card rank
    
}
    public static void play(){ //simulate card playing
    
    }
        
        

}
