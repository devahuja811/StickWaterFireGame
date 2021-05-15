import java.util.Random;

/* This class ecapsulates the state and logic required to play the 
   Stick, Water, Fire game. The game is played between a user and the computer. 
   A user enters their choice, either S for stick, F for fire, W for water, and 
   the computer generates one of these choices at random- all equally likely.
   The two choices are evaluated according to the rules of the game and the winner
   is declared.
   
   Rules of the game:
   S beats W
   W beats F
   F beats S
   no winner on a tie.
   
   Each round is executed by the playRound method. In addition to generating the computer 
   choice and evaluating the two choices, this class also keeps track of the user and computer
   scores, the number of wins, and the total number of rounds that have been played. In the case
   of a tie, neither score is updated, but the number of rounds is incremented.
   
   NOTE: Do not modify any of the code that is provided in the starter project. Additional instance variables and methods 
   are not required to make the program work correctly, but you may add them if you wish as long as
   you fulfill the project requirements.
   
*/
public class StickWaterFireGame {

   // TODO 1: Declare private instance variables here:
   private Random rand;
   private int playerScore;
   private int compScore;
   private int numRounds;
   private boolean playerWins;
   private boolean isTie;
   String computerChoice;
  
    
  /*  This constructor assigns the member Random variable, rand, to 
   *  a new, unseeded Random object.
   *  It also initializes the instance variables to their default values:
   *  rounds, player and computer scores will be 0, the playerWins and isTie
   *  variables should be set to false.
   */ 
   public StickWaterFireGame() {
   // TODO 2: Implement this method.
      rand = new Random();
      playerScore = 0;
      compScore = 0;
      numRounds = 0;
      playerWins = false;
      isTie = false;
   
   }
       
  /*  This constructor assigns the member Random variable, rand, to 
   *  a new Random object using the seed passed in.
   *  It also initializes the instance variables to their default values:
   *  rounds, player and computer scores will be 0, the playerWins and isTie
   *  variables should be set to false.
   */    
   public StickWaterFireGame(int seed) {
   // TODO 3: Implement this method.
      rand = new Random(8);
      playerScore = 0;
      compScore = 0;
      numRounds = 0;
      playerWins = false;
      isTie = false;
   }   

  /*  This method returns true if the inputStr passed in is
   *  either "S", "W", or "F", false otherwise.
   *  Note that the input can be upper or lower case.
   */ 
   public boolean isValidInput(String inputStr) {
   
   // TODO 4: Implement this method.
      if(inputStr.equalsIgnoreCase("s") || inputStr.equalsIgnoreCase("w") || inputStr.equalsIgnoreCase("f")){
         return true;
      }
      else 
         return false; 
   }
    
  /*  This method carries out a single round of play of the SWF game. 
   *  It calls the isValidInput method and the getRandomChoice method. 
   *  It implements the rules of the game and updates the instance variables
   *  according to those rules.
   */
   public void playRound(String playerChoice) {
   // TODO 12: Implement this method.
      computerChoice = getRandomChoice();
      if(isValidInput(playerChoice)){
         if(computerChoice.equalsIgnoreCase(playerChoice)){ 
         
            isTie = true;
            numRounds++;
         }
         if(computerChoice.equals("S") && playerChoice.equalsIgnoreCase("W")){
            compScore +=1;
            numRounds++;
         }
         if(computerChoice.equals("W") && playerChoice.equalsIgnoreCase("F")){
            compScore +=1;
            numRounds++;
         }
         if(computerChoice.equals("F") && playerChoice.equalsIgnoreCase("S")){
            compScore +=1;
            numRounds++;
         }
         if(computerChoice.equals("W") && playerChoice.equalsIgnoreCase("S")){
            playerScore +=1;
            numRounds++;
            playerWins = true;
         }
         if(computerChoice.equals("F") && playerChoice.equalsIgnoreCase("W")){
            playerScore +=1;
            numRounds++;
            playerWins = true;
         }
         if(computerChoice.equals("S") && playerChoice.equalsIgnoreCase("F")){
            playerScore +=1;
            numRounds++;
            playerWins = true;
         }
         
      }
      else {
         compScore +=1;
         numRounds++;
         
      }
   
   }
    
   // Returns the choice of the computer for the most recent round of play
   public String getComputerChoice(){
   // TODO 5: Implement this method.
      return computerChoice;
   }

   // Returns true if the player has won the last round, false otherwise.    
   public boolean playerWins(){
   // TODO 6: Implement this method.
      if(playerWins == true) 
         return true;
      else 
         return false;
   }
   
   // Returns the player's cumulative score.    
   public int getPlayerScore(){
   // TODO 7: Implement this method.
      return playerScore;
   }
   
   // Returns the computer's cumulative score.   
   public int getComputerScore(){
   // TODO 8: Implement this method.
      return compScore;
   }
   
   // Returns the total nuber of rounds played.   
   public int getNumRounds(){
   // TODO 9: Implement this method.
      return numRounds;
   }

   // Returns true if the player and computer have the same score on the last round, false otherwise.    
   public boolean isTie(){
   // TODO 10: Implement this method.
      if(playerScore == compScore) 
         return true;
      else 
         return false;
   }

  /*  This "helper" method uses the instance variable of Random to generate an integer
   *  which it then maps to a String: "S", "W", "F", which is returned.
   *  This method is called by the playRound method.
   */
   private String getRandomChoice() {
   // TODO 11: Implement this method.
      int choice = rand.nextInt(3);
      if(choice == 0) computerChoice = "S";
      else if(choice == 1) computerChoice = "W";
      else if (choice == 2) computerChoice = "F";
   
      return computerChoice;
   }
}
