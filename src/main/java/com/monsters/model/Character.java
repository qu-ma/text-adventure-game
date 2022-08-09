package com.monsters.model;

public class Character {

  private final String name;
  private int health = 100;

  public Character(String name) {
    this.name = name;
  }

  public int attack(int damage){
    // TODO add rng for random damage
    System.out.println("Attack!");
    return damage;
  }

  public void decreaseHealth(int damage) {
    this.health -= damage;
  }

  public String getName() {
    return name;
  }

  public int getHealth() {
    return health;
  }

  public void setHealth(int health) {
    this.health = health;
  }

}
