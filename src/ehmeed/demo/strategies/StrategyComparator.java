package ehmeed.demo.strategies;

import java.util.Comparator;

public class StrategyComparator implements Comparator<Strategy> {

    @Override
    public int compare(Strategy o1, Strategy o2) {
        return o1.getScore() < o2.getScore() ? -1 : 1;
    }
}
