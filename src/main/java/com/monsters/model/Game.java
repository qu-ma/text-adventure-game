package com.monsters.model;

import java.sql.Statement;


public class Game {

  public static final int ATTACK_MOVE = 1;
  private boolean firstMove;
  public State state;

  public Monster monster;

public Game(State initialState, Character character, Monster monster){
  this.firstMove = true;
  state = initialState;
  this.monster = monster;

  }





  public enum State{
    PLAYER_MOVE{
      @Override
      public boolean isAtStart(){
        return true;
      }
      @Override
      public boolean isFinished(){
        return false;
      }
      @Override
      public State nextMoveState(){
        return MONSTER_MOVE;
      }
      @Override
      public State nextWinState(){
        return MONSTER_WIN;
      }

    },

    MONSTER_MOVE{
      @Override
      public boolean isAtStart(){
        return true;
      }
      @Override
      public boolean isFinished(){
        return false;
      }
      @Override
      public State nextMoveState(){
        return PLAYER_MOVE;
      }
      @Override
      public State nextWinState(){
        return PLAYER_WIN;
      }

    },

    PLAYER_WIN,
    MONSTER_WIN;

    private static final String NO_MOVES_ALLOWED_FORMAT = "Game is already in a finished state (HP = %d); no further moves possible";


    public boolean isAtStart(){
      return false;
    }

    public boolean isFinished(){
      return false;
    }

    public State nextMoveState(){
      return null;
    }

    public State nextWinState(){
      return this;
    }

    public State play(int currentMonsterHP, int currentPlayerHP, int attackPower, int numberOfKeysPlayerHolds){
    return this.nextMoveState();
    }

  }

}
