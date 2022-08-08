package com.monsters.model;

public class Monster extends AbstractMonster{

  public Monster(String name, String specialty, String key, int health) {
    super(name, specialty, key, health);
  }

  @Override
  public int attack() {
    int damage = 1;
    // TODO add rng for random damage
    System.out.println("Attack!");
    return 1;
  }

  @Override
  public void roar() {
    System.out.println("Roar!");

  }



}
