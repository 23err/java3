package ru.geekbrains.lesson1;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Array<String> arr = new Array<String>(new String[]{"1", "2"});

//1. Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа);
        System.out.println(Arrays.toString(arr.swapItems(0,1)));

//2. Написать метод, который преобразует массив в ArrayList;
        ArrayList<String> list = arr.getArrayList();
        list.forEach(System.out::println);

//3.
        Box<Apple> appleBox = new Box<>(new Apple[]{new Apple()});
        System.out.println("appleBox = " + appleBox.getWeight());

        Box<Orange> orangeBox = new Box<>(new Orange[]{new Orange(), new Orange()});
        System.out.println("orangeBox = " + orangeBox.getWeight());

        System.out.println(appleBox.compare(orangeBox));

        Box<Apple> appleBox1 = new Box<>(new Apple[]{new Apple()});
        appleBox.shiftFruit(appleBox1);
        System.out.println("appleBox = " + appleBox);
        System.out.println("appleBox1 = " + appleBox1);

    }


}
