package nz.ac.auckland.se281;

import java.util.List;
import nz.ac.auckland.se281.Main.Choice;

public class TopStrategy implements Strategy {

  private List<Integer> playerHistory;
  private int odds;
  private int evens;
  private Choice choice;

  public TopStrategy(List<Integer> playerHistory, Choice choice) {
    this.playerHistory = playerHistory;
    this.choice = choice;
  }

  @Override
  public int aiFinger() {
    // Determine the most frequently chosen type of number (ODD or EVEN)
    int mostFrequentType = getMostFrequentType();

    if (choice == Choice.ODD) {
      // Adapt AI's approach based on the most frequently chosen type
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
      // Adapt AI's approach based on the most frequently chosen type
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

  // Helper method to determine the most frequently chosen type of number
  private int getMostFrequentType() {
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
