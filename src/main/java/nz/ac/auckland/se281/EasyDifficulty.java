package nz.ac.auckland.se281;

public class EasyDifficulty implements DifficultyLevel {

  private Strategy strategy;

  public Strategy EasyDifficulty() {
    return this.strategy = new RandomStrategy();
  }

  @Override
  public int aiNumber() {
    return this.strategy.aiNumber();
  }
}
