package nz.ac.auckland.se281;

public class RandomStrategy implements Strategy {

  @Override
  public void aiNumber() {
    // This strategy selects the fingers to play randomly between 0 and 5.
    int random = Utils.getRandomNumberRange(0, 5);
  }
}
