package com.adaptionsoft.games.uglytrivia;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Question {

    LinkedList popQuestions = new LinkedList();
    LinkedList scienceQuestions = new LinkedList();
    LinkedList sportsQuestions = new LinkedList();
    LinkedList rockQuestions = new LinkedList();

    public Question() {
        initializeQuestions();
    }

    public String categoryFromPlace(int place) {
        List<Integer> placesWhichReturnPop = Arrays.asList(0, 4, 8);
        List<Integer> placesWhichReturnScience = Arrays.asList(1, 5, 9);
        List<Integer> placesWhichReturnSports = Arrays.asList(2, 6, 10);

        if (placesWhichReturnPop.contains(place)) return "Pop";
        if (placesWhichReturnScience.contains(place)) return "Science";
        if (placesWhichReturnSports.contains(place)) return "Sports";
        return "Rock";
    }

    void initializeQuestions() {
        for (int i = 0; i < 50; i++) {
            popQuestions.addLast("Pop Question " + i);
            scienceQuestions.addLast(("Science Question " + i));
            sportsQuestions.addLast(("Sports Question " + i));
            rockQuestions.addLast("Rock Question " + i);
        }
    }
}
