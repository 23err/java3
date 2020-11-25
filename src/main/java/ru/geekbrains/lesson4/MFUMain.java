package ru.geekbrains.lesson4;

public class MFUMain {
    public static void main(String[] args) {
        MFU mfu = new MFU();
        Thread user1 = new Thread(() -> {
            System.out.println("user 1 scaning");
            mfu.scan();
        }, "user1");
        Thread user2 = new Thread(() -> {
            System.out.println("user 1 printing");
            mfu.print();
        }, "user2");
        Thread user3 = new Thread(()->{
            System.out.println("user 1 do copy");
            mfu.copy();
        }, "user3");

        user1.start();
        user2.start();
        user3.start();
    }
}
