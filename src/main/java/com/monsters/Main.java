package com.monsters;

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


    //  (                                              *
    // )\ )                                         (  `                 )
    //(()/(     (          (  (     (               )\))(      )      ( /(   (   (
    // /(_))   ))\   (     )\))(   ))\  (    (     ((_)()\  ( /(  (   )\()) ))\  )(
    //(_))_   /((_)  )\ ) ((_))\  /((_) )\   )\ )  (_()((_) )(_)) )\ (_))/ /((_)(()\
    // |   \ (_))(  _(_/(  (()(_)(_))  ((_) _(_/(  |  \/  |((_)_ ((_)| |_ (_))   ((_)
    // | |) || || || ' \))/ _` | / -_)/ _ \| ' \)) | |\/| |/ _` |(_-<|  _|/ -_) | '_|
    // |___/  \_,_||_||_| \__, | \___|\___/|_||_|  |_|  |_|\__,_|/__/ \__|\___| |_|
    //                    |___/

    ResourceBundle bundle = ResourceBundle.getBundle(BUNDLE_NAME);

    try (
        Reader input = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input)
    ) {

      // Generate world and monsters

      // Let play = true
      boolean play = true;

      // Get the name of the main character
      System.out.println("Welcome to Key Master! Your task, should you choose to accept it"
          + "is to destroy all monsters and collect their keys.\n");
      System.out.println("What is your name hero?");
      String name = reader.readLine().trim();

      // Create game character
      Character character = new Character(name);

      // Repeat character name back
      System.out.println("Let the journey begin " + character.getName());

      // Create instance of game object
      Game.State state = Game.State.PLAYER_MOVE;
      Game game = new Game(state, character, new Monster("Fire Monster", "Fire Key"));

      // Create instance of TextGamePresentation
      TextGamePresentation presentation = new TextGamePresentation(bundle);

      // While playing
      while (continueGame(reader, character, game)) {

        // Initiate player state in the world

        // Player movement and state updates

      }

      if (game.getCharacterKeys() == 3) {
        presentation.winGameNotice();
      }

    } catch (IOException e) {
      // Ignore exception for now

    }
  }


  private static boolean continueGame(BufferedReader reader, Character character, Game game)
      throws IOException {
    boolean status = true;

    if (character.getHealth() <= 0) {
      status = false;
    }

//    System.out.println("Would you like to continue (y/n)?");
//    String response = reader.readLine().trim().toLowerCase();
//    response.equals("y");
    return true;
  }

}
