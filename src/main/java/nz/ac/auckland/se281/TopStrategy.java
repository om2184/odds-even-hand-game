package nz.ac.auckland.se281;

import java.util.ArrayList;
import java.util.List;

public class TopStrategy implements Strategy {

  private List<Integer> oddCounts;
  private List<Integer> evenCounts;

  public TopStrategy() {
    this.oddCounts = new ArrayList<>();
    this.evenCounts = new ArrayList<>();
  }

  @Override
  public int aiFinger() {
    // Determine the most frequently chosen type of number (ODD or EVEN)
    int mostFrequentType = getMostFrequentType();

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
  }

  // Helper method to determine the most frequently chosen type of number
  private int getMostFrequentType() {

    // Compare counts to determine the most frequent type
    if (oddCounts.size() > evenCounts.size()) {
      return 1; // ODD
    } else if (evenCounts.size() > oddCounts.size()) {
      return 0; // EVEN
    } else {
      return -1; // Equal counts or no data available
    }
  }

  // Method to update the counts based on the player's move
  public void updateCounts(int fingers) {
    if (fingers % 2 == 0) {
      evenCounts.add(fingers);
    } else {
      oddCounts.add(fingers);
    }
  }
}
