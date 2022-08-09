package com.monsters.view;

import com.monsters.model.Game;
import com.monsters.model.Game.State;
import java.util.ResourceBundle;

public class TextGamePresentation implements GamePresentation {

  private final String characterStatusPattern;
  private final String gameSummaryPattern;
  private final String nextMovePattern;
  private final String winRoundPattern;
  private final String winGamePattern;
  private final String lostGamePattern;
  private final String roundStartPattern;
  private final String attackReportPattern;
  private final String movePromptPattern;
  private final String monsterNamePattern;
  private final String playerNamePattern;
  private final String illegalMovePattern;
  private final String playStatePattern;

  public TextGamePresentation(ResourceBundle bundle) {
    characterStatusPattern = bundle.getString(Keys.CHARACTER_STATUS);
    gameSummaryPattern = bundle.getString(Keys.GAME_SUMMARY);
    playStatePattern = bundle.getString(Keys.PLAY_STATE);
    nextMovePattern = bundle.getString(Keys.NEXT_MOVE);
    winRoundPattern = bundle.getString(Keys.WIN_ROUND);
    winGamePattern = bundle.getString(Keys.WIN_GAME);
    lostGamePattern = bundle.getString(Keys.LOST_GAME);
    roundStartPattern = bundle.getString(Keys.ROUND_START);
    attackReportPattern = bundle.getString(Keys.ATTACK_REPORT);
    movePromptPattern = bundle.getString(Keys.MOVE_PROMPT);
    monsterNamePattern = bundle.getString(Keys.MONSTER_NAME);
    playerNamePattern = bundle.getString(Keys.PLAYER_NAME);
    illegalMovePattern = bundle.getString(Keys.ILLEGAL_MOVE);
  }

  @Override
  public String stateRepresentation(Game game, String character, String monster) {
    String player = game.getState().isFinished() ? ((game.getState() == State.PLAYER_WIN) ? character : monster) : ((game.getState() == State.PLAYER_MOVE) ? character : monster);
    String next = game.getState().isFinished() ? String.format(winGamePattern, character) : String.format(playStatePattern, character);
    return String.format(gameSummaryPattern, game.getCharacterHealth(), game.getMonsterHealth(), game.getCharacterKeys());
  }

  @Override
  public Object characterStatusNotice(Game game, String player, String monster) {
    return null;
  }

  @Override
  public Object gameSummaryNotice() {
    return null;
  }

  @Override
  public Object nextMoveNotice(String player) {
    return String.format(nextMovePattern, player);
  }

  @Override
  public Object winRoundNotice(String characterName) {
    return null;
  }

  @Override
  public Object winGameNotice() {
    return null;
  }

  @Override
  public Object lostGameNotice() {
    return null;
  }

  @Override
  public Object roundStartNotice() {
    return null;
  }


  @Override
  public Object movePresentation(String player) {
    return String.format(attackReportPattern, player);
  }

  @Override
  public Object movePrompt(Game game) {
    return String.format(movePromptPattern); // attack, dodge?
  }

  @Override
  public Object illegalMoveNotification(Game game) {
    return String.format(illegalMovePattern); // must choose option 1 or 2
  }
}
