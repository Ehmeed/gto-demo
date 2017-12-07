package ehmeed.demo.strategies;

import ehmeed.demo.Move;

public class Copycat implements Strategy {

    private Move lastEnemyMove = null;
    private int score;


    @Override
    public Move getNextMove() {
        return (lastEnemyMove == null) ? Move.SURRENDER : lastEnemyMove;
    }

    @Override
    public void memorize(Move move) {
        lastEnemyMove = move;
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
        return "Copycat{" +
                "score=" + score +
                '}';
    }
}
