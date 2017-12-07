package ehmeed.demo.strategies;

import ehmeed.demo.Move;

public class Pacifist implements Strategy {

    private int score;

    @Override
    public Move getNextMove() {
        return Move.SURRENDER;
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
        return "Pacifist{" +
                "score=" + score +
                '}';
    }
}
