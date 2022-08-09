package com.monsters.view;

import com.monsters.model.Game;

public interface GamePresentation<T> {

  T characterStatusNotice (Game game, String player, String monster);

  T gameSummaryNotice();

  Object stateRepresentation(Game game, String player, String monster);

  T nextMoveNotice(String player);

  T winRoundNotice(String playerName);

  T winGameNotice();

  T lostGameNotice();

  T roundStartNotice();



  T movePresentation(String player);

  T movePrompt(Game game);

  T illegalMoveNotification(Game game);

}
