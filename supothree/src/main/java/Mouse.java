package main.java;

public class Mouse extends Pet {

  public Mouse() {
    setPrice(10.00);
    setSleep(10.00);
    setHunger(10.00);
    setHappiness(10.00);
    setHealth(10.00);
    setMaxHealth(10.00);
    setMaxHunger(10.00);
    setMaxSleep(10.00);
    setWeightLimit(10.00);
    setVolumeLimit(10.00);
  }

  public Mouse(String name) {
    setName(name);
    setPrice(10.00);
    setSleep(10.00);
    setHunger(10.00);
    setHappiness(10.00);
    setHealth(10.00);
    setMaxHealth(10.00);
    setMaxHunger(10.00);
    setMaxSleep(10.00);
    setWeightLimit(10.00);
    setVolumeLimit(10.00);
  }

  public String getSpecies() {
    return "Mouse";
  };

}
