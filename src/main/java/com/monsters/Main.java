package com.monsters;

import com.monsters.controller.DungeonMaster;
import com.monsters.model.Game;
import com.monsters.model.Game.State;
import com.monsters.model.Monster;
import com.monsters.view.TextGamePresentation;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import com.monsters.model.Character;
import java.util.ResourceBundle;

public class Main {

  private static final String BUNDLE_NAME = "strings";

  public static void main(String[] args) {

    System.out.println("  ######                                              #     #");
    System.out.println(" #     # #    # #    #  ####  ######  ####  #    #    ##   ##   ##    ####  ##### ###### #####");
    System.out.println(" #     # #    # ##   # #    # #      #    # ##   #    # # # #  #  #  #        #   #      #    #");
    System.out.println(" #     # #    # # #  # #      #####  #    # # #  #    #  #  # #    #  ####    #   #####  #    #");
    System.out.println(" #     # #    # #  # # #  ### #      #    # #  # #    #     # ######      #   #   #      #####");
    System.out.println(" #     # #    # #   ## #    # #      #    # #   ##    #     # #    # #    #   #   #      #   #");
    System.out.println(" ######   ####  #    #  ####  ######  ####  #    #    #     # #    #  ####    #   ###### #    #");

    ResourceBundle bundle = ResourceBundle.getBundle(BUNDLE_NAME);

    try (
        Reader input = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input)
    ) {

      // Generate world and monsters

      // Let play = true
      boolean play = true;

      // Get the name of the main character
      System.out.println("Welcome to Dungeon Master! Your task, should you choose to accept it"
          + "is to destroy all monsters and collect their keys.\n");
      System.out.println("What is your name hero?");
      String name = reader.readLine().trim();

      // Create game character
      Character character = new Character(name);

      // Repeat character name back
      System.out.println("Let the journey begin " + character.getName() + "!");

      // Create instance of game object (Model)
      Game.State state = Game.State.PLAYER_MOVE;
      Monster monster = new Monster("Fire Monster", "Fire Key");
      Game game = new Game(state, character, monster);
      // game.getCharacterName(character.getName());

      // Create instance of TextGamePresentation (View)
      TextGamePresentation presentation = new TextGamePresentation(bundle);

      // Create an instance of the DungeonMaster class (Controller)
      DungeonMaster dungeonMaster = new DungeonMaster(reader, monster, character, game,
          presentation);

      // Continue playing game until play has all three keys or player decides to quit
      while (continueGame(reader, character, game)) {
        dungeonMaster.battleMonster();
      }

      System.out.println(
          character.getName() + " has acquired " + game.getCharacterKeys() + " number of keys.");

      if (game.getCharacterKeys() == 3) {
        System.out.println(presentation.winGameNotice(game.getCharacterName()));
      } else {
        System.out.println(presentation.lostGameNotice(game.getCharacterName()));
      }


    } catch (IOException e) {
      // Ignore exception for now
      //

    }
  }


  private static boolean continueGame(BufferedReader reader, Character character, Game game)
      throws IOException {
    boolean status = true;

    if (character.getHealth() <= 0 || character.getKeys() == 3) {
      status = false;
    } else {
      System.out.println("Would you like to continue (y/n)?");
      String response = reader.readLine().trim().toLowerCase();
      status = response.equals("y");
    }

    return status;
  }

}
