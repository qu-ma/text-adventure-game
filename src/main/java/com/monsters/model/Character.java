package com.monsters.model;

public class Character extends CharacterModel {

  public Character(String name, int health) {
    super(name, health);
  }

  public int getKeys() {
    return keys;
  }

  public void setKeys(int keys) {
    this.keys = keys;
  }

  @Override
  public int attack(int damage) {
    // TODO add rng for random damage
    System.out.println("Attack!");
    return damage;
  }

  @Override
  public void speak() {
    System.out.println("I will prevail");
  }
}
