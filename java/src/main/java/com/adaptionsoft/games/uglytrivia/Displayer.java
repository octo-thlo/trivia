package com.adaptionsoft.games.uglytrivia;

import java.util.ArrayList;

public class Displayer {
    ArrayList logs = new ArrayList();
    protected void showPrintLn(Object text) {
        System.out.println(text);
        logs.add(text);
    }
}
