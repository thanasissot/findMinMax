package com.company;

import java.util.Random;

public class RandomIntegerArray {
    private int length;
    private int[] array;

    public RandomIntegerArray(int length, int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("Max must be greater than min");
        } else if (max - min <= length){
            throw new IllegalArgumentException("Cannot have smaller range than length of actual array");
        } else if (length < 0 || length > 10000) {
            throw new IllegalArgumentException("Length must be in desired range");
        }
        this.length = length;
        Random rd = new Random();
        array = new int[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = rd.nextInt((max - min) + 1) + min;
        }
    }

    public int[] getRandomArray() {
        return array;
    }
}
