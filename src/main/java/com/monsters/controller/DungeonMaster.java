package com.monsters.controller;


import com.monsters.model.Character;
import com.monsters.model.Game;
import com.monsters.model.Monster;
import com.monsters.view.TextGamePresentation;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DungeonMaster {

  private BufferedReader reader;
  private Monster monster;
  private Character character;
  private Game game;
  private TextGamePresentation presentation;
  private final int MIN = 1;
  private final int MAX = 10;

  private final ArrayList<String> monsterList = new ArrayList<>(
      List.of("Water Monster", "Lava Monster", "Generic Monster"));

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

    System.out.println(presentation.roundStartNotice(monster.getName()));

    while (monster.getHealth() > 0 && character.getHealth() > 0) {

      if (playerTurn) {
        System.out.println("Choose desired action (a: ATTACK!, b:RUN!)");
        String response = reader.readLine().trim().toLowerCase();
        if (response.equals("b")) {
          runFromBattle();
          break;
        }
        int damage = attackDamage();
        monster.decreaseHealth(damage);
        System.out.println("You imposed " + damage + " damage to " + monster.getName());
        System.out.println(monster.getName() + " current health " + game.getMonsterHealth());
        playerTurn = false;
      } else {
        int damage = attackDamage();
        character.decreaseHealth(damage);
        System.out.println("Monster imposed " + damage + " damage to " + character.getName());
        System.out.println(character.getName() + " current health " + game.getCharacterHealth());
        playerTurn = true;
      }
    }

    if (monster.getHealth() <= 0) {
      victory = true;
      battleWon();
      System.out.println("You are victorious!");
      if(game.getCharacterKeys() < 3) {
        generateNewMonster();
      }
    }

    return victory;
  }

  private void battleWon() {
    character.setKeys(character.getKeys() + 1);
    System.out.println(presentation.winRoundNotice(character.getName())); // game.getCharacterName();
  }

  public void gameOver() {
    Object object = presentation.lostGameNotice(character.getName());
  }

  public void gameWon() {
    // TODO
  }

  public int attackDamage() {
    int damage = (int) (Math.random() * (MAX - MIN + 1) + MIN);
    return damage;
  }

  public void generateNewMonster() {
    monster.setHealth(25);
    monster.setName(monsterList.get(game.getCharacterKeys()));
  }

  public void runFromBattle() {
    System.out.println("Not to call you a coward, master, but sometimes, cowards do survive... - Starscream (From Transformers 2009)");
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
