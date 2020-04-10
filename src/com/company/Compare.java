package com.company;

public abstract class Compare {
    private double totalTime = 0;
    private double counter = 0;
    private String name = this.getClass().getName().split(".company.")[1];

    public int max(int[] array){
        return 0;
    }

    public int min(int[] array){
        return 0;
    }

    public double getAverageTime(){
        if (counter == 0){
            return 0;
        }
        return (totalTime / counter);
    }

    public String getName() {
        return name;
    }

    public static void timer (int[] myArray, Compare compare, boolean max) {
        compare.counter++;
        long startTime = System.nanoTime();

        if (max) {
            compare.max(myArray);
        } else {
            compare.min(myArray);
        }
        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        compare.totalTime += timeElapsed;
        System.out.println( compare.getName() + ":Execution time in nanoseconds  : " + timeElapsed);
    }
}
