package com.company;

public class Sort {



    public <T extends Comparable> void quickSort(T[] arr , int start , int end ){

        if(start >= end )
            return;

        int index = getPivotIndex(arr,start , end);


        quickSort(arr, start , index - 1);
        quickSort(arr,index + 1, end);


    }

    private <T extends Comparable> int getPivotIndex(T[] arr , int low , int high) {
        int i = low -1 ;
        T pivot = arr[high];
        T holder ;

        for (int j = low ; j < high  ; j++) {
            if (pivot.compareTo(arr[j]) >= 0){
                i++;
                holder = arr[j];
                arr[j] = arr[i];
                arr[i] = holder;
            }
        }

        arr[high] = arr[i+1];
        arr[i+1] = pivot ;


        return i+1 ;
    }





}
