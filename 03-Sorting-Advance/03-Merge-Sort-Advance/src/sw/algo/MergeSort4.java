package sw.algo;

import java.util.Arrays;

public class MergeSort4 {

    private MergeSort4(){}
    
    private static void merge(Comparable[] arr, int l, int mid, int r) {

        Comparable[] aux = Arrays.copyOfRange(arr,l,r+1);

        int i = l, j = mid+1;
        for (int k = l; k <= r; k ++) {
            if (i > mid) {//全在右数组
                arr[k] = aux[j-l]; j++;
            } else if (j > r) { // 全在左数组
                arr[k] = aux[i-l]; i++;
            } else if (arr[i].compareTo(arr[j]) < 0) { // 左数组小
                arr[k] = aux[i-l]; i++;
            } else { // 右数组小
                arr[k] = aux[j-l]; j++;
            }
        }
    }

    private static void sort(Comparable[] arr, int l, int r) {

        if (r - l <= 15) {
            InsertionSort.sort(arr,l,r);
            return;
        }

        int mid = l + (r-l)/2;
        sort(arr,l,mid);
        sort(arr,mid+1,r);

        if (arr[mid].compareTo(arr[mid+1]) > 0)
            merge(arr,l,mid,r);
    }

    public static void sort(Comparable[] arr) {
        sort(arr,0,arr.length-1);
    }

}
