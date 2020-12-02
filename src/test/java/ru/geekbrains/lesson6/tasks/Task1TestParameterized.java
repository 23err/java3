package ru.geekbrains.lesson6.tasks;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class Task1TestParameterized {
    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        return Arrays.asList(new int[][][]{
                {{1,2,3,5,6,7}},
                {{2,3,4,5,6,7}},
                {{1,2,3,5,6,7}},
                {{4, 4, 4, 4}},
                {{2, 3, 4, 5, 6, 7, 4}},
                {{1, 2, 3, 5, 6, 7}}
        });
    }

    private Task1 task1;
    private int[] testData;


    public Task1TestParameterized(int[] testData){
        this.testData = testData;
    }

    @Before
    public void init(){
        task1 = new Task1();
    }
    @Test
    public void testCheckOneAndFor() {
        Assert.assertEquals(false ,task1.checkOneAndFor(testData));
    }
}
