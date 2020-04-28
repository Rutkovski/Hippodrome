package com.rutkovski.hippodrome;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hippodrome implements Runnable {

private List<Horse> horses;
public static Hippodrome game;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }
    public static void main(String[] args) {
        List <Horse> horses = new ArrayList<>();

        Horse horse1 = new Horse("Mashka", 3, 0);
        Horse horse2 = new Horse("Dashka", 3, 0);
        Horse horse3 = new Horse("Sashka", 3, 0);
        horses.addAll(Arrays.asList(horse1, horse2, horse3));

        game = new Hippodrome(horses);
        game.run();
        game.printWinner();

    }
    public void move (){
        for (Horse horse: horses) {
            horse.move();
        }

    }
    public void print(){
        for (Horse horse: horses) {
            horse.print();
        }
        for (int i = 0; i < 10 ; i++) {
            System.out.println("");
        }
    }
    public Horse getWinner(){
        Horse winner=horses.get(0);
        for (Horse horse:horses) {
            if (horse.getDistance()>winner.getDistance())
                winner=horse;
        }
        return winner;
    }
    public void printWinner(){

        System.out.println("Winner is "+getWinner().getName()+"!");
    }


    @Override
    public void run() {
        for (int i = 0; i <100 ; i++) {
            move();
            print();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {}

            
        }

    }
}
