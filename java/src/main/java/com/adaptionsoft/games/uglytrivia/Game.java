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

        checkIfPlayerIsAllowedToMoveThenAskQuestionIfHeCan(roll);
    }

    private void checkIfPlayerIsAllowedToMoveThenAskQuestionIfHeCan(int roll) {
        if (!inPenaltyBox[currentPlayer]) {
            movePlayerAndAskQuestion(roll);
        }

        else if (inPenaltyBox[currentPlayer] && !thePlayerStayingInPenaltyBox(roll)) {
            playerIsGettingOutOfPenaltyBox();
            movePlayerAndAskQuestion(roll);
        }

        else {
            playerIsStayingInPenaltyBox();
        }
    }

    private void movePlayerAndAskQuestion(int roll) {
        nextPlace(roll);
        askQuestion();
    }
    private void playerIsGettingOutOfPenaltyBox() {
        isGettingOutOfPenaltyBox = true;
        displayer.showPrintLn(players.get(currentPlayer) + " is getting out of the penalty box");
    }
    private void playerIsStayingInPenaltyBox() {
        displayer.showPrintLn(players.get(currentPlayer) + " is not getting out of the penalty box");
        isGettingOutOfPenaltyBox = false;
    }

    private boolean thePlayerStayingInPenaltyBox(int roll) {
        return roll % 2 == 0;
    }

    public boolean thereIsNoWinner(int rand) {
        if (rand == 7) {
            wrongAnswer();
            return true;
        } else {
            return wasCorrectlyAnswered();
        }
    }

    private void nextPlace(int roll) {
        places[currentPlayer] += roll;
        if (places[currentPlayer] > 11) places[currentPlayer] = places[currentPlayer] - 12;

        displayer.showPrintLn(players.get(currentPlayer)
                + "'s new location is "
                + places[currentPlayer]);
    }

    private void askQuestion() {
        displayer.showPrintLn("The category is " + question.categoryFromPlace(places[currentPlayer]));

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
            if (!isGettingOutOfPenaltyBox) {
                nextPlayerTurn();
                return true;
            }
        }
        displayer.showPrintLn("Answer was correct!!!!");
        return correctlyAnsweredTodo();
    }

    private boolean correctlyAnsweredTodo() {
        purses[currentPlayer]++;
        displayer.showPrintLn(players.get(currentPlayer)
                + " now has "
                + purses[currentPlayer]
                + " Gold Coins.");

        nextPlayerTurn();
        return didPlayerWin();
    }

    private void nextPlayerTurn() {
        currentPlayer++;
        if (currentPlayer == howManyPlayers()) currentPlayer = 0;
    }

    public void wrongAnswer() {
        displayer.showPrintLn("Question was incorrectly answered");
        displayer.showPrintLn(players.get(currentPlayer) + " was sent to the penalty box");
        inPenaltyBox[currentPlayer] = true;
        nextPlayerTurn();
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

    private void initializeNewPlayerInPenaltyBox() {
        inPenaltyBox[howManyPlayers()] = false;
    }

    private void initializeNewPlayerPurse() {
        purses[howManyPlayers()] = 0;
    }

    private void initializeNewPlayerPlace() {
        places[howManyPlayers()] = 0;
    }

    private void addPlayerNameToPlayerList(String playerName) {
        players.add(playerName);
    }

    private int howManyPlayers() {
        return players.size();
    }


}
