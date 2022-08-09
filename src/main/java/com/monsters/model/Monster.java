package com.monsters.model;

public class Monster extends AbstractMonster{

  public Monster(String name,String key) {
    super(name);
  }

  @Override
  public int attack(int damage) {
    // TODO add rng for random damage
    System.out.println("Attack!");
    return 1;
  }

  @Override
  public void roar() {
    System.out.println("Roar!");

  }



}
