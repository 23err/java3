package ru.geekbrains.lesson8;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] array = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16},{17,18,19,20}};
        printArray(array);
    }

    public static void printArray(int[][] arr) {
        int k = 0, z = 0;
        int deltaK = 0;
        int deltaZ = 1;

        int[][] resultArr = new int[arr.length][arr[0].length];


        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                resultArr[k][z] = arr[i][j];
                if (deltaZ == 1 && (z == arr[0].length - 1 || resultArr[k][z + 1] != 0)) {
                    deltaK = 1;
                    deltaZ = 0;
                }
                if (deltaK == 1 && (k == arr.length - 1 || resultArr[k + 1][z] != 0)) {
                    deltaK = 0;
                    deltaZ = -1;
                }

                if (deltaZ == -1 && (z == 0 || resultArr[k][z - 1] != 0)) {
                    deltaK = -1;
                    deltaZ = 0;
                }
                if (deltaK == -1 && resultArr[k - 1][z] != 0) {
                    deltaK = 0;
                    deltaZ = 1;
                }

                k += deltaK;
                z += deltaZ;
            }

        }

        for (int i = 0; i < resultArr.length; i++) {
            for (int j = 0; j < resultArr[i].length; j++) {
                int element = resultArr[i][j];
                System.out.printf("%3d  ", element);
            }
            System.out.println();

        }

    }
}
