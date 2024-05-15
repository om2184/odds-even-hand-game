package nz.ac.auckland.se281;

import java.util.ArrayList;
import java.util.List;
import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

// Import the Ai class

/** This class represents the Game is the main entry point. */
public class Game {

  private boolean gameRunning;
  private int roundNumber;
  private int previousRoundAi;
  private int playerWins;
  private int aiWins;
  private String playerName;
  private List<Integer> playerHistory;
  private Choice playerChoice;
  private AiDifficulty ai;

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {

    this.gameRunning = true;
    this.playerName = options[0];
    this.ai = AiFactory.createAi(difficulty, choice);
    this.playerChoice = choice;
    this.roundNumber = 1;
    this.playerHistory = new ArrayList<>();
    this.playerWins = 0;
    this.aiWins = 0;
    this.previousRoundAi = -1;

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
    MessageCli.PRINT_INFO_HAND.printMessage(ai.getAiName(), String.valueOf(aiNumber));

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
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(String.valueOf(sum), "ODD", ai.getAiName());
        aiWins++;
        return 1;
      }
    } else if (playerChoice.equals(Choice.ODD)) {
      if (Utils.isOdd(sum)) {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(String.valueOf(sum), "ODD", playerName);
        playerWins++;
        return 0;
      } else {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(String.valueOf(sum), "EVEN", ai.getAiName());
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
      MessageCli.PRINT_END_GAME.printMessage(ai.getAiName());
    } else {
      MessageCli.PRINT_END_GAME_TIE.printMessage();
    }
    gameRunning = false;
  }

  public void showStats() {
    if (!gameRunning) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }

    MessageCli.PRINT_PLAYER_WINS.printMessage(
        playerName, String.valueOf(playerWins), String.valueOf(aiWins));
    MessageCli.PRINT_PLAYER_WINS.printMessage(
        ai.getAiName(), String.valueOf(aiWins), String.valueOf(playerWins));
  }
}
