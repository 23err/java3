package ru.geekbrains.lesson7;

public class TestClass {

    @BeforeSuite
    public void init() {
        System.out.println("init object");
    }

    @Test(priority = 3)
    public void test3(){
        System.out.println("test3");

    }
    @Test(priority = 1)
    public void test1(){
        System.out.println("test1");

    }
    @Test(priority = 2)
    public void test2(){
        System.out.println("test2");

    }

    @AfterSuite
    public void shutdown(){
        System.out.println("close resources");

    }
}
