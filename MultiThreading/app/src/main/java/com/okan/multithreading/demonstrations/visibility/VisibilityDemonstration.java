package com.okan.multithreading.demonstrations.visibility;

public class VisibilityDemonstration {

    private static final Object LOCK = new Object();

    private volatile static int sCount = 0;

    public static void main(String[] args) {
        new Consumer().start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            return;
        }
        new Producer().start();
    }

    static class Consumer extends Thread {
        @Override
        public void run() {
            int localValue = -1;
            while (true) {
                // when it is locked in this thread it is guarantied
                // other threads can not access it
                synchronized (LOCK) {
                    if (localValue != sCount) {
                        System.out.println("Consumer: detected count change " + sCount);
                        localValue = sCount;
                    }
                    if (sCount >= 5) {
                        break;
                    }
                }
            }
            System.out.println("Consumer: terminating");
        }
    }

    static class Producer extends Thread {
        @Override
        public void run() {
            while (sCount < 5) {
                synchronized (LOCK) {
                    int localValue = sCount;
                    localValue++;
                    System.out.println("Producer: incrementing count to " + localValue);
                    sCount = localValue;
                    if (sCount >= 5){
                        break;
                    }
                }
            }
            System.out.println("Producer: terminating");
        }
    }
}
