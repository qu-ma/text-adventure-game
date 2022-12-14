package com.monsters.model;

import com.monsters.model.exception.GameFinishedException;
import com.monsters.model.exception.IllegalMoveException;


public class Game {

  private int characterAttackDamage;
  private int monsterAttackDamage;
  public static final int ATTACK_MOVE = 1;
  private boolean firstMove;
  private State state;
  public Monster monster;
  public Character character;


  public Game(State initialState, Character character, Monster monster) {
//  this.firstMove = true;
    state = initialState;
    this.monster = monster;
    this.character = character;
  }

  public void decreaseTargetHealth(int damage, String target) {
    if (target == "monster") {
      monster.decreaseHealth(damage);
      this.monsterAttackDamage = damage;
    } else if (target == "character") {
      character.decreaseHealth(damage);
    }
    this.characterAttackDamage = damage;
  }

  public void generateNewMonster(int health, String name) {
    monster.setHealth(health);
    monster.setName(name);
  }

  public State getState() {
    return state;
  }

  public int getMonsterHealth() {
    return monster.getHealth();
  }

  public int getCharacterHealth() {
    return character.getHealth();
  }

  public int getCharacterKeys() {
    return character.getKeys();
  }

  public void increaseKeys() {
    character.setKeys(character.getKeys() + 1);
  }

  public String getCharacterName() {
    return character.getName();
  }

  public String getMonsterName() {
    return monster.getName();
  }

  public int getCharacterAttackDamage() {
    return characterAttackDamage;
  }

  public int getMonsterAttackDamage() {
    return monsterAttackDamage;
  }

  public enum State {
    PLAYER_MOVE {

      @Override
      public boolean isFinished() {
        return false;
      }

    },

    MONSTER_MOVE {

      @Override
      public boolean isFinished() {
        return false;
      }

    },

    PLAYER_WIN,
    MONSTER_WIN;
    private static final String NO_MOVES_ALLOWED_FORMAT = "Game is already in a finished state (HP = %d); no further moves possible";
    private static final String INVALID_MOVE = "This move is not an option.";

    public boolean isFinished() {
      return false;
    }

  }

}
