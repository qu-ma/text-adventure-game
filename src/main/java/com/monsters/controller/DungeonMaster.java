package com.monsters.controller;


import com.monsters.model.Character;
import com.monsters.model.Game;
import com.monsters.model.Monster;
import java.io.Reader;

public class DungeonMaster {

  Reader reader;
  Monster monster;
  Character character;
  Game game;

  public DungeonMaster(Reader reader, Monster monster, Character character, Game game) {
    this.reader = reader;
    this.monster = monster;
    this.character = character;
    this.game = game;
  }

  //Method for battle : ()
  //

  //Method for gameOver: ()
  //

  //Method for gameCompleted: ()
  //

  //Method for gameWon: ()
  //


  public Reader getReader() {
    return reader;
  }

  public void setReader(Reader reader) {
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
