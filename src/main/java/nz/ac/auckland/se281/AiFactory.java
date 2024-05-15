package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

public class AiFactory {

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
