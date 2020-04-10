package com.company;

import java.util.Arrays;

public class ArrayStream extends Compare{

    public int min(int[] list) {
        return Arrays.stream(list).min().getAsInt();
    }

    public int max(int[] list) {
        return Arrays.stream(list).max().getAsInt();
    }
}
