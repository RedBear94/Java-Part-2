package com.company;

public class Main {

    static final int SIZE = 10000000;
    static final int HALF = SIZE / 2;

    public static void main(String[] args) throws InterruptedException {
        createMass();
        createMassUseStream();
    }

    public static void createMass(){
        float[] arr = new float[SIZE];

        for(int i = 0; i < SIZE; i++){
            arr[i] = 1;
        }

        long a = System.currentTimeMillis();

        for(int i = 0; i < SIZE; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        System.out.println("1: " + (System.currentTimeMillis() - a) + " мс");
    }

    public static void createMassUseStream() throws InterruptedException {
        float[] arr = new float[SIZE];
        float[] a1, a2;
        a1 = new float[HALF];
        a2 = new float[HALF];

        for(int i = 0; i < SIZE; i++){
            arr[i] = 1;
        }

        long a = System.currentTimeMillis();

        System.arraycopy(arr, 0, a1, 0, HALF);
        System.arraycopy(arr, HALF, a2, 0, HALF);

        Main main = new Main();

        Thread firstThread = new Thread(() -> main.method(a1, 0));
        Thread secondThread = new Thread(() -> main.method(a2, HALF));

        firstThread.start();
        secondThread.start();

        try {
            firstThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            secondThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(a1, 0, arr, 0, HALF);
        System.arraycopy(a2, 0, arr, HALF, HALF);

        System.out.println("2: " + (System.currentTimeMillis() - a) + " мс");
    }

    public static void method(float[] a1, int offset) {
        for(int i = 0; i < HALF; i++) {
            a1[i] = (float) (a1[i] * Math.sin(0.2f + (i + offset) / 5) * Math.cos(0.2f + (i + offset) / 5) * Math.cos(0.4f + (i + offset) / 2));
        }
    }
}
