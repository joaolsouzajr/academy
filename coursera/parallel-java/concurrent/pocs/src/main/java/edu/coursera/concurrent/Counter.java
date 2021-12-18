package edu.coursera.concurrent;

import java.util.stream.IntStream;

public class Counter {

    private int counter = 0;

//    public  void increment() {
//        counter++;
//    }
//
//    public void decrement() {
//        counter = counter - 3;
//    }

    public synchronized void increment() {
        counter++;
    }

    public synchronized void decrement() {
        counter--;
    }

    public synchronized int getCounter() {
        return counter;
    }

    public static void main(String[] args) {
        Counter counter = new Counter();

        /**
         * Com sync a saida é sempre a mesma
         */
        var A = new Thread(counter::increment);
        var B = new Thread(counter::decrement);
        A.start();
        B.start();
        System.out.println(counter.getCounter());
        try {
            B.join();
            A.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(counter.getCounter());


    }

}
