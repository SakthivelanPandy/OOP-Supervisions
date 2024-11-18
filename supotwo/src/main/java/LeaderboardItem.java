package main.java;

/**
 * LeaderboardItem
 */
public class LeaderboardItem {
  private final String name;
  private final int score;

  LeaderboardItem(String name, int score) {
    this.name = name;
    this.score = score;
  }

  public String getName() {
    return this.name;
  }

  public int getScore() {
    return this.score;
  }
}
