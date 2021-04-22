package com.thaind.sample;

public class SynchronizationSample {

    private static int counter = 0;
    private static int counter2 = 0;
    private int counter3 = 0;

    public int getCounter3() {
        return this.counter3;
    }

    public static void main(String[] args) {
        for (int index = -1; ++index < 50000;) {
            new Thread(() -> increment()).start();
            new Thread(() -> increment()).start();
        }
        for (int index = -1; ++index < 50000;) {
            new Thread(() -> increment2()).start();
            new Thread(() -> increment2()).start();
        }
        SynchronizationSample synchronizationSample = new SynchronizationSample();
        for (int index = -1; ++index < 50000;) {
            new Thread(() -> synchronizationSample.increment3()).start();
            new Thread(() -> synchronizationSample.increment3()).start();
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println(
                "Counter1: " + counter);
        System.out.println(
                "Counter2: " + counter2);
        System.out.println(
                "Counter3: " + synchronizationSample.getCounter3());
        System.exit(0);
    }

    private static void increment() {
        System.out.println("Sychronized scope class: " + Thread.currentThread().getName());
        synchronized (SynchronizationSample.class) {
            counter++;
        }
    }

    private synchronized static void increment2() {
        System.out.println("Sychronized keyword: " + Thread.currentThread().getName());
        counter2++;
    }

    public int increment3() {
        System.out.println("Sychronized scope object: " + Thread.currentThread().getName());
        synchronized (this) {
            return counter3++;
        }
    }

}
