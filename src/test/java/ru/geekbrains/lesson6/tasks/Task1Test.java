package ru.geekbrains.lesson6.tasks;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;


public class Task1Test {
    private Task1 task1;

    @Before
    public void init(){
        task1 = new Task1();
    }

    @Test
    public void getAfterFor1() {
        int[] testData = {1,2,3,4,5,6,7};
        Assert.assertArrayEquals(new int[]{5,6,7}, task1.getAfterFour(testData));
    }
    @Test
    public void getAfterFor2() {
        int[] testData = {4,1,2,3,5,6,7};
        Assert.assertArrayEquals(new int[]{1,2,3,5,6,7}, task1.getAfterFour(testData));
    }
    @Test
    public void getAfterFor3() {
        int[] testData = {1,2,3,4,5,6,7,4};
        Assert.assertArrayEquals(new int[]{}, task1.getAfterFour(testData));

    }
    @Test
    public void getAfterFor4() {
        int[] testData = {4,4,4,4};
        Assert.assertArrayEquals(new int[]{}, task1.getAfterFour(testData));
    }
    @Test(expected = RuntimeException.class)
    public void getAfterFor5() {
        int[] testData = {1,2,3,5,6,7};
        Assert.assertArrayEquals(new int[]{5,6,7}, task1.getAfterFour(testData));
    }
}