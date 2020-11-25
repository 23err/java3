package ru.geekbrains.lesson3;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

public class Main {
    private static final String PATH = "src/main/java/ru/geekbrains/lesson3/";
    public static void main(String[] args)  {
//        try {
//            readByteArray();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            sequence();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        //Написать консольное приложение, которое умеет постранично читать текстовые файлы
        // (размером > 10 mb). Вводим страницу (за страницу можно принять 1800 символов),
        // программа выводит ее в консоль. Контролируем время выполнения: программа не должна
        // загружаться дольше 10 секунд, а чтение – занимать свыше 5 секунд.





    }

    private static void sequence() {
        //Последовательно сшить 5 файлов в один (файлы примерно 100 байт).
        // Может пригодиться следующая конструкция: ArrayList<InputStream> al = new ArrayList<>();
        // ... Enumeration<InputStream> e = Collections.enumeration(al);
        ArrayList<InputStream> al = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            FileInputStream fis = null;
            try {
                fis = new FileInputStream(PATH + "file" + i);
                al.add(fis);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        Enumeration<InputStream> enumeration = Collections.enumeration(al);
        try(SequenceInputStream sis = new SequenceInputStream(enumeration)) {
            int x;
            while ((x = sis.read()) != -1) {
                System.out.print((char) x);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void readByteArray() {
        //Прочитать файл (около 50 байт) в байтовый массив и вывести этот массив в консоль;
        File file = new File(PATH + "file1");

        if (file.exists()) {
            byte[] bytes = new byte[50];

                try (FileInputStream fis = new FileInputStream(file)) {
                    int size = fis.read(bytes);
                    for (int i = 0; i < size; i++) {
                        System.out.println(bytes[i]);
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }


        }


    }
}
