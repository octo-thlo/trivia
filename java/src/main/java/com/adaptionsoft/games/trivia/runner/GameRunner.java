
package com.adaptionsoft.games.trivia.runner;

import java.util.Random;

import com.adaptionsoft.games.uglytrivia.Game;

public class GameRunner {

    public static void main(String[] args) {
        Game aGame = new Game();

        aGame.addNewPlayer("Chet");
        aGame.addNewPlayer("Pat");
        aGame.addNewPlayer("Sue");

        Random rand = new Random();
        int ran;

        do {
            int randomRoll = rand.nextInt(5) + 1;

            ran = rand.nextInt(9);
            aGame.nextTurn(randomRoll);

        } while (aGame.thereIsNoWinner(ran));
    }
}
