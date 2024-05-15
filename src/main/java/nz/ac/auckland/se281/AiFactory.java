package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

public class AiFactory {

  protected String aiName = "HAL-9000";
  protected Strategy strategy;

  public static AiDifficulty createAi(Difficulty difficulty, Choice choice) {
    switch (difficulty) {
      case EASY:
        return new EasyDifficulty();
      case MEDIUM:
        return new MediumDifficulty(choice);
      default:
        return null;
    }
  }
}
