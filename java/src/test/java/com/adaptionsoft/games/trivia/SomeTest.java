package com.adaptionsoft.games.trivia;

import com.adaptionsoft.games.uglytrivia.Game;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class SomeTest {

    @Test
    public void goldenMasterOneTest() {
        //given
        int[] lucky = {4, 0, 1, 7, 7, 3, 3, 0, 5, 8, 1, 7, 7, 2, 7, 7, 5, 3, 1, 4, 0, 0, 3, 5, 4, 2, 1, 7, 0, 1};
        int[] rolls = {3, 3, 3, 3, 4, 3, 5, 5, 5, 4, 2, 4, 3, 1, 2, 1, 1, 3, 4, 2, 2, 5, 2, 2, 2, 1, 3, 4, 4, 5};

        Game aGame = new Game();
        //when
        aGame.addNewPlayer("Chet");
        aGame.addNewPlayer("Pat");
        aGame.addNewPlayer("Sue");

        int index = 0;
        for (int roll: rolls) {
            aGame.roll(roll);
            aGame.thereIsNoWinner(lucky[index]);
            index++;
        }

        //then
        String expectedLogs = "[Chet was added, They are player number 1, Pat was added, They are player number 2, Sue was added, They are player number 3, Chet is the current player, They have rolled a 3, Chet's new location is 3, The category is Rock, Rock Question 0, Answer was correct!!!!, Chet now has 1 Gold Coins., Pat is the current player, They have rolled a 3, Pat's new location is 3, The category is Rock, Rock Question 1, Answer was correct!!!!, Pat now has 1 Gold Coins., Sue is the current player, They have rolled a 3, Sue's new location is 3, The category is Rock, Rock Question 2, Answer was correct!!!!, Sue now has 1 Gold Coins., Chet is the current player, They have rolled a 3, Chet's new location is 6, The category is Sports, Sports Question 0, Question was incorrectly answered, Chet was sent to the penalty box, Pat is the current player, They have rolled a 4, Pat's new location is 7, The category is Rock, Rock Question 3, Question was incorrectly answered, Pat was sent to the penalty box, Sue is the current player, They have rolled a 3, Sue's new location is 6, The category is Sports, Sports Question 1, Answer was correct!!!!, Sue now has 2 Gold Coins., Chet is the current player, They have rolled a 5, Chet is getting out of the penalty box, Chet's new location is 11, The category is Rock, Rock Question 4, Answer was correct!!!!, Chet now has 2 Gold Coins., Pat is the current player, They have rolled a 5, Pat is getting out of the penalty box, Pat's new location is 0, The category is Pop, Pop Question 0, Answer was correct!!!!, Pat now has 2 Gold Coins., Sue is the current player, They have rolled a 5, Sue's new location is 11, The category is Rock, Rock Question 5, Answer was correct!!!!, Sue now has 3 Gold Coins., Chet is the current player, They have rolled a 4, Chet is not getting out of the penalty box, Pat is the current player, They have rolled a 2, Pat is not getting out of the penalty box, Sue is the current player, They have rolled a 4, Sue's new location is 3, The category is Rock, Rock Question 6, Question was incorrectly answered, Sue was sent to the penalty box, Chet is the current player, They have rolled a 3, Chet is getting out of the penalty box, Chet's new location is 2, The category is Sports, Sports Question 2, Question was incorrectly answered, Chet was sent to the penalty box, Pat is the current player, They have rolled a 1, Pat is getting out of the penalty box, Pat's new location is 1, The category is Science, Science Question 0, Answer was correct!!!!, Pat now has 3 Gold Coins., Sue is the current player, They have rolled a 2, Sue is not getting out of the penalty box, Question was incorrectly answered, Sue was sent to the penalty box, Chet is the current player, They have rolled a 1, Chet is getting out of the penalty box, Chet's new location is 3, The category is Rock, Rock Question 7, Question was incorrectly answered, Chet was sent to the penalty box, Pat is the current player, They have rolled a 1, Pat is getting out of the penalty box, Pat's new location is 2, The category is Sports, Sports Question 3, Answer was correct!!!!, Pat now has 4 Gold Coins., Sue is the current player, They have rolled a 3, Sue is getting out of the penalty box, Sue's new location is 6, The category is Sports, Sports Question 4, Answer was correct!!!!, Sue now has 4 Gold Coins., Chet is the current player, They have rolled a 4, Chet is not getting out of the penalty box, Pat is the current player, They have rolled a 2, Pat is not getting out of the penalty box, Sue is the current player, They have rolled a 2, Sue is not getting out of the penalty box, Chet is the current player, They have rolled a 5, Chet is getting out of the penalty box, Chet's new location is 8, The category is Pop, Pop Question 1, Answer was correct!!!!, Chet now has 3 Gold Coins., Pat is the current player, They have rolled a 2, Pat is not getting out of the penalty box, Sue is the current player, They have rolled a 2, Sue is not getting out of the penalty box, Chet is the current player, They have rolled a 2, Chet is not getting out of the penalty box, Pat is the current player, They have rolled a 1, Pat is getting out of the penalty box, Pat's new location is 3, The category is Rock, Rock Question 8, Answer was correct!!!!, Pat now has 5 Gold Coins., Sue is the current player, They have rolled a 3, Sue is getting out of the penalty box, Sue's new location is 9, The category is Science, Science Question 1, Answer was correct!!!!, Sue now has 5 Gold Coins., Chet is the current player, They have rolled a 4, Chet is not getting out of the penalty box, Question was incorrectly answered, Chet was sent to the penalty box, Pat is the current player, They have rolled a 4, Pat is not getting out of the penalty box, Sue is the current player, They have rolled a 5, Sue is getting out of the penalty box, Sue's new location is 2, The category is Sports, Sports Question 5, Answer was correct!!!!, Sue now has 6 Gold Coins.]";
        assertEquals(expectedLogs, aGame.getLogs());
    }

    @Test
    public void goldenMasterTwoTest() {
        //given
        int[] lucky = {7 ,3 ,8 ,0 ,4 ,7 ,8 ,2 ,3 ,1 ,2 ,1 ,3 ,2 ,5 ,4 ,0 ,0 ,3};
        int[] rolls = {3, 3, 2, 5, 4, 5, 1, 3, 1, 4, 1, 4, 2, 3, 5, 5, 1, 3, 5};

        Game aGame = new Game();
        //when
        aGame.addNewPlayer("Chet");
        aGame.addNewPlayer("Pat");
        aGame.addNewPlayer("Sue");

        int index = 0;
        for (int roll: rolls) {
            aGame.roll(roll);
            aGame.thereIsNoWinner(lucky[index]);
            index++;
        }

        //then
        String expectedLogs = "[Chet was added, They are player number 1, Pat was added, They are player number 2, Sue was added, They are player number 3, Chet is the current player, They have rolled a 3, Chet's new location is 3, The category is Rock, Rock Question 0, Question was incorrectly answered, Chet was sent to the penalty box, Pat is the current player, They have rolled a 3, Pat's new location is 3, The category is Rock, Rock Question 1, Answer was correct!!!!, Pat now has 1 Gold Coins., Sue is the current player, They have rolled a 2, Sue's new location is 2, The category is Sports, Sports Question 0, Answer was correct!!!!, Sue now has 1 Gold Coins., Chet is the current player, They have rolled a 5, Chet is getting out of the penalty box, Chet's new location is 8, The category is Pop, Pop Question 0, Answer was correct!!!!, Chet now has 1 Gold Coins., Pat is the current player, They have rolled a 4, Pat's new location is 7, The category is Rock, Rock Question 2, Answer was correct!!!!, Pat now has 2 Gold Coins., Sue is the current player, They have rolled a 5, Sue's new location is 7, The category is Rock, Rock Question 3, Question was incorrectly answered, Sue was sent to the penalty box, Chet is the current player, They have rolled a 1, Chet is getting out of the penalty box, Chet's new location is 9, The category is Science, Science Question 0, Answer was correct!!!!, Chet now has 2 Gold Coins., Pat is the current player, They have rolled a 3, Pat's new location is 10, The category is Sports, Sports Question 1, Answer was correct!!!!, Pat now has 3 Gold Coins., Sue is the current player, They have rolled a 1, Sue is getting out of the penalty box, Sue's new location is 8, The category is Pop, Pop Question 1, Answer was correct!!!!, Sue now has 2 Gold Coins., Chet is the current player, They have rolled a 4, Chet is not getting out of the penalty box, Pat is the current player, They have rolled a 1, Pat's new location is 11, The category is Rock, Rock Question 4, Answer was correct!!!!, Pat now has 4 Gold Coins., Sue is the current player, They have rolled a 4, Sue is not getting out of the penalty box, Chet is the current player, They have rolled a 2, Chet is not getting out of the penalty box, Pat is the current player, They have rolled a 3, Pat's new location is 2, The category is Sports, Sports Question 2, Answer was correct!!!!, Pat now has 5 Gold Coins., Sue is the current player, They have rolled a 5, Sue is getting out of the penalty box, Sue's new location is 1, The category is Science, Science Question 1, Answer was correct!!!!, Sue now has 3 Gold Coins., Chet is the current player, They have rolled a 5, Chet is getting out of the penalty box, Chet's new location is 2, The category is Sports, Sports Question 3, Answer was correct!!!!, Chet now has 3 Gold Coins., Pat is the current player, They have rolled a 1, Pat's new location is 3, The category is Rock, Rock Question 5, Answer was correct!!!!, Pat now has 6 Gold Coins., Sue is the current player, They have rolled a 3, Sue is getting out of the penalty box, Sue's new location is 4, The category is Pop, Pop Question 2, Answer was correct!!!!, Sue now has 4 Gold Coins., Chet is the current player, They have rolled a 5, Chet is getting out of the penalty box, Chet's new location is 7, The category is Rock, Rock Question 6, Answer was correct!!!!, Chet now has 4 Gold Coins.]";
        assertEquals(expectedLogs, aGame.getLogs());
    }
}
