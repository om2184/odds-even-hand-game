package nz.ac.auckland.se281;

import java.util.List;
import nz.ac.auckland.se281.Main.Choice;

public class HardDifficulty implements AiDifficulty {

  private Strategy strategy;
  private Choice choice;

  public HardDifficulty(Choice choice) {
    this.strategy = new RandomStrategy();
    this.choice = choice;
  }

  public Strategy setStrategy(Strategy strategy) {
    return this.strategy = strategy;
  }

  @Override
  public int strategyUsed(int roundNumber, List<Integer> playerHistory, int previousRound) {
    return 0;
  }
}
