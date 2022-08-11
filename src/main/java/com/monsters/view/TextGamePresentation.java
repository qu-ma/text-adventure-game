package com.monsters.view;

import com.monsters.model.Game;
import com.monsters.model.Game.State;
import java.util.ResourceBundle;

public class TextGamePresentation implements GamePresentation {

  private final String characterStatusPattern;
  private final String gameSummaryPattern;
  private final String nextMovePattern;
  private final String runAwayPattern;
  private final String winRoundPattern;
  private final String winGamePattern;
  private final String lostGamePattern;
  private final String roundStartPattern;
  private final String characterAttackReportPattern;
  private final String monsterAttackReportPattern;
  private final String monsterHealthReportPattern;
  private final String movePromptPattern;
  private final String monsterNamePattern;
  private final String playerNamePattern;
  private final String playAgainPattern;
  private final String illegalMovePattern;
  private final String illegalResponsePattern;
  private final String playStatePattern;

  public TextGamePresentation(ResourceBundle bundle) {
    characterStatusPattern = bundle.getString(Keys.CHARACTER_STATUS);
    gameSummaryPattern = bundle.getString(Keys.GAME_SUMMARY);
    playStatePattern = bundle.getString(Keys.PLAY_STATE);
    nextMovePattern = bundle.getString(Keys.NEXT_MOVE);
    runAwayPattern = bundle.getString(Keys.RUN_AWAY);
    winRoundPattern = bundle.getString(Keys.WIN_ROUND);
    winGamePattern = bundle.getString(Keys.WIN_GAME);
    lostGamePattern = bundle.getString(Keys.LOST_GAME);
    roundStartPattern = bundle.getString(Keys.ROUND_START);
    characterAttackReportPattern = bundle.getString(Keys.CHARACTER_ATTACK_REPORT);
    monsterAttackReportPattern = bundle.getString(Keys.MONSTER_ATTACK_REPORT);
    monsterHealthReportPattern = bundle.getString(Keys.MONSTER_HEALTH_REPORT);
    movePromptPattern = bundle.getString(Keys.MOVE_PROMPT);
    monsterNamePattern = bundle.getString(Keys.MONSTER_NAME);
    playerNamePattern = bundle.getString(Keys.PLAYER_NAME);
    playAgainPattern = bundle.getString(Keys.PLAY_AGAIN);
    illegalMovePattern = bundle.getString(Keys.ILLEGAL_MOVE);
    illegalResponsePattern = bundle.getString(Keys.ILLEGAL_RESPONSE);
  }

  @Override
  public String stateRepresentation(Game game, String character, String monster) {
    String player =
        game.getState().isFinished() ? ((game.getState() == State.PLAYER_WIN) ? character : monster)
            : ((game.getState() == State.PLAYER_MOVE) ? character : monster);
    String next = game.getState().isFinished() ? String.format(winGamePattern, player)
        : String.format(playStatePattern, player);
    return String.format(gameSummaryPattern, game.getCharacterHealth(), game.getMonsterHealth(),
        game.getCharacterKeys(), next);
  }

  @Override
  public Object characterStatusNotice(Game game) {
    return String.format(characterStatusPattern, game.getCharacterHealth(),
        game.getCharacterKeys());
  }

  @Override
  public Object gameSummaryNotice(Game game) {
    return String.format(gameSummaryPattern, game.getCharacterHealth(), game.getMonsterHealth(),
        game.getCharacterKeys());
  }

  @Override
  public Object nextMoveNotice(String playerName) {
    return String.format(nextMovePattern, playerName);
  }

  @Override
  public Object runAwayNotice() {
    return String.format(runAwayPattern);
  }

  @Override
  public Object winRoundNotice(String characterName) {
    return String.format(winRoundPattern, characterName);
  }

  @Override
  public Object winGameNotice(String characterName) {
    return String.format(winGamePattern, characterName);
  }

  @Override
  public Object lostGameNotice(String characterName) {
    return String.format(lostGamePattern, characterName);
  }

  @Override
  public Object roundStartNotice(String monsterName) {
    return String.format(roundStartPattern, monsterName);
  }

  @Override
  public Object characterAttackReportNotice(Game game, String characterName, String monsterName) {
    return String.format(characterAttackReportPattern, characterName,
        game.getCharacterAttackDamage(), monsterName);
  }

  @Override
  public Object monsterAttackReportNotice(Game game, String monsterName, String characterName) {
    return String.format(monsterAttackReportPattern, monsterName, game.getMonsterAttackDamage(),
        characterName);
  }

  @Override
  public Object monsterHealthReport(String monsterName, Game game) {
    return String.format(monsterHealthReportPattern, monsterName, game.getMonsterHealth());
  }

  @Override
  public Object movePrompt(Game game) {
    return String.format(movePromptPattern, game.ATTACK_MOVE);
  }

  @Override
  public Object playAgainPrompt() {
    return String.format(playAgainPattern);
  }

  @Override
  public Object illegalMoveNotification() {
    return String.format(illegalMovePattern);
  }

  @Override
  public Object illegalResponseNotification() {
    return String.format(illegalResponsePattern);
  }
}
