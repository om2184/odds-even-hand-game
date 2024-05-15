package nz.ac.auckland.se281;

public class EasyDifficulty implements AiDifficulty {

  private Strategy strategy;

  public EasyDifficulty() {
    this.strategy = new RandomStrategy();
  }

  @Override
  public int aiNumber(int roundNumber) {
    return this.strategy.aiFinger();
  }

  @Override
  public Strategy setStrategy(Strategy strategy) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'setStrategy'");
  }
}
