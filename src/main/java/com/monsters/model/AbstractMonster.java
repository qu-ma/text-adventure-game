package com.monsters.model;

public abstract class AbstractMonster {
//  field - make fields protected (Makes them inheritable/accessible by subclasses. Can use 'this' instead of 'super'
    //name
    //health
    //key
//  constructor
    //name
    //name, health
    //name, health, key
//  methods
    //attack ?? not used here
    //roar - only in monster (change to catchphrase)?
    //decreaseHealth
    //getHealth
    //setHealth
    //getKey - only in character
    //getName
    //setName




  private String name;
  private int health;
  private int key;


  public AbstractMonster(String name) {
    this.name = name;
    this.key = 1;
    this.health = 25;
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

  public int getKey() {
    return key;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
