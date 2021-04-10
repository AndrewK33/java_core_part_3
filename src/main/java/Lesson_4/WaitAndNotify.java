package Lesson_4;

public class WaitAndNotify {
    private final Object mon = new Object();
    private char letterQueue = 'A';

    public static void main(String[] args) {
        WaitAndNotify waitAndNotify = new WaitAndNotify();
        new Thread(() -> {
            waitAndNotify.printA();
        }).start();
        new Thread(() -> {
            waitAndNotify.printB();
        }).start();
        new Thread(() -> {
            waitAndNotify.printC();
        }).start();

    }

    private void printA() {
        synchronized (mon) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (letterQueue != 'A') {
                        mon.wait();
                    }
                    System.out.print("A");
                    letterQueue = 'B';
                    mon.notifyAll();
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void printB() {
        synchronized (mon) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (letterQueue != 'B') {
                        mon.wait();
                    }
                    System.out.print("B");
                    letterQueue = 'C';
                    mon.notifyAll();
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    private void printC() {
        synchronized (mon) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (letterQueue != 'C') {
                        mon.wait();
                    }
                    System.out.print("C");
                    letterQueue = 'A';
                    mon.notifyAll();
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }




}
