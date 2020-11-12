package ru.geekbrains.lesson1;

import java.util.ArrayList;
import java.util.Arrays;

public class Array<T> {
    T[] obj;
    public Array(T[] obj){
        this.obj = obj;
    }
//    1. Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа);
    public T[] swapItems(int firstElem, int secondElem){
        T middleObj = obj[firstElem];
        obj[firstElem] = obj[secondElem];
        obj[secondElem] = middleObj;
        return obj;
    }
//2. Написать метод, который преобразует массив в ArrayList;
    public ArrayList<T> getArrayList(){
        return new ArrayList<T>(Arrays.asList(obj));
    }
}
