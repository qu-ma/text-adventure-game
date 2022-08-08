package com.monsters.model;

public class Character {

  private final String name;
  private int health = 100;
  private String specialty;

  public Character(String name, String specialty) {
    this.name = name;
    this.specialty = specialty;
  }

  public int attack(){
    int damage = 0;
    // TODO add rng for random damage
    return damage;
  }

  public void decreaseHealth(int damage) {
    this.health -= damage;
  }


}
