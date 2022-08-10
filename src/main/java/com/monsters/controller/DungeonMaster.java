package com.monsters.controller;


import com.monsters.model.Character;
import com.monsters.model.Game;
import com.monsters.model.Monster;
import com.monsters.model.exception.IllegalMoveException;
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
      List.of("Lord Toaster Child", "Cthulhu", "Bob the Blob"));

  public DungeonMaster(BufferedReader reader, Monster monster, Character character, Game game,
      TextGamePresentation presentation) {
    this.reader = reader;
    this.monster = monster;
    this.character = character;
    this.game = game;
    this.presentation = presentation;
  }

  public boolean battleMonster() throws IOException, IllegalMoveException {
    boolean victory = false;
    boolean playerTurn = true;

    System.out.print(presentation.roundStartNotice(game.getMonsterName()));

    while (game.getMonsterHealth() > 0 && game.getCharacterHealth() > 0) {

      if (playerTurn) {
        System.out.println(presentation.nextMoveNotice(game.getCharacterName()));
        String response = reader.readLine().trim().toLowerCase();
        if (response.equals("b")) {
          runFromBattle();
          break;
        } else if (response.equals("a")) {
          int damage = attackDamage();
          game.decreaseTargetHealth(damage, "monster");
          System.out.println(presentation.characterAttackReportNotice(game, game.getCharacterName(),
              game.getMonsterName()));
          // TODO
          System.out.println(game.getMonsterName() + " current health " + game.getMonsterHealth());
          playerTurn = false;
        } else {

          try {
            throw new IllegalMoveException((String) presentation.illegalMoveNotification());
          } catch (IllegalMoveException e) {
            System.out.println(presentation.illegalMoveNotification());
          }
        }


      } else {
        System.out.println(presentation.nextMoveNotice(game.getMonsterName()));
        int damage = attackDamage();
        game.decreaseTargetHealth(damage, "character");
        System.out.println(presentation.monsterAttackReportNotice(game, game.getMonsterName(),
            game.getCharacterName()));
        System.out.println(presentation.characterStatusNotice(game));
        playerTurn = true;
      }
    }

    if (game.getMonsterHealth() <= 0) {
      victory = true;
      battleWon();
      System.out.println("You are victorious!");
      if (game.getCharacterKeys() < 3) {
        generateNewMonster();
      }
    }

    return victory;
  }

  private void battleWon() {
    // TODO
    character.setKeys(character.getKeys() + 1);
    System.out.println(
        presentation.winRoundNotice(character.getName())); // game.getCharacterName();
  }

  public void gameOver() {
    System.out.println(presentation.lostGameNotice(game.getCharacterName()));
  }

  public void gameWon() {
  }

  public int attackDamage() {
    int damage = (int) (Math.random() * (MAX - MIN + 1) + MIN);
    return damage;
  }

  public void generateNewMonster() {
    // TODO
    monster.setHealth(25);
    monster.setName(monsterList.get(game.getCharacterKeys()));
    // game.generateNewMonster(25, monsterList.get(game.getCharacterKeys()));
  }

  public void runFromBattle() {
    System.out.println(
        "Not to call you a coward, master, but sometimes, cowards do survive... - Starscream (Transformers: Revenge of the Fallen)\n");
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
