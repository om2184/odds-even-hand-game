package nz.ac.auckland.se281;

/**
 * This class represents the RandomStrategy which is a strategy that selects the fingers to play
 * randomly between 0 and 5.
 */
public class RandomStrategy implements Strategy {

  @Override
  public int aiFinger() {
    // This strategy selects the fingers to play randomly between 0 and 5.
    return Utils.getRandomNumberRange(0, 5);
  }
}
