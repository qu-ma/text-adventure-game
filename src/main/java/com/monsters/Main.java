package com.monsters;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import com.monsters.model.Character;

public class Main {

  public static void main(String[] args) {

    //      )                *
    //  ( /(              (  `                 )
    //  )\())  (   (      )\))(      )      ( /(   (   (
    //|((_)\  ))\  )\ )  ((_)()\  ( /(  (   )\()) ))\  )(
    //|_ ((_)/((_)(()/(  (_()((_) )(_)) )\ (_))/ /((_)(()\
    //| |/ /(_))   )(_)) |  \/  |((_)_ ((_)| |_ (_))   ((_)
    //  ' < / -_) | || | | |\/| |/ _` |(_-<|  _|/ -_) | '_|
    // _|\_\\___|  \_, | |_|  |_|\__,_|/__/ \__|\___| |_|
    //             |__/


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
      play = continueGame(reader);
      System.out.println("What is your name hero?");
      String name = reader.readLine().trim();

      // Create game character
      Character character = new Character(name);

      // Repeat character name back
      System.out.println("Let the journey begin " + character.getName());

      // Create instance of game object

      // While playing
      while(play) {

        // Initiate player state in the world

        // Player movement and state updates


        play = continueGame(reader);

      }

    } catch (IOException e) {
      // Ignore exception for now

    }
  }


  private static boolean continueGame(BufferedReader reader) throws IOException {
    System.out.println("Would you like to continue (y/n)?");
    String response = reader.readLine().trim().toLowerCase();
    return response.equals("y");
  }

}
