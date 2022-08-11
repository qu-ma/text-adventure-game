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
  public void speak() {
    System.out.println("I will prevail");
  }
}
