package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

public class AiFactory {
  /**
   * Create an AI based on the difficulty and choice.
   *
   * @param difficulty what difficulty the player wants to play at
   * @param choice player chose odd or even
   * @return the Ai created based on the difficulty and choice
   */
  public static AiDifficulty createAi(Difficulty difficulty, Choice choice) {
    switch (difficulty) {
      case EASY:
        return new EasyDifficulty();
      case MEDIUM:
        return new MediumDifficulty(choice);
      case HARD:
        return new HardDifficulty(choice);
      default:
        return null;
    }
  }

  protected String aiName = "HAL-9000";
  protected Strategy strategy;
}
