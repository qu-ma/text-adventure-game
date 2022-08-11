package com.monsters;

import com.monsters.controller.DungeonMaster;
import com.monsters.model.Game;
import com.monsters.model.Game.State;
import com.monsters.model.Monster;
import com.monsters.model.exception.IllegalMoveException;
import com.monsters.view.TextGamePresentation;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import com.monsters.model.Character;
import java.util.ResourceBundle;
import org.w3c.dom.Text;

public class Main {

  private static final String BUNDLE_NAME = "strings";

  public static void main(String[] args) {

    System.out.println(" '########::'##::::'##:'##::: ##::'######:::'########::'#######::'##::: ##::::'##::::'##::::'###:::::'######::'########:'########:'########::");
    System.out.println(" ##.... ##: ##:::: ##: ###:: ##:'##... ##:: ##.....::'##.... ##: ###:: ##:::: ###::'###:::'## ##:::'##... ##:... ##..:: ##.....:: ##.... ##:");
    System.out.println(" ##:::: ##: ##:::: ##: ####: ##: ##:::..::: ##::::::: ##:::: ##: ####: ##:::: ####'####::'##:. ##:: ##:::..::::: ##:::: ##::::::: ##:::: ##:");
    System.out.println(" ##:::: ##: ##:::: ##: ## ## ##: ##::'####: ######::: ##:::: ##: ## ## ##:::: ## ### ##:'##:::. ##:. ######::::: ##:::: ######::: ########::");
    System.out.println(" ##:::: ##: ##:::: ##: ##. ####: ##::: ##:: ##...:::: ##:::: ##: ##. ####:::: ##. #: ##: #########::..... ##:::: ##:::: ##...:::: ##.. ##:::");
    System.out.println(" ##:::: ##: ##:::: ##: ##:. ###: ##::: ##:: ##::::::: ##:::: ##: ##:. ###:::: ##:.:: ##: ##.... ##:'##::: ##:::: ##:::: ##::::::: ##::. ##::");
    System.out.println(" ########::. #######:: ##::. ##:. ######::: ########:. #######:: ##::. ##:::: ##:::: ##: ##:::: ##:. ######::::: ##:::: ########: ##:::. ##:");
    System.out.println("........::::.......:::..::::..:::......::::........:::.......:::..::::..:::::..:::::..::..:::::..:::......::::::..:::::........::..:::::..::");

    ResourceBundle bundle = ResourceBundle.getBundle(BUNDLE_NAME);

    try (
        Reader input = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input)
    ) {

      TextGamePresentation presentation = new TextGamePresentation(bundle);
      // Generate world and monsters

      // Let play = true
      boolean play = true;

      System.out.println("Welcome to Dungeon Master! Your task, should you choose to accept it"
          + "is to destroy all monsters and collect their keys.\n");

      System.out.println("What is your name hero?");
      String name = reader.readLine().trim();

      Character character = new Character(name, 100);

      System.out.println("Let the journey begin " + character.getName() + "!");

      Game.State state = Game.State.PLAYER_MOVE;
      Monster monster = new Monster("Lord Toaster Child", 25, 1);
      Game game = new Game(state, character, monster);

      DungeonMaster dungeonMaster = new DungeonMaster(reader, monster, character, game,
          presentation);

      while (continueGame(reader, character, game, presentation)) {
        dungeonMaster.battleMonster();
      }

      System.out.println(
          game.getCharacterName() + " has acquired " + game.getCharacterKeys()
              + " number of keys.");

      if (game.getCharacterKeys() == 3) {
        System.out.println(presentation.winGameNotice(game.getCharacterName()));
      } else {
        dungeonMaster.gameOver();
        // System.out.println(presentation.lostGameNotice(game.getCharacterName()));
      }


    } catch (IOException e) {
      throw new RuntimeException(e);

    }
  }

  private static boolean continueGame(BufferedReader reader, Character character, Game game,
      TextGamePresentation presentation)
      throws IOException {
    boolean status = true;

    if (character.getHealth() <= 0 || character.getKeys() == 3) {
      return false;
    }

    System.out.println("Would you like to continue (y/n)?");

    String response = reader.readLine().trim().toLowerCase();
    //NOTE: doesn't throw Exception on first invalid response.

    if(!response.equals("n") && !response.equals("y")) {
      System.out.println(presentation.illegalResponseNotification());
      while (!response.equals("n") && !response.equals("y")) {
        try {
          System.out.println("Would you like to continue (y/n)?");
          response = reader.readLine().trim().toLowerCase();
          if (!response.equals("n") && !response.equals("y")) {
            throw new IllegalMoveException((String) presentation.illegalResponseNotification());
          }
        } catch (IllegalMoveException e) {
          System.out.println(presentation.illegalResponseNotification());
        }
      }
    }

    status = response.equals("y");

    return status;
  }


}
