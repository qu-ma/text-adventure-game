package com.monsters.view;

import com.monsters.model.Game;

public interface GamePresentation<T> {

  T stateRepresentation(Game game, String character, String monster);

  T characterStatusNotice (Game game, String character, String monster);

  T gameSummaryNotice();

  T nextMoveNotice(String character);

  T winRoundNotice(String characterName);

  T winGameNotice();

  T lostGameNotice();

  T roundStartNotice();

  T movePresentation(String player);

  T movePrompt(Game game);

  T illegalMoveNotification(Game game);

}
