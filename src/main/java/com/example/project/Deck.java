package com.example.project;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Deck{
    private ArrayList<Card> cards;

        private int win1 = 0;
         private int win2 = 0;
         private int round = 1;
         private Game game = new Game();
         private int num = -1;
         Scanner scan = new Scanner(System.in);

    public Deck(){
        cards = new ArrayList<>();
        initializeDeck();
        shuffleDeck();
    }

    public ArrayList<Card> getCards(){
        return cards;
    }

    public void initializeDeck(){ //hint.. use the utility class
        String [] ranks = Utility.getRanks();
        String [] suits = Utility.getSuits();
        for(int i = 0; i < ranks.length; i++)
        {
            for (int j = 0; j < suits.length; j++)
            {
                cards.add(new Card(ranks[i],suits[j]));
            }
        }

    }

    public  void shuffleDeck(){ //You can use the Collections library or another method. You do not have to create your own shuffle algorithm
        Collections.shuffle(getCards());
    }

    public Card drawCard(){
        if(cards!= null)
        {
            return cards.remove(0);
        }

       return null;
    }

    public  boolean isEmpty(){
        return cards.isEmpty();
    }



    public void play()
    {
        /*- Create a UI that allows users to interact with the game. This could be a command-line interface or a graphical interface.
   - The UI should allow players to:
     - Start the game.
     - View the players hand and community cards 
     - See the results of each round and determine who is the winner  */
        while (num != 2){
            System.out.println("Welcome to Poker Game");
            System.out.println("To play, enter 1");
            System.out.println("To quit, enter 2");
            num = scan.nextInt();
            scan.nextLine();
            if(num == 2)
            {
                System.out.println("Thank you for PLaying Poker Game!");
                break;
            }else if (num != 1 && num != 2){
                System.out.println("This is not valid number!");
            }else{
                System.out.println("Game Started!");
                playGame();
                
            }
        }
        
         


    }


    public void playGame()
    {
                Player player1 = new Player();
                Player player2 = new Player();
                
                Deck deck = new Deck();
                ArrayList<Card>thisCard = getCards();
                
                for (int i = 0; i < 2; i++)  
                { 
                // generating the index using Math.random() 
                    int index = (int)(Math.random() * thisCard.size()); 
        
                    Card card1 = thisCard.get(index);
                    System.out.println("Player 1 Hands is :" + card1); 
                    player1.addCard(card1);
                    thisCard.remove(card1);
                } 
                for (int i = 0; i < 2; i++)  
                { 
                // generating the index using Math.random() 
                    int index = (int)(Math.random() * thisCard.size()); 
        
                    Card card1 = thisCard.get(index);
                    System.out.println("Player 2 Hands is :" + card1); 
                    player2.addCard(card1);
                    thisCard.remove(card1);
                } 
                ArrayList<Card> communityCards = new ArrayList<>();
                for (int i = 0; i < 3; i ++)
                {
                    int index = (int)(Math.random() * thisCard.size()); 
        
                    Card community = thisCard.get(index);
                    System.out.println("Community Card is :" + community); 
                    communityCards.add(community);
                    thisCard.remove(community);
                }
                
                String p1Result = player1.playHand(communityCards);
                String p2Result = player2.playHand(communityCards);
                
                String winner = Game.determineWinner(player1, player2, p1Result, p2Result, communityCards);

                System.out.println("Round:" + round);
                System.out.println("Player 1 got: "+ p1Result);
                System.out.println("Player 2 got: "+ p2Result);
                if(winner.equals("Tie!")){
                    System.out.println("It's a Tie!");
                }
                else{
                    System.out.println(winner + " Because they have a higher hand!");
                }
                System.out.println("Do you want to play again?");
                String answer = scan.nextLine();
                if(answer.equals("no") || answer.equals("No") ){
                    System.out.println("Thank you for playing!");
                    num = 2;
                }
                else{
                    round++;
                    playGame();
                }
                
    }

   


}