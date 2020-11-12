package ru.geekbrains.lesson1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Box<T extends Fruit> {
    private List<T> list = new ArrayList<>();

    public Box(){}
    public Box(T[] arr){
        list.addAll(Arrays.asList(arr));
    }

    public float getWeight() {
        if (list.size() == 0)
            return 0;
        float weight = list.get(0).getWeight();
        float totalWeight = weight * list.size();

        return totalWeight;
    }

    public void add(T fruit){
        list.add(fruit);
    }
    public void addAll(List<T> fruits){
        list.addAll(fruits);
    }

    public boolean compare(Box<?> box){
        return getWeight() == box.getWeight();
    }

    public void shiftFruit(Box<T> box){
        box.addAll(list);
        list.clear();
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
