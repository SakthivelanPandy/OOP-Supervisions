package main.java;

public abstract class Pet {
  private String name;
  private double price;
  private double sleep;
  private double hunger;
  private double happiness;
  private double health;
  private double maxHealth = Double.MAX_VALUE;
  private double maxSleep = Double.MAX_VALUE;
  private double maxHunger = Double.MAX_VALUE;
  private double weightLimit;
  private double volumeLimit;
  private boolean dead = false;
  private Accessory[] accessorries = new Accessory[10];

  public abstract String getSpecies();

  public String getName() {
    return name;
  };

  public double getPrice() {
    return price;
  };

  // getters
  public double getSleep() {
    return sleep;
  };

  public double getHunger() {
    return hunger;
  };

  public double getHappiness() {
    return happiness;
  };

  public double getHealth() {
    return health;
  };

  public double getMaxHealth() {
    return maxHealth;
  };

  public double getMaxSleep() {
    return maxSleep;
  };

  public double getMaxHunger() {
    return maxHunger;
  };

  public double getWeightLimit() {
    return weightLimit;
  };

  public double getVolumeLimit() {
    return volumeLimit;
  }; // This limits how many accessories a pet can have.

  public Accessory[] getAccessorries() {
    return accessorries;
  };

  // setters
  public void setName(String newName) {
    name = newName;
  };

  protected void setPrice(double newPrice) {
    price = newPrice;
  }

  public void setSleep(double newSleep) {
    if (newSleep < 0) {
      die();
      return;
    } else if (newSleep > maxSleep) {
      newSleep = maxSleep;
    }
    sleep = newSleep;
  };

  public void setHunger(double newHunger) {
    if (newHunger <= 0) {
      die();
      return;
    } else if (newHunger > maxHunger) {
      newHunger = maxHunger;
      setSleep(getSleep() * 0.9);
    }
    hunger = newHunger;
  };

  public void setHappiness(double newHappiness) {
    happiness = newHappiness;
  };

  public void setHealth(double newHealth) {
    if (newHealth <= 0) {
      die();
      return;
    } else if (newHealth > maxHealth) {
      newHealth = maxHealth;
    }
    health = newHealth;
  };

  public void setMaxSleep(double newMaxSleep) {
    maxSleep = newMaxSleep;
  };

  public void setMaxHunger(double newMaxHunger) {
    maxHunger = newMaxHunger;
  };

  public void setMaxHealth(double newMaxHealth) {
    maxHealth = newMaxHealth;
  };

  public void setWeightLimit(double newWeightLimit) {
    weightLimit = newWeightLimit;
  };

  public void setVolumeLimit(double newVolumeLimit) {
    volumeLimit = newVolumeLimit;
  };

  // actions
  public void play() {
    setHappiness(getHappiness() + 0.1);
  };

  public void feed() {
    setHealth(getHealth() + 1.0);
    setHunger(getHunger() + 1.0);
    setSleep(getSleep() - 1.0);
  };

  public void sleep() {
    setSleep(getSleep() + 1.0);
  };

  public void addAccessory() {
    return;
  };

  public void removeAccessory() {
    return;
  };

  public double putToWork() {
    setHealth(getHealth() - 2);
    setHunger(getHunger() - 2);
    setSleep(getSleep() - 2);
    return getHealth() * 0.2;
  }

  private void die() {
    dead = true;
  }

  public boolean isDead() {
    return dead;
  };

}
