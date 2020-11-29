package ru.geekbrains.lesson5;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

public class Car implements Runnable {
    private static int CARS_NUMBER;
    private static CyclicBarrier CB = new CyclicBarrier(1);
    private static int CARS_COUNT;
    private static AtomicInteger place = new AtomicInteger(0);
    static {
        CARS_COUNT = 0;
    }
    private Race race;
    private int speed;
    private String name;
    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }
    public static void setNumberCars(int numberCars){
        CARS_NUMBER = numberCars;
        CB = new CyclicBarrier(CARS_NUMBER);

    }
    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }
    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
            CB.await();

        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        int carPlace = place.incrementAndGet();
        if (carPlace < 4) {
            System.out.printf("%s занял %d место%n", name, carPlace);
        }

    }
}
