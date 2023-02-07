import java.util.Scanner;

//creates user interface
public class SpiceMixologistCli{
  //prompts for user spice mix suggestion until it is correct
  public static SpiceMixGame playGame(SpiceMixGame Game){
    boolean endOfGame = false;
    //while game not finished,
    while (endOfGame== false){
      System.out.println("Previous attempts:");
      if (Game.getPreviousAttempts() == null){
        System.out.println("No previous attempts");
      }
      else{
        System.out.println(Game.getPreviousAttempts());
      }
      //prompt for spice mix suggestion and extract the characters
      System.out.println("Enter spice mix:");
      Scanner scanner = new Scanner(System.in);
      String spicesIn = scanner.nextLine();
      char[] spices = {spicesIn.charAt(0), spicesIn.charAt(2),spicesIn.charAt(4),spicesIn.charAt(6),spicesIn.charAt(8)};
      //check if inputs are of valid spice(character)
      boolean validInput = true;
      for (int i=0; i<spices.length; i++){
        switch (spices[i]){
          case 'N' : break;
          case 'O' : break;
          case 'P' : break;
          case 'Q' : break;
          case 'R' : break;
          case 'S' : break;
          case 'T' : break;
          default: validInput=false;
            System.out.println("Invalid spice mix!");
            break;
        }
      }
      //if input is valid, make it a new suggestion
      if (validInput){
        SpiceMix suggestion = new SpiceMix(spices);
        //ends game if suggestion is correct
        endOfGame = Game.attemptSpiceMix(suggestion);
      }
    }

    System.out.println("Congratulations!");
    return Game;
  }
  //main method takes in input and passes it to play the game
  public static void main(String[] args){
    SpiceMixGame Game = new SpiceMixGame();
    playGame(Game);
  }
}
