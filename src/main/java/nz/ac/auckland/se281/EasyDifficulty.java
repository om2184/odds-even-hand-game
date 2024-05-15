package nz.ac.auckland.se281;

public class EasyDifficulty implements AiDifficulty {

  private Strategy strategy;

  public Strategy EasyDifficulty() {
    return this.strategy = new RandomStrategy();
  }

  @Override
  public int aiNumber(int roundNumber) {
    return this.strategy.aiFinger();
  }
}
