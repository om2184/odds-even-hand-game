package nz.ac.auckland.se281;

import java.util.List;

public interface AiDifficulty {

  public String aiName = "HAL-9000";

  public int strategyUsed(int roundNumber, List<Integer> playerHistory, int previousRound);

  public String getAiName();
}
