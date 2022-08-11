package com.monsters.model;

public class Monster extends CharacterModel {

  public Monster(String name, int health, int key) {
    super(name, health, key);
  }

  @Override
  public void speak() {
    System.out.println("Roar!");

  }
}
