package com.adaptionsoft.games.uglytrivia;

import java.util.Arrays;
import java.util.List;

public class Question {

    public String categoryFromPlace(int place) {
        List<Integer> placesWhichReturnPop = Arrays.asList(0, 4, 8);
        List<Integer> placesWhichReturnScience = Arrays.asList(1, 5, 9);
        List<Integer> placesWhichReturnSports = Arrays.asList(2, 6, 10);

        if (placesWhichReturnPop.contains(place)) return "Pop";
        if (placesWhichReturnScience.contains(place)) return "Science";
        if (placesWhichReturnSports.contains(place)) return "Sports";
        return "Rock";
    }

}
