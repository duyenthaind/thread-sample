/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thaind.sample;

/**
 *
 * @author HL94NVT
 */
public class ThreadSample {

    public static void main(String[] args) {
        Thread fromThread = new ThreadExample();
        fromThread.start();
        Thread fromRunnable = new Thread(new RunnableExample());
        fromRunnable.start();
        System.exit(0);
    }
}

class RunnableExample implements Runnable {

    @Override
    public void run() {
        System.out.println("This is runnable1");
    }

}

class ThreadExample extends Thread {

    @Override
    public void run() {
        System.out.println("This is thread1");
    }

}
