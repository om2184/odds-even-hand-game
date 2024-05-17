package nz.ac.auckland.se281;

import java.util.List;
import nz.ac.auckland.se281.Main.Choice;

/**
 * This class represents the TopStrategy. The TopStrategy is a strategy that adapts the AI's
 * approach based on the most frequently chosen type of number (ODD or EVEN) by the player.
 */
public class TopStrategy implements Strategy {

  private List<Integer> playerHistory;
  private Choice choice;

  public TopStrategy(List<Integer> playerHistory, Choice choice) {
    this.playerHistory = playerHistory;
    this.choice = choice;
  }

  @Override
  public int aiFinger() {
    // Determine the most frequently chosen type of number (ODD or EVEN)
    int mostFrequentType = getMostFrequentType();

    // Adapt AI's approach based on the most frequently chosen type
    if (choice == Choice.ODD) {
      if (mostFrequentType == 1) {
        // If odd numbers are more frequent, choose an even number
        return Utils.getRandomEvenNumber();
      } else if (mostFrequentType == 0) {
        // If even numbers are more frequent, choose an odd number
        return Utils.getRandomOddNumber();
      } else {
        // If both odd and even counts are equal or no data available, choose randomly
        return Utils.getRandomNumberRange(0, 5);
      }
    } else {
      if (mostFrequentType == 1) {
        // If odd numbers are more frequent, choose an odd number
        return Utils.getRandomOddNumber();
      } else if (mostFrequentType == 0) {
        // If even numbers are more frequent, choose an even number
        return Utils.getRandomEvenNumber();
      } else {
        // If both odd and even counts are equal or no data available, choose randomly
        return Utils.getRandomNumberRange(0, 5);
      }
    }
  }

  /**
   * Helper method to determine the most frequently chosen type of number.
   *
   * @return 1 if even numbers are more frequent, 0 if odd numbers are more frequent, -1 if both are
   *     equal.
   */
  private int getMostFrequentType() {
    int evens = 0;
    int odds = 0;

    // Count the number of even and odd numbers in the player's history
    for (int number : playerHistory) {
      if (Utils.isEven(number)) {
        evens++;
      } else {
        odds++;
      }
    }

    if (evens > odds) {
      return 1;
    } else if (odds > evens) {
      return 0;
    } else {
      return -1;
    }
  }
}
