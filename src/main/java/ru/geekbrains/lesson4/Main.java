package ru.geekbrains.lesson4;

public class Main {
    public static void main(String[] args) {
        MyThread1 thread1 = new MyThread1('A', 'B');
        MyThread1 thread2 = new MyThread1('B', 'C');
        MyThread1 thread3 = new MyThread1('C', 'A');
    }
}

