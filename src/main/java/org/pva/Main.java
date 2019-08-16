package org.pva;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!");
        final int[] ints = new Random().ints(1, 10).distinct().limit(6).toArray();
        for (int anInt : ints) {
            System.out.println(anInt);
        }

    }
}
