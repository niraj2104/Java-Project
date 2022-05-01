// create a package
package com.mycompany.finalprojectjava;

/**Application Purpose: Final Project
* Author: Niraj Patel(200507909)
* Date: 13/04/2022
* Time: 9 am
*/

// import statements
import gameproject.FinalProject;
import java.util.*;

// create a class that contains main method
public class FinalProjectTestHarness {
    
    // declare a variable
    static String invalidInput = "Invalid Input";
    
    // declare main method
    public static void main(String[] args) {
        // Initializing  object
        FinalProject finalProject = new FinalProject();
        
        // create a scanner object
        Scanner scanner = new Scanner(System.in);
        
        //initial output
        finalProject.welcomeMethod();
        
        char inputCharacter = 'y';
        
        // calling game function
        finalProject.playGame(scanner);
        
        // if user want to play again.
        while (inputCharacter == 'y'){
            // player input
            inputCharacter = scanner.nextLine().toLowerCase().charAt(0); 
            while (inputCharacter != 'y' && inputCharacter != 'n')
            {
                System.out.println(invalidInput);
                System.out.print("Play another game? [ Y / N ]: ");
                // player input
                inputCharacter = scanner.nextLine().toLowerCase().charAt(0); 
            }
            // if player select 'n' than it will end the game
            if (inputCharacter == 'n')
                continue;
            System.out.println("\nLet's play again...\n");
                finalProject.playGame(scanner);
            }
            // end game message
            System.out.print("\nGame ending...");
            // end program
            scanner.close();
            System.out.print("\nThank You for Playing.");
   
    }
    
}
