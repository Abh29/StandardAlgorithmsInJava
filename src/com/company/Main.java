package com.company;

import java.io.*;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws Exception {

        File file = new File("src\\com\\company\\data\\avrg.csv");
        FileWriter fileWriter = new FileWriter(file);
        StringBuilder stringbuilder = new StringBuilder();
        Random rand = new Random();
        Integer[] data;
        int[] ints;
        double time;
        int size;
        int a;
        int ktime;
        long[] ktimes = new long[7];

        stringbuilder.append("n,data_size,tests,quicksort,selectionSort,insertionSort,bubbleSort,combSort,countingSort,mergeSort\n");
        //fileWriter.append(stringbuilder);

        for (int k = 0; k < 50; k++) {



        size = rand.nextInt(10000);
        data = new Integer[size];
        ints = new int[size];

        for (int j = 0; j < 20; j++) {


            for (int i = 0; i < size; i++) {
                a = rand.nextInt(100000);
                data[i] = a;
                ints[i] = a;
            }

           // stringbuilder.append(j + "," + size + ",");



            time = System.nanoTime();
            Sort.quickSort(data, 0, size -1);
            time = System.nanoTime() - time;

            ktimes[0] += (int) time;


            //stringbuilder.append(ktime + ",");


            time = System.nanoTime();
            Sort.selectionSort(data);
            time = System.nanoTime() - time;

            ktimes[1] += (int) time;

            //stringbuilder.append(ktime + ",");
            time = System.nanoTime();
            Sort.insertionSort(data);
            time = System.nanoTime() - time;

            ktimes[2] += (int) time;

            //stringbuilder.append(ktime + ",");
            time = System.nanoTime();
            Sort.bubbleSort(data);
            time = System.nanoTime() - time;

            ktimes[3] += (int) time;

            //stringbuilder.append(ktime + ",");
            time = System.nanoTime();
            Sort.combSort(data);
            time = System.nanoTime() - time;

            ktimes[4] += (int) time;

            //stringbuilder.append(ktime + ",");
            time = System.nanoTime();
            Sort.countingSort(ints, data);
            time = System.nanoTime() - time;

            ktimes[5] += (int) time;

            //stringbuilder.append(ktime + ",");
            time = System.nanoTime();
            Sort.mergeSort(data, 0, size -1);
            time = System.nanoTime() - time;

            ktimes[6] += (int) time;

            //stringbuilder.append(ktime + "\n");


        }
            for (int i = 0; i < 7; i++) {
                ktimes[i] /= 7;
            }

            stringbuilder.append(k + "," + size +","+ 20 + ","+ ktimes[0] + ","+ ktimes[1] + ","+ ktimes[2] + ","+ ktimes[3] + ","+ ktimes[4] + ","+ ktimes[5] + ","+ ktimes[6] + "\n");
            fileWriter.append(stringbuilder);
            stringbuilder.setLength(0);
            ktimes  = new long[7];
    }






        fileWriter.close();
    }
}
