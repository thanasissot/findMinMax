package com.company;

import java.util.function.BiFunction;

public class BiFunc extends Compare{

    public int min(int[] list) {
        return findExtreme(list, Math::min);
    }

    public int max(int[] list) {
        return findExtreme(list, Math::max);
    }

    private int findExtreme(int[] list, BiFunction<Integer, Integer, Integer> finder) {
        int result = list[0];
        for (int i = 1; i < list.length; i++) {
            result = finder.apply(result, list[i]);
        }
        return result;
    }
}