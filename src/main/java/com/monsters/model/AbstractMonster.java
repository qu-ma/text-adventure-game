package com.monsters.model;

public abstract class AbstractMonster {

  private String name;
  private String specialty;
  private int health;
  private String key;


  public AbstractMonster(String name, String specialty, String key, int health) {
    this.name = name;
    this.specialty = specialty;
    this.key = key;
    this.health = health;
  }

  public abstract int attack();

  public abstract void roar();

  public void decreaseHealth(int damage) {
    this.health -= damage;
  }

  public int getHealth() {
    return health;
  }

  public void setHealth(int health) {
    this.health = health;
  }

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSpecialty() {
    return specialty;
  }

  public void setSpecialty(String specialty) {
    this.specialty = specialty;
  }
}
