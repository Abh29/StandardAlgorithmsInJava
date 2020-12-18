package com.company;

public class Sort {

    /**
     * quick sort
     * **/

    static public <T extends Comparable<? super T>> void quickSort(T[] arr , int start , int end ){

        if(start >= end )
            return;

        int index = getPivotIndex(arr,start , end);


        quickSort(arr, start , index - 1);
        quickSort(arr,index + 1, end);


    }

    static private <T extends Comparable<? super T>> int getPivotIndex(T[] arr , int low , int high) {
        int i = low -1 ;
        T pivot = arr[high];
        T holder ;

        for (int j = low ; j < high  ; j++) {
            if (pivot.compareTo(arr[j]) >= 0){
                i++;
                swap(arr, i,j);
            }
        }

        arr[high] = arr[i+1];
        arr[i+1] = pivot ;


        return i+1 ;
    }

    /**
     * bubble sort
     * **/

    static public <T extends Comparable<? super T>> void bubbleSort(T[] arr ){

        T tmp ;

        for (int i = 0; i < arr.length -1 ; i++) {
            for (int j = 0; j < arr.length - i -1 ; j++) {

                if (arr[j].compareTo(arr[j+1]) > 0){
                    tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }

    }

    static private <T> void swap(T[] arr , int i , int j){
        T tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp ;
    }

    static public <T extends Comparable<?super T>> void selectSort(T[] arr){

        int local_min ;


        for (int i = 0; i < arr.length -1 ; i++) {

            local_min = i ;

            for (int j = i+1; j < arr.length; j++) {

                if (arr[local_min].compareTo(arr[j]) > 0){
                    local_min = j ;
                }
            }

            if (local_min != i){
                swap(arr, local_min,i);
            }

        }


    }



}
