package ru.geekbrains.lesson3;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class MyReader {
    private final static int CHAR_ON_PAGE = 1800;
    private final static String FILE_PATH = "src/main/java/ru/geekbrains/lesson3/random_access_file";
    private final static Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {

        try (RandomAccessFile raf = new RandomAccessFile(FILE_PATH, "r")) {
            long totalPages = (long) Math.ceil((float)raf.length() / CHAR_ON_PAGE);

            int page = 0;
            while (page != -1) { // -1 выход из приложения
                System.out.print("Введите номер страницы: ");
                page = SCANNER.nextInt();
                if (page == 0 || page > totalPages) {
                    System.out.printf("вы ввели %d из %d страниц, попробуйте снова%n",page, totalPages);
                    continue;
                }
                page -= 1;
                raf.seek(page * CHAR_ON_PAGE);
                byte[] content = new byte[CHAR_ON_PAGE];
                int countReaded = raf.read(content, 0, CHAR_ON_PAGE);
                String stringContent = new String(content, "UTF-8");
                System.out.println(stringContent);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
