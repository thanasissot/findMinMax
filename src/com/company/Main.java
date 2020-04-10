package com.company;

import java.util.Scanner;

public class Main {

    private static Object IllegalArgumentException;

    public static void main(String[] args) throws InterruptedException {
        // default length, max and min integer values
        int length = 100, max = 51, min = -51;

        // max boolean
        int maxOrMin = 1;
        boolean MaxBoolean = true;

        // boolean quit application
        boolean quit = false;

        // declare array of integers
        int[] array;

        // integer of selection for main menu
        int selection;

        // scanner object for console inputs
        Scanner scanner =  new Scanner(System.in);

        // initialization of all the 4 subclasses containing the algorithms
        ArrayStream arrayStream = new ArrayStream();
        IntStream intStream = new IntStream();
        BiFunc biFunc = new BiFunc();
        LoopIntArray loopIntArray = new LoopIntArray();

        // array of Compare objects
        Compare[] compareAlgorithms = {arrayStream, biFunc, intStream, loopIntArray};

        while (!quit){
            printMenu();
            selection = scanner.nextInt();
            scanner.nextLine();

            switch (selection){
                case 0:
                    System.out.println("Hello guy or girl. This is an application that compares runtimes of different approaches\n"+
                            "of how to get a min or max value from an int[] data structure with Java. The idea came to mind while\n"+
                            "completing Katas in CodeWars, and me being very curious on what method is best.\n"+
                            "Although this is not absolute sometimes one liner solutions though smart are not always the most\n"+
                            "efficient. This came to mind and decide to check on this approach. Being a 'being' (pun intended) of\n"+
                            "great curiosity and absolutely adore stats this app mini command line app was born.\n"+
                            "What you are about to see is 4 approaches on the same problem and see how fast each one of them is, plus\n"+
                            "you can check the accumulative average times that only exist to compare these 4 approaches with each other\n"+
                            "and aren't in any way absolute due to many factors.\n"+
                            "P.S you have the option to adjust the length of the array and the range and everything else is pretty much\n"+
                            "self explanatory");
                    break;
                case 1:
                    length = 0;
                    while (length < 1 || length > 10000) {
                        System.out.println("Type length: (1-10000)");
                        length = scanner.nextInt();
                        scanner.nextLine();
                    }
                    System.out.println("settings changed");
                    break;
                case 2:
                    System.out.println("Type in min: ");
                    min = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Type in max: ");
                    max = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("settings changed");
                    break;
                case 3:
                    maxOrMin = 0;
                    while (maxOrMin < 1 || maxOrMin > 2) {
                        System.out.println("Press 1 for Max or 2 for Min");
                        maxOrMin = scanner.nextInt();
                        scanner.nextLine();
                        if (maxOrMin == 1){
                            MaxBoolean = true;
                        } else if (maxOrMin == 2){
                            MaxBoolean = false;
                        }
                    }
                    System.out.println("settings changed");
                    break;
                case 4:
                    printCode();
                    break;
                case 5:
                    System.out.println("-=BEGIN=-");
                    System.out.println("Current Settings:\nLength:" + length + "\tRange(" + min + "," + max + ").");
                    array = new RandomIntegerArray(length, min, max).getRandomArray();
                    for(Compare algorithm : compareAlgorithms) {
                        Compare.timer(array, algorithm, MaxBoolean);
                    }
                    System.out.println("-=END=-");
                    break;
                case 6:
                    System.out.println("Reminder. Average time here is only for comparison between each algorithm.\n"
                            + "Factors such as length, range of integers, nearly sorted or not arrays, are\n"
                            + "not being accounted for");
                    System.out.println();
                    for(Compare algorithm : compareAlgorithms) {
                        System.out.println( algorithm.getName() + " : average time is " + algorithm.getAverageTime());
                    }
                    break;
                case 7:
                    quit = true;
                    break;
                default:
                    break;

            }
        }

    }

    public static void printMenu(){
        System.out.println("===============================");
        System.out.println("0. Brief Explanation of current application.");
        System.out.println("1. Set the length of the array.");
        System.out.println("2. Set the range of integers.");
        System.out.println("3. Set find Min or Max.");
        System.out.println("4. See the code for each algorithm.");
        System.out.println("5. Execute the find min or max application.");
        System.out.println("6. See the Average accumulated time for each algorithm.");
        System.out.println("7. Quit.");
        System.out.println("===============================");
    }

    public static void printCode(){
        System.out.println(
                "Array Stream Method:\n\t" +
                        "public int min(int[] list) {\n" +
                        "        return Arrays.stream(list).min().getAsInt();\n" +
                        "    }\n" +
                        "\n" +
                        "    public int max(int[] list) {\n" +
                        "        return Arrays.stream(list).max().getAsInt();\n" +
                        "    }\n"+
                        "BiFunc Method: \n\t" +
                        "public int min(int[] list) {\n" +
                        "        return findExtreme(list, Math::min);\n" +
                        "    }\n" +
                        "\n" +
                        "    public int max(int[] list) {\n" +
                        "        return findExtreme(list, Math::max);\n" +
                        "    }\n" +
                        "\n" +
                        "    private int findExtreme(int[] list, BiFunction<Integer, Integer, Integer> finder) {\n" +
                        "        int result = list[0];\n" +
                        "        for (int i = 1; i < list.length; i++) {\n" +
                        "            result = finder.apply(result, list[i]);\n" +
                        "        }\n" +
                        "        return result;\n" +
                        "    }\n" +
                        "IntStream Method:\n\t" +
                        "public int min(int[] list) {\n" +
                        "        return of(list).min().getAsInt();\n" +
                        "    }\n" +
                        "\n" +
                        "    public int max(int[] list) {\n" +
                        "        return of(list).max().getAsInt();\n" +
                        "    }\n"+
                        "Loop whole array and compare each element method:\n\t" +
                        "public int min(int[] list) {\n" +
                        "        int min = list[0];\n" +
                        "        for (int i = 1; i < list.length;i++) if (min > list[i]) min = list[i];\n" +
                        "        return min;\n" +
                        "    }\n" +
                        "    public int max(int[] list) {\n" +
                        "        int max = list[0];\n" +
                        "        for (int i = 1; i < list.length;i++) if (max < list[i]) max = list[i];\n" +
                        "        return max;\n" +
                        "    }"
        );
    }
}
