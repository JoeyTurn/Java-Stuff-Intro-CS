/**  Joey Turnbull
  *  02/11/2020
  *  CSE142
  *  TA: Esther Chien
  *  Assignment #5
  *
  *  This program asks the user to guess a number between 1 and MAXIMUM, and repeats until he/she
  *  correctly guesses the number. The user is then prompted if he/she wants to play again. 
  *  Lastly, the user is shown his/her statistics while playing the game.*/

//for Random, Math
import java.util.*;
  
public class GuessingGame {

   //class constant
   public static final int MAXIMUM = 100;
   
   //main method, prints haiku, then plays a game until a player guesses the correct number
   //if the player wishes to play again, they may respond with anything starting with 'y'
   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      Random rand = new Random();
      
      //les variables
      String playAgain;
      int plays = 0;
      int totalGuesses = 0;
      int guesses;
      int bestGuesses = 1000000;
      
      haiku();
      
      do {
         plays++;
         guesses = guessNum(in, rand);
         totalGuesses += guesses;
         bestGuesses = Math.min(guesses, bestGuesses);

         System.out.print("Do you want to play again? ");
         playAgain = in.next(); //it wouldn't let me .charAt after next()
         System.out.println();
      } while (Character.toUpperCase(playAgain.charAt(0)) == 'Y');
      
      gameEnd(plays, totalGuesses, bestGuesses);
   }
   
   //prints the haiku which signifies the start of the program
   public static void haiku() {
      System.out.println("Numbers Incorrect, ");
      System.out.println("Try again, until it's right, ");
      System.out.println("At last, victory.");
      System.out.println();
   }
   
   //the actual game, in is the System's keyboard to get inputs, rand is to make the random int
   //returns the number of guesses it took for the player to get the right answer
   public static int guessNum(Scanner in, Random rand) {
      //this is the only place Random is needed, so I only make an obj here and not in main
      //nevermind, output compare tool no likey
      
      //string es is just in case the user gets num first try
      String es = "es";
      //myNum is the number the player is trying to guess; randomly generated
      int myNum = rand.nextInt(MAXIMUM)+1;
      int yourGuess;
      int guesses = 0;
      
      System.out.printf("I'm thinking of a number between 1 and %d...\n", MAXIMUM);
      do {
         guesses++;
         System.out.print("Your guess? ");
         yourGuess = in.nextInt();
         
         if (myNum < yourGuess) {
            System.out.println("It's lower.");
         } else if (myNum > yourGuess) {
            System.out.println("It's higher.");
         }
      } while (yourGuess != myNum);
      
      //checks if user gets it right the first time, changes message below if true
      if (guesses == 1) {
         es = "";
      }
      
      System.out.printf("You got it right in %d guess%s!\n", guesses, es);
      
      return (int) guesses;
   }
   
   //prints out the statistics after the user has signified the end of the game
   //totalGames is the num of games they play, totalGuesses is the amount of guesses they made,
   //bestGame is the lowest amount of guesses the player achieved
   public static void gameEnd(int totalGames, int totalGuesses, int bestGuesses) {
      System.out.println("Overall results:");
      System.out.printf("Total games   = %d\n", totalGames);
      System.out.printf("Total guesses = %d\n", totalGuesses);
      System.out.printf("Guesses/game  = %.1f\n", (double)totalGuesses/totalGames);
      System.out.printf("Best game     = %d\n", bestGuesses);
   }
}