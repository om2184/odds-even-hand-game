package nz.ac.auckland.se281;

import java.util.List;

public interface AiDifficulty {

  public int strategyUsed(int roundNumber, List<Integer> playerHistory, int previousRound);
}
