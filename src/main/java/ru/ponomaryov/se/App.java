package ru.ponomaryov.se;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class App {

    private static final int ARRAY_SIZE = 100000;
    private static final Random random = new Random();

    private static int[] initArray = new int[ARRAY_SIZE];
    private static boolean[] flagArray = new boolean[ARRAY_SIZE];

    private static Array array1 = new ArrayImpl(ARRAY_SIZE);
    private static Array array2 = new ArrayImpl(ARRAY_SIZE);
    private static Array array3 = new ArrayImpl(ARRAY_SIZE);

    public static void main(String[] args) {
        initializeArray();
        fillArrays();
        testBubbleSort(array1);
        testSelectSort(array2);
        testInsertSort(array3);
    }

    private static void initializeArray() {
        for (int i = 0; i < ARRAY_SIZE; i++) {
            flagArray[i] = false;
        }
        System.out.println("Initialize random array...");
        long start = System.nanoTime();
        for (int i = 0; i < ARRAY_SIZE; i++) {
            int rnd = random.nextInt(ARRAY_SIZE);
            while (flagArray[rnd]) {
                rnd = random.nextInt(ARRAY_SIZE);
            }
            initArray[i] = rnd;
            flagArray[rnd] = true;
        }
        long finish = System.nanoTime();
        System.out.println("Initialize time (ms): " + TimeUnit.NANOSECONDS.toMillis(finish - start));
    }

    private static void fillArrays() {
        System.out.println("Fill arrays... ");
        long start = System.nanoTime();
        for (int i = 0; i < ARRAY_SIZE; i++) {
            array1.add(initArray[i]);
            array2.add(initArray[i]);
            array3.add(initArray[i]);
        }
        long finish = System.nanoTime();
        System.out.println("Fill time (ms): " + TimeUnit.NANOSECONDS.toMillis(finish - start));
        System.out.println();
    }

    private static void testBubbleSort(Array array) {
        System.out.println("Start sorting (Bubble method)...");
        long start = System.nanoTime();
        array.sortBubble();
        long finish = System.nanoTime();
        System.out.println("Sort time (ms): " + TimeUnit.NANOSECONDS.toMillis(finish - start));
        System.out.println();
    }

    private static void testInsertSort(Array array) {
        System.out.println("Start sorting (Insert method)...");
        long start = System.nanoTime();
        array.sortInsert();
        long finish = System.nanoTime();
        System.out.println("Sort time (ms): " + TimeUnit.NANOSECONDS.toMillis(finish - start));
        System.out.println();
    }

    private static void testSelectSort(Array array) {
        System.out.println("Start sorting (Select method)...");
        long start = System.nanoTime();
        array.sortSelect();
        long finish = System.nanoTime();
        System.out.println("Sort time (ms): " + TimeUnit.NANOSECONDS.toMillis(finish - start));
        System.out.println();
    }
}