package nz.ac.auckland.se281;

import java.util.List;
import nz.ac.auckland.se281.Main.Choice;

public class MediumDifficulty implements AiDifficulty {

  private Strategy strategy;
  private Choice choice;

  public MediumDifficulty(Choice choice) {
    this.strategy = new RandomStrategy();
    this.choice = choice;
  }

  public Strategy setStrategy(Strategy strategy) {
    return this.strategy = strategy;
  }

  @Override
  public int strategyUsed(int roundNumber, List<Integer> playerHistory) {
    if (roundNumber < 4) {
      return this.strategy.aiFinger();
    } else if (roundNumber == 4) {
      this.setStrategy(new TopStrategy(playerHistory, choice));
      return this.strategy.aiFinger();
    } else {
      return this.strategy.aiFinger();
    }
  }
}
