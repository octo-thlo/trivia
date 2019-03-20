package com.adaptionsoft.games.uglytrivia;

import java.lang.reflect.Array;
import java.util.*;

public class Game {
    ArrayList players = new ArrayList();
    int[] places = new int[6];
    int[] purses = new int[6];
    boolean[] inPenaltyBox = new boolean[6];

	ArrayList logs = new ArrayList();

    LinkedList popQuestions = new LinkedList();
    LinkedList scienceQuestions = new LinkedList();
    LinkedList sportsQuestions = new LinkedList();
    LinkedList rockQuestions = new LinkedList();

    int currentPlayer = 0;
    boolean isGettingOutOfPenaltyBox;

    public Game() {
        for (int i = 0; i < 50; i++) {
            popQuestions.addLast("Pop Question " + i);
            scienceQuestions.addLast(("Science Question " + i));
            sportsQuestions.addLast(("Sports Question " + i));
            rockQuestions.addLast(createRockQuestion(i));
        }
    }

    public String createRockQuestion(int index) {
        return "Rock Question " + index;
    }

    public boolean addNewPlayer(String playerName) {


        addPlayerNameToPlayerList(playerName);
        initializeNewPlayerPlace();
        initializeNewPlayerPurse();
        initializeNewPlayerInPenaltyBox();

        showPrintLn(playerName + " was added");
        showPrintLn("They are player number " + players.size());
        return true;
    }


    public int howManyPlayers() {
        return players.size();
    }

    public void roll(int roll) {
        showPrintLn(players.get(currentPlayer) + " is the current player");
        showPrintLn("They have rolled a " + roll);

        if (inPenaltyBox[currentPlayer]) {
            if (roll % 2 != 0) {
                isGettingOutOfPenaltyBox = true;

                showPrintLn(players.get(currentPlayer) + " is getting out of the penalty box");
                places[currentPlayer] = places[currentPlayer] + roll;
                if (places[currentPlayer] > 11) places[currentPlayer] = places[currentPlayer] - 12;

                showPrintLn(players.get(currentPlayer)
                        + "'s new location is "
                        + places[currentPlayer]);
                showPrintLn("The category is " + categoryFromPlace(places[currentPlayer]));
                askQuestion();
            } else {
                showPrintLn(players.get(currentPlayer) + " is not getting out of the penalty box");
                isGettingOutOfPenaltyBox = false;
            }

        } else {

            places[currentPlayer] = places[currentPlayer] + roll;
            if (places[currentPlayer] > 11) places[currentPlayer] = places[currentPlayer] - 12;

            showPrintLn(players.get(currentPlayer)
                    + "'s new location is "
                    + places[currentPlayer]);
            showPrintLn("The category is " + categoryFromPlace(places[currentPlayer]));
            askQuestion();
        }

    }

    private void askQuestion() {
        if (categoryFromPlace(places[currentPlayer]) == "Pop")
            showPrintLn(popQuestions.removeFirst());
        if (categoryFromPlace(places[currentPlayer]) == "Science")
            showPrintLn(scienceQuestions.removeFirst());
        if (categoryFromPlace(places[currentPlayer]) == "Sports")
            showPrintLn(sportsQuestions.removeFirst());
        if (categoryFromPlace(places[currentPlayer]) == "Rock")
            showPrintLn(rockQuestions.removeFirst());
    }

    public boolean wasCorrectlyAnswered() {
        if (inPenaltyBox[currentPlayer]) {
            if (isGettingOutOfPenaltyBox) {
                showPrintLn("Answer was correct!!!!");
                purses[currentPlayer]++;
                showPrintLn(players.get(currentPlayer)
                        + " now has "
                        + purses[currentPlayer]
                        + " Gold Coins.");

                boolean winner = didPlayerWin();
                currentPlayer++;
                if (currentPlayer == players.size()) currentPlayer = 0;

                return winner;
            } else {
                currentPlayer++;
                if (currentPlayer == players.size()) currentPlayer = 0;
                return true;
            }


        } else {

            showPrintLn("Answer was corrent!!!!");
            purses[currentPlayer]++;
            showPrintLn(players.get(currentPlayer)
                    + " now has "
                    + purses[currentPlayer]
                    + " Gold Coins.");

            boolean winner = didPlayerWin();
            currentPlayer++;
            if (currentPlayer == players.size()) currentPlayer = 0;

            return winner;
        }
    }

    public boolean wrongAnswer() {
        showPrintLn("Question was incorrectly answered");
        showPrintLn(players.get(currentPlayer) + " was sent to the penalty box");
        inPenaltyBox[currentPlayer] = true;

        currentPlayer++;
        if (currentPlayer == players.size()) currentPlayer = 0;
        return true;
    }

    private String categoryFromPlace(int place) {
        List<Integer> placesWhichReturnPop = Arrays.asList(0, 4, 8);
        List<Integer> placesWhichReturnScience = Arrays.asList(1, 5, 9);
        List<Integer> placesWhichReturnSports = Arrays.asList(2, 6, 10);

        if (placesWhichReturnPop.contains(place)) return "Pop";
        if (placesWhichReturnScience.contains(place)) return "Science";
        if (placesWhichReturnSports.contains(place)) return "Sports";
        return "Rock";
    }


    private boolean didPlayerWin() {
        return !(purses[currentPlayer] == 6);
    }

    protected void showPrintLn(Object text) {
        System.out.println(text);
        logs.add(text);
    }

    protected void initializeNewPlayerInPenaltyBox() {
        inPenaltyBox[howManyPlayers()] = false;
    }

    protected void initializeNewPlayerPurse() {
        purses[howManyPlayers()] = 0;
    }

    protected void initializeNewPlayerPlace() {
        places[howManyPlayers()] = 0;
    }

    protected void addPlayerNameToPlayerList(String playerName) {
        players.add(playerName);
    }

	public String getLogs() {
		return logs.toString();
	}
}
