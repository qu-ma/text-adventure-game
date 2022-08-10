package com.monsters.view;

import com.monsters.model.Game;

public interface GamePresentation<T> {

  T stateRepresentation(Game game, String character, String monster);
  T characterStatusNotice (Game game);
  T gameSummaryNotice(Game game);
  T nextMoveNotice(String playerName);
  T runAwayNotice();
  T winRoundNotice(String characterName);
  T winGameNotice(String characterName);
  T lostGameNotice(String characterName);
  T roundStartNotice(String monsterName);
  T characterAttackReportNotice(Game game, String characterName, String monsterName);
  T monsterAttackReportNotice(Game game, String monsterName, String characterName);
  T monsterHealthReport(String monsterName, Game game);
  T movePrompt(Game game);
  T playAgainPrompt();
  T illegalMoveNotification();
  T illegalResponseNotification();
}
