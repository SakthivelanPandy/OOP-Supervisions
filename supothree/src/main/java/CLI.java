package main.java;

import java.util.Scanner;

public class CLI implements UserInterface {
  private Reciever reciever;
  private Scanner scanner = new Scanner(System.in);

  public void clearScreen() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }

  public void setReciever(Reciever reciever) {
    this.reciever = reciever;
  }

  public void sendStringInput() {
    String input = scanner.nextLine();
    reciever.onRecieveString(input);
    clearScreen();
  }

  public void sendIntInput() {
    return;
  }

  public void sendButtonClick() {
    return; // can't click a button in a CLI
  }

  public String requestString(String msg) {
    System.out.println(msg);
    System.out.print("==>");
    String input = scanner.nextLine();
    clearScreen();
    return input;
  }

  public String requestString() {
    System.out.println("Commands: (next),(show stats),(pet shop),(balance),(put to work),(rest),(feed)");
    System.out.print("==>");
    String input = scanner.nextLine();
    clearScreen();
    return input;
  }

  public void displayPet(Pet pet) {
    System.out.println(pet.getName());
    String species = pet.getSpecies();
    switch (species) {
      case "Mouse":
        System.out.println("""
              )
             (__
             _  )_
            (_)_(_)
             (o o)
            ==\\o/==

                    """);
        break;

      default:
        break;
    }
  }

  public void displayPetStats(Pet pet) {
    System.out.println(pet.getName());
    System.out.println("Health: " + pet.getHealth() + "/" + pet.getMaxHealth());
    System.out.println("Hunger: " + pet.getHunger() + "/" + pet.getMaxHunger());
    System.out.println("Sleep: " + pet.getSleep() + "/" + pet.getMaxSleep());
  }

  public void displayAccessory() {
    return;
  }

  public void displayPlayerStats() {
    System.out.println("Money: ");
  }

  public void displayMessage(String message) {
    System.out.println(message);
  }

  public void displayPetShop() {
    Pet[] availablePets = { new Mouse() };
    for (Pet pet : availablePets) {
      System.out.println(pet.getSpecies() + ": £" + pet.getPrice());
    }
  }

  public void displayAccessoryShop() {
    Accessory[] availableAccessories = {};
    for (Accessory accessory : availableAccessories) {
      System.out.println(accessory.getName() + ": £" + accessory.getPrice());
    }
  }

  public void displayMoney(double money) {
    System.out.println("£: " + money);
  }

}
