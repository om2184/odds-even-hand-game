package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class Ai {

  protected String aiName = "HAL-9000";
  protected Strategy strategy;

  public static DifficultyLevel createAi(Difficulty difficulty) {
    switch (difficulty) {
      case EASY:
        return new EasyDifficulty();
      case MEDIUM:
        return new MediumDifficulty();
      default:
        return null;
        ;
    }
  }

  public String getAiName() {
    return aiName;
  }

  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

  public int play(int roundNumber) {
    return strategy.aiFinger();
  }
}
