package main.java;

import java.lang.Math;
import java.util.Scanner;

public class Game {

  private int difficulty;
  private int numToGuess;
  private int numOfGuesses = 0;
  private boolean finished = false;
  private static Scanner readInput = new Scanner(System.in);

  public Game(int difficulty) {
    this.difficulty = difficulty;
    switch (difficulty) {
      case 1:
        this.numToGuess = (int) Math.round(10 * Math.random());
        break;
      case 2:
        this.numToGuess = (int) Math.round(50 * Math.random());
        break;
      case 3:
        this.numToGuess = (int) Math.round(100 * Math.random());
        break;
      default:
        this.numToGuess = 1;
        break;
    }
  }

  public boolean guess(int num) {
    this.numOfGuesses++;
    if (num < this.numToGuess) {
      System.out.println("Go higher");
      return false;
    } else if (num > this.numToGuess) {
      System.out.println("Go Lower");
      return false;
    } else {
      System.out.println("Correct");
      return true;
    }
  }

  public int getNumOfGuesses() {
    return this.numOfGuesses;
  }

  public int getDifficulty() {
    return this.difficulty;
  }

  public int playGame() {
    String userGuess;
    int userGuessInt;

    while (!this.finished) {
      userGuess = readInput.nextLine();
      try {
        userGuessInt = Integer.parseInt(userGuess);
        this.finished = this.guess(userGuessInt);
      } catch (NumberFormatException e) {
        System.out.println("Guess the number");
        continue;
      }
    }
    return this.getNumOfGuesses();
  }

  public static void main(String[] args) {
    boolean anotherGame = true;
    int difficulty;
    Game game;
    String name;
    int score;
    Leaderboard easyLeaderboard = new Leaderboard(10);
    Leaderboard medLeaderboard = new Leaderboard(10);
    Leaderboard hardLeaderboard = new Leaderboard(10);

    // main game loop
    while (anotherGame) {
      System.out.println("What is your name?");
      name = readInput.nextLine();
      System.out.println("Choose a difficulty between 1 and 3");
      difficulty = readInput.nextInt();
      game = new Game(difficulty);
      score = game.playGame();

      if (difficulty == 1) {
        easyLeaderboard.addScore(name, score);
        System.out.println(easyLeaderboard);
      } else if (difficulty == 2) {
        medLeaderboard.addScore(name, score);
        System.out.println(medLeaderboard);
      } else {
        hardLeaderboard.addScore(name, score);
        System.out.println(hardLeaderboard);
      }
      System.out.println("You took " + score + " guesses!");
    }

    // readInput.close();
  }
}
