package nz.ac.auckland.se281;

import java.util.ArrayList;
import java.util.List;
import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

// Import the Ai class

/** This class represents the Game is the main entry point. */
public class Game {

  private int roundNumber;
  private String playerName;
  private Choice playerChoice;
  private AiDifficulty ai;
  private List<Integer> playerHistory;
  private String aiName = "HAL-9000";
  private int previousRoundAi;
  private boolean gameRunning;
  private int playerWins;
  private int aiWins;

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {

    this.playerName = options[0];
    this.roundNumber = 1;
    this.ai = AiFactory.createAi(difficulty, choice);
    this.playerChoice = choice;
    this.playerHistory = new ArrayList<>();
    this.gameRunning = true;

    MessageCli.WELCOME_PLAYER.printMessage(playerName);
  }

  public void play() {

    if (!gameRunning) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }

    MessageCli.START_ROUND.printMessage(String.valueOf(roundNumber));

    MessageCli.ASK_INPUT.printMessage();
    String playerInput = Utils.scanner.nextLine();

    // Keep checking if the input is one integer between 0 and 5 until it is
    while (!playerInput.matches("[0-5]")) {
      MessageCli.INVALID_INPUT.printMessage();
      playerInput = Utils.scanner.nextLine();
    }

    int playerNumber = Integer.parseInt(playerInput);
    int aiNumber = ai.strategyUsed(roundNumber, playerHistory, previousRoundAi);
    int sum = playerNumber + aiNumber;

    MessageCli.PRINT_INFO_HAND.printMessage(playerName, playerInput);
    MessageCli.PRINT_INFO_HAND.printMessage(aiName, String.valueOf(aiNumber));

    previousRoundAi = getResults(sum);
    playerHistory.add(playerNumber);
    roundNumber++;
  }

  private int getResults(int sum) {

    if (playerChoice.equals(Choice.EVEN)) {
      if (Utils.isEven(sum)) {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(String.valueOf(sum), "EVEN", playerName);
        playerWins++;
        return 0;
      } else {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(String.valueOf(sum), "OOD", aiName);
        aiWins++;
        return 1;
      }
    } else if (playerChoice.equals(Choice.ODD)) {
      if (Utils.isOdd(sum)) {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(String.valueOf(sum), "ODD", playerName);
        playerWins++;
        return 0;
      } else {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(String.valueOf(sum), "EVEN", aiName);
        aiWins++;
        return 1;
      }
    } else {
      return -1;
    }
  }

  public void endGame() {
    showStats();
    if (playerWins > aiWins) {
      MessageCli.PRINT_END_GAME.printMessage(playerName);
    } else if (playerWins < aiWins) {
      MessageCli.PRINT_END_GAME.printMessage(aiName);
    } else {
      MessageCli.PRINT_END_GAME_TIE.printMessage();
    }
  }

  public void showStats() {}
}
