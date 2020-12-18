package com.company;

import java.util.Arrays;


public class Main {

    public static void main(String[] args) {

        Integer[] ints = {15,12,3,64,66,94,1,23,34,46,11,9,2,7};

        double time = System.nanoTime();
        Sort.selectSort(ints);
        System.out.println(System.nanoTime()-time);

        System.out.println(Arrays.toString(ints));




    }
}
