package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

// Import the Ai class

/** This class represents the Game is the main entry point. */
public class Game {

  private int roundNumber;
  private String playerName;
  private Choice playerChoice;
  private Ai ai;

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    // the first element of options[0]; is the name of the player
    this.playerName = options[0];
    this.roundNumber = 1;
    this.ai = new Ai(difficulty);
    this.playerChoice = choice;
    MessageCli.WELCOME_PLAYER.printMessage(playerName);
  }

  public void play() {

    MessageCli.START_ROUND.printMessage(String.valueOf(roundNumber));
    roundNumber++;

    MessageCli.ASK_INPUT.printMessage();
    String playerInput = Utils.scanner.nextLine();

    // Keep checking if the input is one integer between 0 and 5 until it is
    while (!playerInput.matches("[0-5]")) {
      MessageCli.INVALID_INPUT.printMessage();
      playerInput = Utils.scanner.nextLine();
    }

    int playerNumber = Integer.parseInt(playerInput);
    int aiNumber = ai.play();
    int sum = playerNumber + aiNumber;

    MessageCli.PRINT_INFO_HAND.printMessage(playerName, playerInput);
    MessageCli.PRINT_INFO_HAND.printMessage(ai.getAiName(), String.valueOf(aiNumber));

    getResults(sum);
  }

  private void getResults(int sum) {
    if (Utils.isEven(sum)) {
      if (playerChoice.equals(Choice.EVEN)) {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(String.valueOf(sum), "EVEN", playerName);
      } else {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(String.valueOf(sum), "OOD", ai.getAiName());
      }
    } else if (Utils.isOdd(sum)) {
      if (playerChoice.equals(Choice.ODD)) {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(String.valueOf(sum), "ODD", playerName);
      } else {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(String.valueOf(sum), "EVEN", ai.getAiName());
      }
    }
  }

  public void endGame() {}

  public void showStats() {}
}
