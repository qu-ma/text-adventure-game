package com.monsters.model;

import com.monsters.model.exception.GameFinishedException;
import com.monsters.model.exception.IllegalMoveException;
import java.sql.Statement;


public class Game {

  public static final int ATTACK_MOVE = 1;
  private boolean firstMove;
  private State state;
  public Monster monster;
  public Character character;


public Game(State initialState, Character character, Monster monster){
  this.firstMove = true;
  state = initialState;
  this.monster = monster;
  this.character = character;
  }

  public void play(int userMove) {
    state = state.play(getCharacterHealth(), getMonsterHealth(), getCharacterKeys(), userMove);
//    currentCount += move * direction.getSign(); Need to get the health of whichever characters turn it is at that moment
    firstMove = false;
  }
public State getState(){
  return state;
}

  public int getMonsterHealth() {
    return monster.getHealth();
  }

  public int getCharacterHealth() {
    return character.getHealth();
  }

  public int getCharacterKeys() {
    return character.getKeys();
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
      public State nextWinEntireGameState(){
        return MONSTER_WIN;
      }
      @Override
      public State nextLostState(){
        return MONSTER_WIN;
      }
      @Override
      public State nextWinRoundState(){
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
      public State nextWinEntireGameState(){
        return PLAYER_WIN;
      }
      @Override
      public State nextLostState(){
        return PLAYER_WIN;
      }
      @Override
      public State nextWinRoundState(){
        return PLAYER_WIN;
      }


    },

    PLAYER_WIN,
    MONSTER_WIN;
    //Bonus strings. Move to strings.properties file??????
    private static final String NO_MOVES_ALLOWED_FORMAT = "Game is already in a finished state (HP = %d); no further moves possible";
    private static final String INVALID_MOVE = "This move is not an option.";

    public boolean isAtStart(){
      return false;
    }

    public boolean isFinished(){
      return false;
    }

    public State nextMoveState(){
      return null;
    }

    public State nextWinEntireGameState(){
      return this;
    }
    public State nextLostState(){
      return this;
    }

    public State nextWinRoundState(){
      return this;
    }


    //Still no random number generator for attack strength
      public State play(int characterHealth, int monsterHealth, int keysCharacterHas, int userMove)
        throws GameFinishedException, IllegalMoveException {
        State nextState = null;
        if (isFinished()) {
          throw new GameFinishedException(String.format(NO_MOVES_ALLOWED_FORMAT, characterHealth));
        }
        if (ATTACK_MOVE != userMove) {
          throw new IllegalMoveException(
              String.format(INVALID_MOVE, userMove));
        }
//        int newCount = count + move * sign;

        if (characterHealth > 0 && monsterHealth <= 0) {
          nextState = nextWinRoundState();
        } else if(characterHealth > 0 && monsterHealth > 0){
          nextState = nextMoveState();
        }else if(characterHealth <= 0){
          nextState = nextLostState();
        }else if(keysCharacterHas == 3){
          nextState = nextWinEntireGameState();
        }

        return nextState;
      }



  }

}
