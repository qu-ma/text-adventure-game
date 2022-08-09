# High Level Pseudo-Code

* Generate world and monster
* Let playing = true
* While playing:
    * Initialize player state in the world
    * Player movement & state updates
    * Let playing = user input to play again
## Generate world and monster

* TBD

## Initialize player state in world

* TBD

## Player movement & State updates

* While player still has hp and has yet to collect 3 keys, game continues;
    * Present current state to player
    * Ask user for desired action
    * Calculate result of action and update state of the world
    * Present the outcome of action to user

##    //TextGamePresentation.java
//TextGamePresentation
//IllegalMoveNotification
//movePresentation
//movePrompt
//nextMoveNotice

// DONE
//stateRepresentation (character, game, monster) - Before and after a full round
//Number of keys character has
//Health of character


//roundRepresentations : (character, game, monster) - Happens during a round
//Health: char, monster
//Attack strength

//winPresentation : (character, monster, game)
//who won (string msg)

//losePresentation : (character, monster, game)
//who lost
//HP, Number of Keys, character, monster, game, 


## //Game.java
//HP, Number of Keys, character, monster, game, (Needed to pass to view)
//Create Character reference
//Create Monster reference
//Initialize monster reference thats passed in
//Create get health method for game objects to give to TextGamePresentation
//Includes keys

## //DungeonMaster.java
    //Fields
    //Buffer reader - to read stuff from console
    //Character name
    //Monster
    //Game class



//Method for battle : ()
//

//Method for gameOver: ()
//

//Method for gameCompleted: ()
//

//Method for gameWon: ()
//
