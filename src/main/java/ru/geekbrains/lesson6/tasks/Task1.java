package ru.geekbrains.lesson6.tasks;

import java.util.Arrays;

public class Task1 {
    public static void main(String[] args) {
        //2. Написать метод, которому в качестве аргумента передается не пустой одномерный
        // целочисленный массив. Метод должен вернуть новый массив, который получен путем
        // вытаскивания из исходного массива элементов, идущих после последней четверки.
        // Входной массив должен содержать хотя бы одну четверку, иначе в методе необходимо выбросить RuntimeException.
        // Написать набор тестов для этого метода (по 3-4 варианта входных данных).
        // Вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ].

        System.out.println(Arrays.toString(new Task1().getAfterFour(new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7, 4})));
        System.out.println(Arrays.toString(new Task1().getAfterFour(new int[]{1, 2, 2, 3, 1, 7})));

    }


    public int[] getAfterFour(int[] arr) throws RuntimeException {
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 4) index = i + 1;
        }
        if (index == -1) throw new RuntimeException("В массиве нет цифры 4");
        return Arrays.copyOfRange(arr, index, arr.length);

    }

    //Написать метод, который проверяет состав массива из чисел 1 и 4. Если в нем нет хоть одной четверки или единицы,
    // то метод вернет false; Написать набор тестов для этого метода (по 3-4 варианта входных данных).
    public boolean checkOneAndFor(int[] arr) {
        boolean one = false;
        boolean four = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) one = true;
            if (arr[i] == 4) four = true;
        }

        return (one && four);
    }
}
