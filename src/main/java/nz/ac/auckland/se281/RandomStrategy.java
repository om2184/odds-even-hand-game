package nz.ac.auckland.se281;

public class RandomStrategy implements Strategy {

  @Override
  public int aiNumber() {
    // This strategy selects the fingers to play randomly between 0 and 5.
    return Utils.getRandomNumberRange(0, 5);
  }
}
