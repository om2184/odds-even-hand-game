package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {

  private int roundNumber = 1;
  private String playerName;

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    // the first element of options[0]; is the name of the player
    this.playerName = options[0];
    MessageCli.WELCOME_PLAYER.printMessage(playerName);
  }

  public void play() {
    MessageCli.START_ROUND.printMessage(String.valueOf(roundNumber));
    roundNumber++;

    MessageCli.ASK_INPUT.printMessage();
    String input = Utils.scanner.nextLine();

    // Keep checking if the input is one integer between 0 and 5 until it is
    while (!input.matches("[0-5]")) {
      MessageCli.INVALID_INPUT.printMessage();
      input = Utils.scanner.nextLine();
    }

    MessageCli.PRINT_INFO_HAND.printMessage(playerName, input);
  }

  public void endGame() {}

  public void showStats() {}
}
