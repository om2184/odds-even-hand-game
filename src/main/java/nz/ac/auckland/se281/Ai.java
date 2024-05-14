package nz.ac.auckland.se281;

public class Ai {

  private String aiName = "HAL-9000";

  public DifficultyLevel difficulty(DifficultyLevel difficulty) {
    return new EasyDifficulty();
  }
}
