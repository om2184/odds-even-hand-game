package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class Ai {

  protected String aiName = "HAL-9000";
  protected Strategy strategy;

  public static AiDifficulty createAi(Difficulty difficulty) {
    switch (difficulty) {
      case EASY:
        return new EasyDifficulty();
      case MEDIUM:
        return new MediumDifficulty();
      default:
        return null;
    }
  }
}
