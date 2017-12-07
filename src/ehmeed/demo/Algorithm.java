package ehmeed.demo;

import ehmeed.demo.strategies.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Algorithm {

    private ArrayList<Strategy> robots;

    public static void main(String[] args){
        System.out.println("Running simple gto demo");
        new Algorithm();
    }

    public Algorithm() {
        robots = new ArrayList<>();
        int robotCount = init(10, 5, 5);
        execute(5, 10, 5, 5, robotCount);
        robots.forEach(System.out::println);
    }

    private void execute(int tournamentsCount, int matchCount, int roundsCount,int learners, int robotCount) {

        robots.forEach(robot ->{
            robot.setScore(0);
        });

        for(int i = 0; i < tournamentsCount; i++){
            for(int j = 0; j < robotCount; j++){           //for each robot
                for(int k = j+1; k < robotCount; k++){        //for each enemy
                    for(int l = 0; l < matchCount; l++){        // for x matches
                        for(int m = 0; m < roundsCount; m++){     // for x round
                            fight(robots.get(j), robots.get(k));
                        }
                        robots.get(j).memorize(null);
                        robots.get(k).memorize(null);
                    }
                }
            }
            Collections.sort(robots, new StrategyComparator());
            if(i+1 == tournamentsCount) return;
            ArrayList<Strategy> newRobots = new ArrayList<>();
            for(int n = 0; n < learners; n++){
                Strategy newRobot;
                if(robots.get(robots.size()-1) instanceof Copycat){
                    newRobot = new Copycat();
                }else if(robots.get(robots.size()-1) instanceof Fighter){
                    newRobot = new Fighter();
                }else{
                    newRobot = new Pacifist();
                }
                newRobot.setScore(robots.get(n).getScore());
                newRobots.add(newRobot);
            }
            for(int o = 0; o < learners; o++){
                robots.remove(0);
            }
            robots.addAll(newRobots);

        }

    }

    private void fight(Strategy r1, Strategy r2) {
        Move m1 = r1.getNextMove();
        Move m2 = r2.getNextMove();
        r1.memorize(m2);
        r2.memorize(m1);
        if(m1 == m2){
            if(m1 == Move.SURRENDER){
                r1.setScore(r1.getScore()+1);
                r2.setScore(r2.getScore()+1);
            }
            else{
                r1.setScore(r1.getScore()-1);
                r2.setScore(r2.getScore()-1);
            }
        }else if(m1 == Move.SURRENDER){
            r1.setScore(r1.getScore()-2);
            r2.setScore(r2.getScore()+2);
        }else{
            r1.setScore(r1.getScore()+2);
            r2.setScore(r2.getScore()-2);
        }

    }

    private int init(int pacifistCount, int fighterCount, int copycatCount) {
        for(int i = 0; i < pacifistCount; i++){
            robots.add(new Pacifist());
        }
        for(int i = 0; i <fighterCount; i++){
            robots.add(new Fighter());
        }
        for(int i = 0; i < copycatCount; i++){
            robots.add(new Copycat());
        }
        return robots.size();
    }
}
