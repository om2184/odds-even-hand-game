package nz.ac.auckland.se281;

import java.util.List;
import nz.ac.auckland.se281.Main.Choice;

public class HardDifficulty implements AiDifficulty {

  private Strategy strategy;
  private Choice choice;

  /**
   * Hard difficulty uses random strategy first so strategy is initally set to random strategy.
   *
   * @param choice player chose odd or even
   */
  public HardDifficulty(Choice choice) {
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
    } else if (previousRound == 0) { // If previous round Ai lost then change strategy
      if (this.strategy instanceof RandomStrategy) {
        this.setStrategy(new TopStrategy(playerHistory, choice));
        return this.strategy.aiFinger();
      } else {
        this.setStrategy(new RandomStrategy());
        return this.strategy.aiFinger();
      }
    } else { // If previous round Ai won keep same strategy
      return this.strategy.aiFinger();
    }
  }

  @Override
  public String getAiName() {
    return aiName;
  }
}
