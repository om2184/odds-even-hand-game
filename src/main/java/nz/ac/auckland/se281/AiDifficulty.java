package nz.ac.auckland.se281;

import java.util.List;

/**
 * This class represents the AiDifficulty. All difficulties must implement this interface. This
 * interface is used to determine the strategy used by the AI for different difficulties.
 */
public interface AiDifficulty {

  public String aiName = "HAL-9000";

  public int strategyUsed(int roundNumber, List<Integer> playerHistory, int previousRound);

  public String getAiName();
}
