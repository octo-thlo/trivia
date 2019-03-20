package com.adaptionsoft.games.uglytrivia;

import java.util.*;

public class Game {
    ArrayList players = new ArrayList();
    int[] places = new int[6];
    int[] purses = new int[6];
    boolean[] inPenaltyBox = new boolean[6];
    Displayer displayer = new Displayer();
    Question question = new Question();

    int currentPlayer = 0;
    boolean isGettingOutOfPenaltyBox;

    public Game() {

    }

    public boolean addNewPlayer(String playerName) {


        addPlayerNameToPlayerList(playerName);
        initializeNewPlayerPlace();
        initializeNewPlayerPurse();
        initializeNewPlayerInPenaltyBox();

        displayer.showPrintLn(playerName + " was added");
        displayer.showPrintLn("They are player number " + players.size());
        return true;
    }




    public void roll(int roll) {
        displayer.showPrintLn(players.get(currentPlayer) + " is the current player");
        displayer.showPrintLn("They have rolled a " + roll);

        if (inPenaltyBox[currentPlayer]) {
            if (roll % 2 != 0) {
                isGettingOutOfPenaltyBox = true;

                displayer.showPrintLn(players.get(currentPlayer) + " is getting out of the penalty box");
                places[currentPlayer] = places[currentPlayer] + roll;
                if (places[currentPlayer] > 11) places[currentPlayer] = places[currentPlayer] - 12;

                displayer.showPrintLn(players.get(currentPlayer)
                        + "'s new location is "
                        + places[currentPlayer]);
                displayer.showPrintLn("The category is " + question.categoryFromPlace(places[currentPlayer]));
                askQuestion();
            } else {
                displayer.showPrintLn(players.get(currentPlayer) + " is not getting out of the penalty box");
                isGettingOutOfPenaltyBox = false;
            }

        } else {

            places[currentPlayer] = places[currentPlayer] + roll;
            if (places[currentPlayer] > 11) places[currentPlayer] = places[currentPlayer] - 12;

            displayer.showPrintLn(players.get(currentPlayer)
                    + "'s new location is "
                    + places[currentPlayer]);
            displayer.showPrintLn("The category is " + question.categoryFromPlace(places[currentPlayer]));
            askQuestion();
        }

    }

    private void askQuestion() {
        if (question.categoryFromPlace(places[currentPlayer]) == "Pop")
            displayer.showPrintLn(question.popQuestions.removeFirst());
        if (question.categoryFromPlace(places[currentPlayer]) == "Science")
            displayer.showPrintLn(question.scienceQuestions.removeFirst());
        if (question.categoryFromPlace(places[currentPlayer]) == "Sports")
            displayer.showPrintLn(question.sportsQuestions.removeFirst());
        if (question.categoryFromPlace(places[currentPlayer]) == "Rock")
            displayer.showPrintLn(question.rockQuestions.removeFirst());
    }

    public boolean wasCorrectlyAnswered() {
        if (inPenaltyBox[currentPlayer]) {
            if (isGettingOutOfPenaltyBox) {
                displayer.showPrintLn("Answer was correct!!!!");
                purses[currentPlayer]++;
                displayer.showPrintLn(players.get(currentPlayer)
                        + " now has "
                        + purses[currentPlayer]
                        + " Gold Coins.");

                boolean winner = didPlayerWin();
                nextPlayerTurn();

                return winner;
            } else {
                nextPlayerTurn();
                return true;
            }


        } else {

            displayer.showPrintLn("Answer was corrent!!!!");
            purses[currentPlayer]++;
            displayer.showPrintLn(players.get(currentPlayer)
                    + " now has "
                    + purses[currentPlayer]
                    + " Gold Coins.");

            boolean winner = didPlayerWin();
            nextPlayerTurn();

            return winner;
        }
    }

    private void nextPlayerTurn() {
        currentPlayer++;
        if (currentPlayer == howManyPlayers()) currentPlayer = 0;
    }

    public boolean wrongAnswer() {
        displayer.showPrintLn("Question was incorrectly answered");
        displayer.showPrintLn(players.get(currentPlayer) + " was sent to the penalty box");
        inPenaltyBox[currentPlayer] = true;

        nextPlayerTurn();
        return true;
    }




    private boolean didPlayerWin() {
        if (purses[currentPlayer] == 6) {
            return false;
        } else {
            return true;
        }
    }

    public String getLogs() {
        return displayer.logs.toString();
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

    private int howManyPlayers() {
        return players.size();
    }


}
