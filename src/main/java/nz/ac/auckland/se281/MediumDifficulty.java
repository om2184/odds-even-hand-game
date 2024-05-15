package nz.ac.auckland.se281;

public class MediumDifficulty implements AiDifficulty {

  private Strategy strategy;

  public MediumDifficulty() {
    this.strategy = new RandomStrategy();
  }

  private Strategy setStrategy(Strategy strategy) {
    return this.strategy = strategy;
  }

  @Override
  public int aiNumber(int roundNumber) {
    if (roundNumber < 4) {
      return this.strategy.aiFinger();
    } else {
      this.setStrategy(new TopStrategy());
      return this.strategy.aiFinger();
    }
  }
}
