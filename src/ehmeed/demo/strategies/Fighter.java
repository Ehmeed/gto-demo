package ehmeed.demo.strategies;

import ehmeed.demo.Move;

public class Fighter implements Strategy {

    private int score;

    @Override
    public Move getNextMove() {
        return Move.FIGHT;
    }

    @Override
    public void memorize(Move move) {

    }

    @Override
    public int getScore() {
        return score;
    }

    @Override
    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Fighter{" +
                "score=" + score +
                '}';
    }
}
