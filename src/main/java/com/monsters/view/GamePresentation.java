package com.monsters.view;

public interface GamePresentation<T> {

  T characterStatusNotice (Game game, String player, String monster);

  T gameSummaryNotice;

  T nextMoveNotice(String player);

  T winRoundNotice(String playerName);

  T winGameNotice();

  T lostGameNotice();

  T roundStartNotice();



  T movePresentation(String player);

  T movePrompt(Game game);

  T illegalMoveNotification(Game game);

}
