package sw.algo;

import java.util.Arrays;

public class QuickSort2 {

    private QuickSort2(){}

    private static int partition(Comparable[] arr, int l, int r) {

        swap(arr,l,(int)(Math.random() * (r-l+1)) + l);
        Comparable v = arr[l];

        int j = l;
        for (int i = l+1; i <= r; i ++) {
            if (arr[i].compareTo(v) < 0) {
                swap(arr,i,++j);
            }
        }

        swap(arr,l,j);
        return j;
    }

    private static void sort(Comparable[] arr, int l, int r) {

        if (r-l <= 15) {
            InsertionSort.sort(arr,l,r);
            return;
        }

        int p = partition(arr,l,r);

        sort(arr,l,p-1);
        sort(arr,p+1,r);
    }

    public static void sort(Comparable[] arr) {
        sort(arr,0,arr.length-1);
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
