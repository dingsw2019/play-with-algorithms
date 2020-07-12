package sw.algo;

import java.util.Arrays;

public class MergeSort {

    private MergeSort(){}

    // 将arr[l...mid]和arr[mid+1...r]两部分进行归并
    private static void merge(Comparable[] arr, int l, int mid, int r) {
        // 辅助临时数组, 存放排序后的元素
        Comparable[] aux = Arrays.copyOfRange(arr,l,r+1);

        // 初始化, i指向左半部分的起始索引位置, j指向右半部分的起始索引位置
        // k 指向aux的索引位置
        int i = l; int j = mid+1;
        for (int k = l; k <= r; k ++) {

            if (i > mid) { // 左半部分元素已经全部处理
                arr[k] = aux[j-l]; j++;
            } else if (j > r) { // 右半部分元素已经全部处理
                arr[k] = aux[i-l]; i++;
            } else if (aux[i-l].compareTo(arr[j-l]) < 0) {
                // 左半部分所指元素 < 右半部分所指元素
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

        // 进行归并
        merge(arr,l,mid,r);
    }

    public static void sort(Comparable[] arr){
        int n = arr.length;
        sort(arr,0,n-1);
    }

    public static void main(String[] args){
        // Merge Sort是O(nlogn)复杂度的算法
        // 可以在1秒之内轻松处理100万数量级的数据
        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N,0,100000);
        SortTestHelper.testSort("sw.algo.MergeSort",arr);
    }
}
