package ru.geekbrains.lesson7;

public class Main {
    public static void main(String[] args) {
        TestRunner.start(TestClass.class);
        TestRunner.start(TestClass2.class.getName());

    }
}
