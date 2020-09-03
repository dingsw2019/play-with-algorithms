package sw.algo;

import java.util.Arrays;

public class RepeatMergeSort {

    private RepeatMergeSort(){}

    private static void merge(Comparable[] arr, int l, int mid, int r) {

        Comparable[] aux = Arrays.copyOfRange(arr,l,r+1);

        int i = l, j = mid+1;
        for (int k = l; k <= r; k ++) {

            // 左边空了
            if (i > mid) {
                arr[k] = aux[j-l]; j++;
            // 右边空了
            } else if (j > r) {
                arr[k] = aux[i-l]; i++;
            // 左数组小
            } else if (aux[i-l].compareTo(aux[j-l]) < 0) {
                arr[k] = aux[i-l]; i++;
            } else {
                arr[k] = aux[j-l]; j++;
            }
        }
    }

    private static void sort(Comparable[] arr, int l, int r){

        if (l >= r)
            return;

        int mid = l + (r-l)/2;

        sort(arr,l,mid);
        sort(arr,mid+1,r);

        merge(arr,l,mid,r);
    }

    public static void sort(Comparable[] arr) {
        sort(arr,0,arr.length-1);
    }

    public static void main(String[] args){
        // Merge Sort是O(nlogn)复杂度的算法
        // 可以在1秒之内轻松处理100万数量级的数据
        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N,0,100000);
        SortTestHelper.testSort("sw.algo.RepeatMergeSort",arr);
    }
}
