package ru.geekbrains.lesson4;

public class MyThread1 extends Thread {
    private char currentChar;
    private char nextChar;
    private static volatile char staticNextChar = 'A';
    private static Object monitor = new Object();

    public MyThread1(char currentChar, char nextChar) {
        this.currentChar = currentChar;
        this.nextChar = nextChar;
        this.start();
    }

    @Override
    public void run() {
        try {
            printChar();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void printChar() throws InterruptedException {

        for (int i = 0; i < 5; i++) {
            synchronized (monitor) {
                while (staticNextChar != currentChar) {
                    monitor.wait();
                }
                System.out.println(currentChar);
                staticNextChar = nextChar;
                monitor.notifyAll();
            }

        }
    }
}
