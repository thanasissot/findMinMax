package com.company;

import static java.util.stream.IntStream.of;

public class IntStream extends Compare{

    public int min(int[] list) {
        return of(list).min().getAsInt();
    }

    public int max(int[] list) {
        return of(list).max().getAsInt();
    }
}
