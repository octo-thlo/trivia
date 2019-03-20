package com.adaptionsoft.games.uglytrivia;

import java.util.*;

public class Game {
    
    private ArrayList<String> players = new ArrayList<>();
    private int[] places = new int[6];
    private int[] purses = new int[6];
    private boolean[] inPenaltyBox = new boolean[6];
    private int currentPlayer = 0;
    private boolean isGettingOutOfPenaltyBox;

    private Logger logger = new Logger();
    private Question question = new Question();

    public void addNewPlayer(String playerName) {
        addPlayerNameToPlayerList(playerName);
        logger.showPrintLn(playerName + " was added");
        logger.showPrintLn("They are player number " + players.size());
    }

    public void nextTurn(int roll) {
        logger.roll(players.get(currentPlayer), roll);
        checkIfPlayerIsAllowedToMoveThenAskQuestionIfHeCan(roll);
    }

    public boolean thereIsNoWinner(int rand) {
        if (theAnswerIsWrong(rand)) {
            wrongAnswer();
            return true;
        } else {
            return wasCorrectlyAnswered();
        }
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
        logger.showPrintLn(players.get(currentPlayer) + " is getting out of the penalty box");
    }

    private void playerIsStayingInPenaltyBox() {
        logger.showPrintLn(players.get(currentPlayer) + " is not getting out of the penalty box");
        isGettingOutOfPenaltyBox = false;
    }

    private boolean thePlayerStayingInPenaltyBox(int roll) {
        return roll % 2 == 0;
    }

    private boolean theAnswerIsWrong(int roll) {
        return roll == 7;
    }

    private void nextPlace(int roll) {
        places[currentPlayer] += roll;
        if (places[currentPlayer] > 11) places[currentPlayer] = places[currentPlayer] - 12;

        logger.showPrintLn(players.get(currentPlayer)
                + "'s new location is "
                + places[currentPlayer]);
    }

    private void askQuestion() {
        logger.showPrintLn("The category is " + question.categoryFromPlace(places[currentPlayer]));

        logger.showPrintLn(question.nextQuestion(places[currentPlayer]));
    }

    private boolean wasCorrectlyAnswered() {
        if (inPenaltyBox[currentPlayer]) {
            if (!isGettingOutOfPenaltyBox) {
                nextPlayerTurn();
                return true;
            }
        }
        logger.showPrintLn("Answer was correct!!!!");
        return correctlyAnsweredTodo();
    }

    private boolean correctlyAnsweredTodo() {
        purses[currentPlayer]++;
        logger.showPrintLn(players.get(currentPlayer)
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

    private void wrongAnswer() {
        logger.showPrintLn("Question was incorrectly answered");
        logger.showPrintLn(players.get(currentPlayer) + " was sent to the penalty box");
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

    private void addPlayerNameToPlayerList(String playerName) {
        players.add(playerName);
    }

    private int howManyPlayers() {
        return players.size();
    }


    public String getLogs() {
        return logger.logs.toString();
    }

    public ArrayList<String> getPlayers() {
        return players;
    }

    public int[] getPlaces() {
        return places;
    }

    public int[] getPurses() {
        return purses;
    }

    public boolean[] getInPenaltyBox() {
        return inPenaltyBox;
    }
}
