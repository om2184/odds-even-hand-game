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

  /**
   * Starts a new game. The player is asked to input their name, the difficulty of the AI and the
   * choice of the player. The game is then started. All information from previous rounds are reset.
   *
   * @param difficulty The difficulty of the AI the player wants to play against
   * @param choice The choice of the player between odd or even
   * @param options The players name
   */
  public void newGame(Difficulty difficulty, Choice choice, String[] options) {

    this.gameRunning = true; // Game is now running
    this.playerName = options[0];
    this.ai = AiFactory.createAi(difficulty, choice); // Creates Ai based on difficulty wanted
    this.playerChoice = choice;
    this.roundNumber = 1; // Reset the round number
    this.playerHistory = new ArrayList<>(); // List to store the player's previous choosen numbers
    this.playerWins = 0;
    this.aiWins = 0;
    this.previousRoundAi = -1;

    MessageCli.WELCOME_PLAYER.printMessage(playerName);
  }

  /**
   * Plays a round of the game. The player is asked to input a number between 0 and 5. The AI will
   * then play a number based on the strategy used. The sum of the two numbers is then calculated
   * and the winner is determined based on the player's choice of odd or even.
   */
  public void play() {

    // Check if the game is not running
    if (!gameRunning) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }

    MessageCli.START_ROUND.printMessage(String.valueOf(roundNumber));

    MessageCli.ASK_INPUT.printMessage();
    String playerInput = Utils.scanner.nextLine();

    // Keep checking if the input is one integer between 0 and 5
    while (!playerInput.matches("[0-5]")) {
      MessageCli.INVALID_INPUT.printMessage();
      playerInput = Utils.scanner.nextLine();
    }

    int playerNumber = Integer.parseInt(playerInput);
    int aiNumber =
        ai.strategyUsed(roundNumber, playerHistory, previousRoundAi); // Get the AI's number
    int sum = playerNumber + aiNumber;

    MessageCli.PRINT_INFO_HAND.printMessage(playerName, playerInput);
    MessageCli.PRINT_INFO_HAND.printMessage(ai.getAiName(), String.valueOf(aiNumber));

    // Determine the winner of the round and update the AI's previous round stat
    previousRoundAi = getResults(sum);
    playerHistory.add(playerNumber);
    roundNumber++;
  }

  /**
   * Helper method that determines the winner of the round based on the sum of the two numbers and
   * the player's choice
   *
   * @param sum The sum of the two numbers played
   * @return 0 if the player wins, 1 if the AI wins, -1 if the sum is invalid
   */
  private int getResults(int sum) {

    // Check if the player chose even
    if (playerChoice.equals(Choice.EVEN)) {
      // If the sum is also even the player wins otherwise the AI wins
      if (Utils.isEven(sum)) {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(String.valueOf(sum), "EVEN", playerName);
        playerWins++;
        return 0;
      } else {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(String.valueOf(sum), "ODD", ai.getAiName());
        aiWins++;
        return 1;
      }
    } else if (playerChoice.equals(Choice.ODD)) { // Check if the player chose odd
      // If the sum is also odd the player wins otherwise the AI wins
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

  /**
   * Ends the game and prints the stats of the game. Prints the winner of the game or if it is a tie
   */
  public void endGame() {
    // Show the stats first. showStats() checks if the game is running
    showStats();

    // Determine the winner of the game or if it is a tie
    if (playerWins > aiWins) {
      MessageCli.PRINT_END_GAME.printMessage(playerName);
    } else if (playerWins < aiWins) {
      MessageCli.PRINT_END_GAME.printMessage(ai.getAiName());
    } else {
      MessageCli.PRINT_END_GAME_TIE.printMessage();
    }
    gameRunning = false; // Game is no longer running
  }

  /** Shows the stats of the game. Prints the number of wins for the player and the AI */
  public void showStats() {

    // Check if the game is not running
    if (!gameRunning) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }

    // Print the wins and loses for each player
    MessageCli.PRINT_PLAYER_WINS.printMessage(
        playerName, String.valueOf(playerWins), String.valueOf(aiWins));
    MessageCli.PRINT_PLAYER_WINS.printMessage(
        ai.getAiName(), String.valueOf(aiWins), String.valueOf(playerWins));
  }
}
