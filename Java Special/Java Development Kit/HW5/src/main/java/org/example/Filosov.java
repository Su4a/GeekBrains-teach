package org.example;

import java.util.concurrent.Semaphore;

public class Filosov implements Runnable {
    private int countEat = 3;
    private final int name;
    private boolean fill = false;
    private final Semaphore sem;
    public Filosov(int name, Semaphore sem) {
        this.name = name;
        this.sem = sem;
    }

    @Override
    public void run() {
        while (!fill) {
            try {
                sem.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            eat();
            thinks();
            sem.release();
        }
    }

    private void eat() {
        if (countEat > 0) {
            countEat--;
            System.out.println("Филосов " + name + " поел, осталось покушать " + countEat + " раза");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } else {
            fill = true;
            System.out.println("Филосов " + name + " сытый");
        }

    }

    private void thinks() {
        if (countEat > 0) {
            System.out.println("Филосов " + name + " думает");
        }
    }
}
