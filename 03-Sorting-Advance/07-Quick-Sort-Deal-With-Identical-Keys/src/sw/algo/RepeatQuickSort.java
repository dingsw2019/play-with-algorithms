package sw.algo;

import java.util.Arrays;

public class RepeatQuickSort {

    private RepeatQuickSort(){}

    // 对数组arr[l,r]进行拆分排序, 使arr[l,p-1] < arr[p]; arr[p+1,r] > arr[p]
    private static int partition(Comparable[] arr, int l, int r){
        // 优化点, 随机基数
        swap(arr,l,(int)(Math.random()*(r-l+1)) + l);
        // 选择基数
        Comparable v = arr[l];

        // 大于基数
        int i, j = l;
        for (i = l; i <= r; i ++) {
            if (arr[i].compareTo(v) < 0) {
                swap(arr,i,j+1);
                j++;
            }
        }

        // 基数放到中间
        swap(arr,l,j);

        return j;
    }

    // 切分2, 解决大量等于v, 导致切分不均匀的问题
    private static int partition2(Comparable[] arr, int l, int r) {

        // 随机基数
        swap(arr,l,(int)(Math.random() * (r-l+1))+l);
        Comparable v = arr[l];

        int i = l+1, j = r;
        while (true) {

            while (i <= r && arr[i].compareTo(v) < 0) i++;
            while (j >= l+1 && arr[j].compareTo(v) > 0) j--;

            // 遍历完了
            if (i > j) break;

            // 交换
            swap(arr,i,j);
            i++;
            j--;
        }

        // 将基数放在中间
        swap(arr,l,j);
        return j;
    }


    private static void sort(Comparable[] arr, int l, int r){

        if (r-l <= 15) {
            InsertionSort.sort(arr,l,r);
            return;
        }

        int p = partition2(arr,l,r);

        sort(arr,l,p-1);
        sort(arr,p+1,r);
    }

    public static void sort(Comparable[] arr){
        int n = arr.length;
        sort(arr,0,n-1);
    }



    private static void swap(Object[] arr, int i, int j){
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int N = 50;
        Integer[] arr = SortTestHelper.generateRandomArray(N,0,100000);
//        SortTestHelper.testSort("sw.algo.RepeatQuickSort",arr);

//        SortTestHelper.printArray(arr);

        int swapTimes = 100;
        assert swapTimes >= 0;
        System.out.println("Test for nearly ordered array, size = " + N + " , swap time = " + swapTimes);

        N = 100000;
        Integer[] arr1 = SortTestHelper.generateNearlyOrderedArray(N,swapTimes);
//        SortTestHelper.testSort("sw.algo.RepeatQuickSort",arr1);

        arr1 = SortTestHelper.generateRandomArray(N,0,10);
        SortTestHelper.testSort("sw.algo.RepeatQuickSort",arr1);
    }
}
