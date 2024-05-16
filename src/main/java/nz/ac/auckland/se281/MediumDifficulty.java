package nz.ac.auckland.se281;

import java.util.List;
import nz.ac.auckland.se281.Main.Choice;

/**
 * This class represents the MediumDifficulty which is a difficulty that uses a random strategy for
 * the first 3 rounds and then changes to a top strategy for the rest of the rounds.
 */
public class MediumDifficulty implements AiDifficulty {

  private Strategy strategy;
  private Choice choice;

  /**
   * Medium difficulty uses random strategy first so strategy is initally set to random strategy.
   */
  public MediumDifficulty(Choice choice) {
    this.strategy = new RandomStrategy();
    this.choice = choice;
  }

  /**
   * Change the strategy to the given strategy.
   *
   * @param strategy the strategy to change to
   * @return the new strategy
   */
  public Strategy setStrategy(Strategy strategy) {
    return this.strategy = strategy;
  }

  @Override
  public int strategyUsed(int roundNumber, List<Integer> playerHistory, int previousRound) {
    // First 3 rounds use random strategy
    if (roundNumber < 4) {
      return this.strategy.aiFinger();
    } else if (roundNumber == 4) { // At round 4 change strategy to top strategy
      this.setStrategy(new TopStrategy(playerHistory, choice));
      return this.strategy.aiFinger();
    } else { // If round is greater than 4 keep the top strategy
      return this.strategy.aiFinger();
    }
  }

  @Override
  public String getAiName() {
    return aiName;
  }
}
