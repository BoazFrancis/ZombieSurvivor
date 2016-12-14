import java.util.Arrays;

public class Main {
  
  private static void playTurn(Turn turn) {
    boolean drawAgain = true;
    System.out.println("Player: " + turn.getCurrentPlayer());
    while (drawAgain) {
      Outcome[] outcomes = turn.drawAndGetOutcomes();
      if (outcomes.length == 0) {
        System.out.println("_____________________________________");
        System.out.println("The population has been exceeded.");
        System.out.println("_____________________________________");
        break;
      }
      System.out.println(turn.toString());
      if (turn.hasBeenBittenTooManyTimes()) {
        System.out.println("_____________________________________");
        System.out.println("You have been bitten too many times!");
        System.out.println("_____________________________________");
        break;
      }
      System.out.println("Please enter 1 to draw again, or 2 to score: ");
      if (IOUtil.readInt() == 2) {
        drawAgain = false;
      }
    }
  }

  public static void main(String[] args) {
    System.out.println("Welcome to ZombieSurvivor!");
    System.out.println("=============================================");
    System.out.println("How many survivors?");
    int numOfPlayers = IOUtil.readInt();
    ZombieSurvivor game = new ZombieSurvivor(numOfPlayers);
    while (!game.isGameOver()) {
      Turn turn = game.startPlayerTurn();
      playTurn(turn);
      game.scorePlayerTurn(turn);
      System.out.println("_____________________________________");
      System.out.println("Current scores: " + game.toString());
      System.out.println("_____________________________________");
      game.nextPlayer();
    }
    int winningPlayer = game.getWinningPlayer();
    System.out.println("The winner is player: " + winningPlayer);
    System.out.println("Current scores: " + game.toString());
  }
}
