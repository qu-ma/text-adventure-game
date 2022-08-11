package com.monsters.model;

public abstract class CharacterModel {

  protected int keys;
  private String name;
  private int health;


  public CharacterModel(String name) {
    this.name = name;
  }

  public CharacterModel(String name, int health) {
    this.name = name;
    this.health = health;
  }

  public CharacterModel(String name, int health, int key) {
    this.name = name;
    this.health = health;
    this.keys = key;
  }

  public abstract int attack(int damage);

  public abstract void speak();

  public void decreaseHealth(int damage) {
    this.health -= damage;
  }

  public int getHealth() {
    return health;
  }

  public void setHealth(int health) {
    this.health = health;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
