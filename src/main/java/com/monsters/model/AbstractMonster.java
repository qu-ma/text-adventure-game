package com.monsters.model;

public abstract class AbstractMonster {

  private String name;
  private int health;
  private String key;


  public AbstractMonster(String name,String key) {
    this.name = name;
    this.key = key;
    this.health = 100;
  }

  public abstract int attack(int damage);

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

}
