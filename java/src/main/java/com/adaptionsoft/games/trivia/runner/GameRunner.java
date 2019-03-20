
package com.adaptionsoft.games.trivia.runner;

import java.util.ArrayList;
import java.util.Random;

import com.adaptionsoft.games.uglytrivia.Game;
import com.adaptionsoft.games.uglytrivia.Displayer;


public class GameRunner {

private static ArrayList<String> rolls = new ArrayList<String>();

    private static boolean notAWinner;
    private static String logs;

    public static void main(String[] args) {
        Game aGame = new Game();
        Displayer displayer = new Displayer();

        aGame.addNewPlayer("Chet");
        aGame.addNewPlayer("Pat");
        aGame.addNewPlayer("Sue");

        Random rand = new Random();

        do {
            int randomRoll = rand.nextInt(5) + 1;
            aGame.roll(randomRoll);

            int ran = rand.nextInt(9);
            if (ran == 7) {
                notAWinner = aGame.wrongAnswer();
                addToRolls(String.valueOf(randomRoll) + "." + ran);
            } else {
                notAWinner = aGame.wasCorrectlyAnswered();
                addToRolls(String.valueOf(randomRoll) + "." + ran);

            }


        } while (notAWinner);
        logs = aGame.getLogs();
        System.out.println(logs);
        System.out.println(getRolls());
    }

    public static String getRolls() {
        return rolls.toString();
    }

    protected static void addToRolls(String text) {
        rolls.add(text);
    }
}
