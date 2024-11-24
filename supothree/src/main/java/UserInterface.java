package main.java;

public interface UserInterface {
  // sets reciever
  public void setReciever(Reciever reciever);

  // sends input to reciever
  public void sendStringInput();

  public void sendIntInput();

  public void sendButtonClick();

  // Allows game to directly request string from interface
  public String requestString();

  public String requestString(String msg);

  // display graphics
  public void displayPet(Pet pet);

  public void displayPetStats(Pet pet);

  public void displayAccessory();

  public void displayPlayerStats();

  public void displayMessage(String message);

  public void displayPetShop();

  public void displayAccessoryShop();

  public void displayMoney(double money);
}
