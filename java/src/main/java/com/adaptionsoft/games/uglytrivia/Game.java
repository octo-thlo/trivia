package com.adaptionsoft.games.uglytrivia;

import java.util.*;

public class Game {
    ArrayList players = new ArrayList();
    int[] places = new int[6];
    int[] purses = new int[6];
    boolean[] inPenaltyBox = new boolean[6];
    Displayer displayer = new Displayer();
    Question question = new Question();

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
            rockQuestions.addLast("Rock Question " + i);
        }
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


    public int howManyPlayers() {
        return players.size();
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
            displayer.showPrintLn(popQuestions.removeFirst());
        if (question.categoryFromPlace(places[currentPlayer]) == "Science")
            displayer.showPrintLn(scienceQuestions.removeFirst());
        if (question.categoryFromPlace(places[currentPlayer]) == "Sports")
            displayer.showPrintLn(sportsQuestions.removeFirst());
        if (question.categoryFromPlace(places[currentPlayer]) == "Rock")
            displayer.showPrintLn(rockQuestions.removeFirst());
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
        if (currentPlayer == players.size()) currentPlayer = 0;
    }

    public boolean wrongAnswer() {
        displayer.showPrintLn("Question was incorrectly answered");
        displayer.showPrintLn(players.get(currentPlayer) + " was sent to the penalty box");
        inPenaltyBox[currentPlayer] = true;

        nextPlayerTurn();
        return true;
    }




    private boolean didPlayerWin() {
        return !(purses[currentPlayer] == 6);
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


}
