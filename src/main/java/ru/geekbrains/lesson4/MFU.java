package ru.geekbrains.lesson4;

public class MFU {
    //Создать модель MFU (c возможность сканирования, печати и ксерокопии)
    private Object scanMonitor = new Object();
    private Object printMonitor = new Object();
    private Object sendMonitor = new Object();

    public void copy(){
        scan();
        print();
    }

    private void scaning(){
        synchronized (scanMonitor) {
            System.out.println("Process scan started " + Thread.currentThread().getName());
            try {
                Thread.sleep(500);
                System.out.println("Scaning finished " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void scan(){
        scaning();
        sendToNet();
    }

    public void print(){
        synchronized (printMonitor) {
            System.out.println("Process print started " + Thread.currentThread().getName());
            try {
                Thread.sleep(500);
                System.out.println("Printing finished " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void sendToNet(){
        synchronized (sendMonitor) {
            System.out.println("Start sending to net " + Thread.currentThread().getName());
            try {
                Thread.sleep(500);
                System.out.println("Sending finished " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
