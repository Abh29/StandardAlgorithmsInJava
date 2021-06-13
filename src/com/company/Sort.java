package com.company;

public class Sort {

    // quick sort

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

    static private <T> void swap(T[] arr , int i , int j){
        T tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp ;
    }


    // bubble sort

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


    // selection sort

    static public <T extends Comparable<? super T>> void selectionSort(T[] arr){

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


    // insertion sort

    public static <T extends Comparable<? super T>> void insertionSort(T[] arr){

        for (int i = 1; i < arr.length; ) {
            if (arr[i].compareTo(arr[i-1]) < 0){
                swap(arr , i , i-1);
                if(i != 1)
                    --i;
            }else
                  i++;
        }

    }


    // comb sort

    public static <T extends Comparable<? super T>> void combSort(T[] arr){

        int n = arr.length;
        boolean swap = false;

        while (n > 1 || swap)
        {
            n = n <= 1 ? 1 : (n * 10)/13;
            swap = false;

            for (int i = 0; i + n < arr.length; i++) {

                if (arr[i].compareTo(arr[n + i]) > 0){
                    swap(arr, i, n+i);
                    swap = true;
                }
            }
        }

    }


    // counting sort

    public static <T> void countingSort(int[] keys, T[] objs)
    {
        int max = 0;
        @SuppressWarnings("unchecked")
        T[] out = (T[]) new Object[objs.length];

        for (int i = 0; i < keys.length; i++) {
            if (keys[i] > max)
                max = keys[i];
        }

        int[] count = new int[max + 1];

        for (int i = 0; i < keys.length; i++) {
            count[keys[i]]++;
        }

        for (int i = 1 ;  i < count.length; i++) {
           count[i] += count[i-1];
        }

        for (int i = keys.length - 1; i > -1; i--) {
            out[count[keys[i]] - 1] = objs[i];
            count[keys[i]]--;
        }

        for (int i = 0; i < objs.length; i++) {
            objs[i] = out[i];
        }
    }


    // merge sort

    public static <T extends Comparable<? super T>> void mergeSort(T[] arr, int left, int right)
    {
        if (left < right) {

            int mid = (left + right) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
    }

    private static <T extends Comparable<? super T>> void merge(T[] arr, int left, int mid, int right)
    {

        // Create arr_1 ← A[left...mid] and arr_2 ← A[mid+1...right]
        int n1 = mid - left + 1;
        int n2 = right - mid;

        @SuppressWarnings("unchecked")
        T arr_1[] = (T[]) new Integer[n1];
        @SuppressWarnings("unchecked")
        T arr_2[] = (T[]) new Integer[n2];

        for (int i = 0; i < n1; i++)
            arr_1[i] = arr[left + i];
        for (int j = 0; j < n2; j++)
            arr_2[j] = arr[mid + 1 + j];

        int i, j, k;
        i = 0;
        j = 0;
        k = left;


        while (i < n1 && j < n2) {
            if (arr_1[i].compareTo(arr_2[j]) <= 0) {
                arr[k] = arr_1[i];
                i++;
            } else {
                arr[k] = arr_2[j];
                j++;
            }
            k++;
        }


        while (i < n1) {
            arr[k] = arr_1[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = arr_2[j];
            j++;
            k++;
        }
    }

}
