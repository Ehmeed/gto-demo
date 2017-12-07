package ehmeed.demo.strategies;

import ehmeed.demo.Move;

import java.util.ArrayList;

public interface Strategy {

    public Move getNextMove();

    public void memorize(Move move);

    public void setScore(int score);

    public int getScore();
}
