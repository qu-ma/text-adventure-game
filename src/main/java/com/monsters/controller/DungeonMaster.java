package com.monsters.controller;


import com.monsters.model.Character;
import com.monsters.model.Game;
import com.monsters.model.Monster;
import com.monsters.view.TextGamePresentation;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Random;

public class DungeonMaster {

  private BufferedReader reader;
  private Monster monster;
  private Character character;
  private Game game;
  private TextGamePresentation presentation;
  private final int MIN = 1;
  private final int MAX = 10;

  Random rng;

  public DungeonMaster(BufferedReader reader, Monster monster, Character character, Game game,
      TextGamePresentation presentation) {
    this.reader = reader;
    this.monster = monster;
    this.character = character;
    this.game = game;
    this.presentation = presentation;
  }

  public boolean battleMonster() throws IOException {
    boolean victory = false;
    boolean playerTurn = true;

//    * While player still has hp and has yet to collect 3 keys, game continues;
//    * Present current state to player
//        * Ask user for desired action
//    * Calculate result of action and update state of the world
//    * Present the outcome of action to user

    System.out.println(monster.getName() + " wants to battle!");

    while (monster.getHealth() != 0 | character.getHealth() != 0) {

      if (playerTurn) {
        System.out.println("Choose desired action (1: ATTACK!, 2:RUN!)");
        String response = reader.readLine().trim();
        if (response.equals(2)){
          gameOver();
        }
        int damage = attackDamage();
        monster.decreaseHealth(damage);
        System.out.println("You imposed " + damage + " to " +monster.getName());
      }
      else{
        int damage = attackDamage();
        monster.decreaseHealth(damage);
        System.out.println("Monster imposed " + damage + " to " +monster.getName());
      }
    }

    if (monster.getHealth() <= 0){
      victory = true;
      battleWon();
    }

    return victory;
  }

  private void battleWon() {
    character.setKeys(character.getKeys() + 1);
    Object object = presentation.winGameNotice();
  }

  public void gameOver() {
    Object object = presentation.lostGameNotice();
  }

  public void gameWon() {
    // TODO
  }

  public int attackDamage() {
    int damage = (int)(Math.random()*(MAX-MIN+1)+MIN);
    return attackDamage();
  }


  public Reader getReader() {
    return reader;
  }

  public void setReader(BufferedReader reader) {
    this.reader = reader;
  }

  public Monster getMonster() {
    return monster;
  }

  public void setMonster(Monster monster) {
    this.monster = monster;
  }

  public Character getCharacter() {
    return character;
  }

  public void setCharacter(Character character) {
    this.character = character;
  }

  public Game getGame() {
    return game;
  }

  public void setGame(Game game) {
    this.game = game;
  }

}
