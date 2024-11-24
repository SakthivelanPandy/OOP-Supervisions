package main.java;

import java.util.ArrayList;
import java.util.Iterator;

public class Game {
  private double money;
  private ArrayList<Pet> pets;
  private ArrayList<Accessory> inventory;
  private Reciever reciever = new Reciever();
  private UserInterface UI;
  private int currentPet = 0; // the index of the pet currently being looked at

  public Game(UserInterface UI) {
    this.money = 100.00;
    this.pets = new ArrayList<Pet>();
    this.inventory = new ArrayList<Accessory>();
    this.UI = UI;
    UI.setReciever(reciever);

    // start the game with a mouse
    Pet firstPet = new Mouse("Michael");
    this.pets.add(firstPet);
    this.currentPet = 0;

    UI.displayPet(firstPet);
  }

  public double getMoney() {
    return this.money;
  }

  public void buyPet(Pet pet) {
    if (pet.getPrice() > money) {
      UI.displayMessage("Not Enough Money!");
      return;
    }

    // Name the pet
    String name = UI.requestString("What would you like to name the pet?");
    pet.setName(name);

    pets.add(pet);

    money -= pet.getPrice();
    UI.displayMessage(name + " has been added to your collection!");
    UI.displayPet(pet);
  }

  public void removeDeadPets() {
    Iterator<Pet> it = pets.iterator();
    while (it.hasNext()) {
      Pet p = it.next();
      if (p.isDead()) {
        UI.displayMessage(p.getName() + " has died!");
        it.remove();
        currentPet--;
      }
    }

  }

  public void gameLoop() {
    String command;
    while (true) {
      removeDeadPets();
      command = UI.requestString();
      switch (command) {
        case "next":
          currentPet = (currentPet + 1) % pets.size();
          UI.displayPet(pets.get(currentPet));
          break;
        case "show stats":
          UI.displayPetStats(pets.get(currentPet));
          break;
        case "pet shop":
          UI.displayPetShop();
          String animal = UI.requestString("Which animal would you like to buy?");
          switch (animal) {
            case "mouse":
              buyPet(new Mouse());
              break;

            default:
              break;
          }
        case "balance":
          UI.displayMoney(getMoney());
          break;
        case "put to work":
          money += pets.get(currentPet).putToWork();
          UI.displayPetStats(pets.get(currentPet));
          break;
        case "rest":
          pets.get(currentPet).sleep();
          UI.displayPetStats(pets.get(currentPet));
          break;
        case "feed":
          pets.get(currentPet).feed();
          money -= 1;
          UI.displayPetStats(pets.get(currentPet));
          UI.displayMoney(money);
          break;

        default:
          break;
      }
    }
  }

  public static void main(String[] args) {
    CLI cli = new CLI();
    Game game = new Game(cli);
    game.gameLoop();
  }

}
