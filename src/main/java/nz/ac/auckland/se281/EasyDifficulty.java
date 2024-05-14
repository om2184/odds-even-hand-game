package nz.ac.auckland.se281;

import nz.ac.RandomStrategy;
import nz.ac.Strategy;

public class EasyDifficulty implements Difficulty {

  private Strategy strategy;

  public Strategy EasyDifficulty() {
    return this.strategy = new RandomStrategy();
  }

  @Override
  public int getNumber() {
    return strategy.aiNumber();
  }
}
