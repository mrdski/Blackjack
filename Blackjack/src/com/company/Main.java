package com.company;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        int totalGames = 1;     // Declaring and initializing all the variables
        int numWins = 0;
        int numTies = 0;
        int numLoses = 0;
        double winPercent = numWins / totalGames;
        String newCard;
        Scanner input = new Scanner(System.in);     //Adding the Scanner from the import
        P1Random rng = new P1Random();              //Adding the variable rng from the class P1Random
        boolean keepPlaying = false;
        while(keepPlaying == false) {       // While loop on the condition that the player is going to continue playing
            System.out.println("START GAME #" + totalGames + "\n");
            int playerTotal = 0;
            boolean GameEnd = false;
            while(GameEnd == false) {       // While loop on the condition that a specific game is over
                int myNumber = rng.nextInt(13)+1;       // Variable using rng to generate a random number 1-13
                if(myNumber == 1) {                                         // Multiple if statements to determine the
                    newCard = "ACE";                                        // actual card that is drawn based on the
                    playerTotal = playerTotal + 1;                          // random number from myNumber
                    System.out.println("Your card is a " + newCard + "!");
                    System.out.println("Your hand is: " + playerTotal);
                }
                else if(myNumber == 11) {
                    newCard = "JACK";
                    playerTotal = playerTotal + 10;
                    System.out.println("Your card is a " + newCard + "!");
                    System.out.println("Your hand is: " + playerTotal);
                }
                else if(myNumber == 12) {
                    newCard = "QUEEN";
                    playerTotal = playerTotal + 10;
                    System.out.println("Your card is a " + newCard + "!");
                    System.out.println("Your hand is: " + playerTotal);
                }
                else if(myNumber == 13) {
                    newCard = "KING";
                    playerTotal = playerTotal + 10;
                    System.out.println("Your card is a " + newCard + "!");
                    System.out.println("Your hand is: " + playerTotal);
                }
                else {
                    playerTotal = playerTotal + myNumber;
                    System.out.println("Your card is a " + myNumber + "!");
                    System.out.println("Your hand is: " + playerTotal);
                }
                System.out.println();
                if(playerTotal == 21) {                             // If statements to the end game or continue drawing
                    System.out.println("BLACKJACK! You win!");      // based on your total amount of point in playerTotal
                    numWins++;
                    GameEnd = true;
                }
                else if(playerTotal > 21) {
                    System.out.println("You exceeded 21! You lose.");
                    numLoses++;
                    GameEnd = true;
                }
                else{
                    boolean repeat = false;
                    while(repeat == false){     // While loop on the condition that the player's input will continue with the game
                        System.out.println("1. Get another card \n2. Hold hand \n3. Print statistics \n4. Exit \n");
                        System.out.print("Choose an option: ");
                        int choice = input.nextInt();
                        System.out.println();
                        if(choice == 1) {               // If statements for each input the player can choose
                            repeat = true;
                        }
                        else if(choice == 2) {
                            int dealerHand = rng.nextInt(11)+16;        // Variable using rng to create a number 16-26
                            System.out.println("Dealer's hand: " + dealerHand + "\nYour hand is: " + playerTotal + "\n");
                            if(playerTotal > dealerHand){
                                System.out.println("You Win!");                 // If statements which print something
                                numWins++;                                      // based on the dealer's hand in
                            }                                                   // comparison to the player's hand
                            else if(playerTotal == dealerHand){
                                System.out.println("It's a tie! No one wins!");
                                numTies++;
                            }
                            else{
                                System.out.println("Dealer wins!");
                                numLoses++;
                            }
                            System.out.println();
                            GameEnd = true;
                            repeat = true;
                        }
                        else if(choice == 3) {      // Prints the stats using the variables and resets the loop
                            System.out.println("Total Games: " + totalGames + "\nPlayer Wins: " + numWins + "\nDealer Wins: " + numLoses + "\nTies: " + numTies + "\nWin Percentage: " + winPercent + "\n");
                        }
                        else if(choice == 4) {      // When the player is done playing and wants to end the program
                            repeat = true;
                            GameEnd = true;
                            keepPlaying = true;
                        }
                        else{       // Print this statement and reset the loop because there was no input that did anything
                            System.out.println("Invalid input! \nPlease enter an integer value between 1 and 4.\n");
                        }
                    }
                }
            }
            totalGames++;
        }
    }
}
