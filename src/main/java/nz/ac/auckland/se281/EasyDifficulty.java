package nz.ac.auckland.se281;

import java.util.List;

/**
 * This class represents the EasyDifficulty which is a difficulty that uses a random strategy for
 * all rounds.
 */
public class EasyDifficulty implements AiDifficulty {

  private Strategy strategy;

  /** Easy difficulty only uses random strategy so strategy is set to random strategy. */
  public EasyDifficulty() {
    this.strategy = new RandomStrategy();
  }

  @Override
  public int strategyUsed(int roundNumber, List<Integer> playerHistory, int previousRound) {
    return this.strategy.aiFinger();
  }

  @Override
  public String getAiName() {
    return aiName;
  }
}
