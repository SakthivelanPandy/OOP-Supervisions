package main.java;

public class Node {
  public LeaderboardItem val;
  public Node next;

  public Node(LeaderboardItem val) {
    this.val = val;
    this.next = null;
  }
}
