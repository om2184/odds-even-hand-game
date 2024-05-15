package nz.ac.auckland.se281;

import java.util.List;

public class EasyDifficulty implements AiDifficulty {

  private Strategy strategy;

  public EasyDifficulty() {
    this.strategy = new RandomStrategy();
  }

  @Override
  public int strategyUsed(int roundNumber, List<Integer> playerHistory) {
    return this.strategy.aiFinger();
  }

  @Override
  public Strategy setStrategy(Strategy strategy) {
    return null;
  }
}
