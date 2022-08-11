package com.monsters.model;

public class Monster extends CharacterModel {

  public Monster(String name, int health, int key) {
    super(name, health, key);
  }

  @Override
  public int attack(int damage) {
    // TODO add rng for random damage
    System.out.println("Attack!");
    return 1;
  }

  @Override
  public void speak() {
    System.out.println("Roar!");

  }
}
