package com.adaptionsoft.games.uglytrivia;

import java.util.ArrayList;

public class Logger {
    ArrayList<Object> logs = new ArrayList<>();

    void showPrintLn(Object text) {
        System.out.println(text);
        logs.add(text);
    }

    public void roll(String playerName, int roll) {
        showPrintLn(playerName + " is the current player");
        showPrintLn("They have rolled a " + roll);
    }
}
