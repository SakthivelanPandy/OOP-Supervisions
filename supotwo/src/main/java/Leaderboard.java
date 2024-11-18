package main.java;

class Leaderboard {
  private LinkedList leaderboard;
  private int size;

  Leaderboard(int size) {
    this.leaderboard = new LinkedList(new LeaderboardItem("", Integer.MAX_VALUE));
    this.size = size;
  }

  private void addToHead(LeaderboardItem newHead) {
    Node tempHead = new Node(newHead);
    if (this.leaderboard.getHead().val.getScore() == Integer.MAX_VALUE) {
      this.leaderboard.head = tempHead;
    } else {
      tempHead.next = this.leaderboard.getHead();
      this.leaderboard.head = tempHead;
    }
  }

  public int addScore(String name, int score) {
    LeaderboardItem item = new LeaderboardItem(name, score);
    Node node = this.leaderboard.getHead();
    int counter = 0;

    while (node != null && counter < size) {
      if (node.val.getScore() >= score) {
        if (counter == 0) {
          this.addToHead(item);
        } else {
          this.leaderboard.appendNth(item, counter);
        }
        return counter;
      } else {
        node = node.next;
        counter++;
      }
    }
    if (counter < size) {
      this.leaderboard.append(item);
      return counter + 1;
    } else {
      return -1;
    }
  }

  @Override
  public String toString() {
    String output = "";
    Node node = this.leaderboard.getHead();
    while (node != null) {
      output = output + node.val.getName() + ": " + node.val.getScore() + "\n";
      node = node.next;
    }
    return output;
  }
}
