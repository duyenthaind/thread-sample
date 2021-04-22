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
public class RaceConditionDemo {

    private static int counter = 0;

    public static int incrementValue() {
        System.out.println("Current thread: " + Thread.currentThread().getName());
        return counter++;
    }
    public static void main(String[] args) {
        for (int index = -1; ++index < 50000;) {
            new Thread(()->incrementValue()).start();
            new Thread(()->incrementValue()).start();
        }
        try {
            Thread.sleep(6000);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println(counter);
    }
}
