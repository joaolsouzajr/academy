package edu.coursera.concurrent;

public class Main {

    boolean boo() {
        try {
            System.out.println("Boo");
            return true;
        } finally {
            System.out.println("Finally boo");
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello, i love code");
        new Main().boo();
    }
}
