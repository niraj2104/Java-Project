
package gameproject;



/**Application Purpose: Final Project
* Author: Niraj Patel(200507909)
* Date: 13/04/2022
* Time: 9 am
*/

// import statemnets
import java.util.Random;
import java.util.Scanner;

// create a blueprint class called FinalProject
public class FinalProject {
    
    // declare all variables
    private String wonMessage = "You won this round";
    private String lostMessage = "You lost this round";
    private String tieMessage = "Tied";
    private String invalidInput = "Invalid Input";

    // create a default constructor
    public FinalProject() {
    }
    
    
    // create a welcome method for game 
    public void welcomeMethod(){
        System.out.println("ROCK, PAPER, SCISSORS");
        System.out.println("Enter one of these to throw down:");
        System.out.println("[R] Rock");
        System.out.println("[P] Paper");
        System.out.println("[S] Scissors");
        System.out.println("[Q] Quit and view final statistics\n");
    }
    
    
    // create a playgame method (this method is heart of the game)
    public void playGame(Scanner scanner){
        // declarations
        char inputCharacter = 0, playerTwoThrow;
        int round = 0;
        int currentStatus, playerOneWin = 0, playerTwoWin = 0, ties = 0;
        // gameplay
        while (inputCharacter != 'q'){
            inputCharacter = 0;
            while (inputCharacter == 0){
                System.out.print("Rock-Paper-Scissors, THROW! r/p/s/q -> "); // round prompt
                inputCharacter = scanner.nextLine().toLowerCase().charAt(0); 

                //player input
                if (inputCharacter != 'r' && inputCharacter != 'p' && inputCharacter != 's' && inputCharacter != 'q'){
                    inputCharacter = 0;
                    System.out.println(invalidInput);
                }
            }
            playerTwoThrow = generatePlayerTwoToss(); // P2 toss
            if (inputCharacter == 'q')
                continue;
            ++ round;
            currentStatus = checkThrow(inputCharacter, playerTwoThrow);
            ties += (currentStatus == 0 ? 1 : 0); // if game is a tie
            playerOneWin = playerOneWin + (currentStatus == 1 ? 1 : 0); // if player 1 (the player) wins
            playerTwoWin = playerTwoWin + (currentStatus == 2 ? 1 : 0); // if player 2 (the computer) wins
            printWinner(currentStatus); // print win, loss, tie...
            printStatistics(playerOneWin, playerTwoWin, ties, round); // print statistics
        }
        // end match
        finalStatistics(playerOneWin, playerTwoWin, ties, round); // print statistics
    }
    // this method will generate toss for plater two (computer)
    public char generatePlayerTwoToss(){
        // create a random object
        Random random = new Random();
        int randomNumber = random.nextInt(3);
        switch (randomNumber){
            case 0:
                return 'r';
            case 1:
                return 'p';
            case 2:
                return 's';
            default:
                return '?';
        }
    }
    
    
    // this method will check throw for both players
    public int checkThrow(char playerOneThrow, char playerTwoThrow){
        if (playerOneThrow == 'r'){
            switch (playerTwoThrow){
                case 'r':
                    return 0;
                case 'p':
                    return 2;
                case 's':
                    return 1;
                default:
                    return -1;
            }
        }
        else if (playerOneThrow == 'p'){
            switch (playerTwoThrow){
                case 'r':
                    return 1;
                case 'p':
                    return 0;
                case 's':
                    return 2;
                default:
                    return -1;
            }
        }
        else if (playerOneThrow == 's'){
            switch (playerTwoThrow){
                case 'r':
                    return 2;
                case 'p':
                    return 1;
                case 's':
                    return 0;
                default:
                    return -1;
            }
        }
    else return -1; // should never happen with proper input validation.
    }
    
    // this method will print winner of the round
    public void printWinner(int status){
        //System.out.print("figuring out the winner")
        if (status == 0){
            System.out.println(tieMessage);
        }
        else if (status == 1){
            System.out.println(wonMessage);
        }
        else if (status == 2){
            System.out.println(lostMessage );
        }
    }
    
    public void printStatistics(int playerOneWins, int playerTwoWins, int ties, int rounds){
        System.out.println("Round:"+rounds+" | P1 wins:"+playerOneWins+" | Computer wins:"+playerTwoWins+" | Ties:" +ties);
        System.out.println("**************************************************************");
    }
    
    public static void finalStatistics(int playerOneWins, int playerTwoWins, int ties, int rounds){
        
        
        
        System.out.println("\n***************************");
        System.out.println ("GAME STATISTICS");
        System.out.println("***************************");
        System.out.println("Player 1 wins:"+playerOneWins);
        System.out.println("Player 2 wins:"+playerTwoWins);
        System.out.println("Ties:"+ties);
        System.out.println("Rounds:"+ rounds);
        System.out.println("Play another game? [ Y / N ]: ");
    }



}
