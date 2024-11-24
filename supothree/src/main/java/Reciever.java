package main.java;

import java.util.LinkedList;
import java.util.Queue;

public class Reciever {
  private Queue<String> commandQueue;

  public Reciever() {
    commandQueue = new LinkedList<String>();
  }

  public void onRecieveString(String command) {
    // This method should only be called by a User Interface
    commandQueue.add(command);

  }

  public String recieveString() {
    return commandQueue.remove();
  }
}
