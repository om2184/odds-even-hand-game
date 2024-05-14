package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class Ai {

  protected String aiName = "HAL-9000";
  protected Strategy strategy;

  public Ai(Difficulty difficulty) {
    if (difficulty == Difficulty.EASY) {
      this.strategy = new RandomStrategy();
    }
  }

  public String getAiName() {
    return aiName;
  }

  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

  public int play() {
    return strategy.aiNumber();
  }
}
