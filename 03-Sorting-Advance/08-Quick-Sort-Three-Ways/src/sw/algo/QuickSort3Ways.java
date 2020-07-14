package sw.algo;

import java.util.Arrays;

public class QuickSort3Ways {

    private QuickSort3Ways(){}

    // 对arr[l,r] 进行排序
    private static void sort(Comparable[] arr, int l, int r) {

        if (r-l <= 15) {
            InsertionSort.sort(arr,l,r);
            return;
        }

        // 随机基数
        swap(arr,l,(int)(Math.random() * (r-l+1))+l);

        // 划分元素
        Comparable v = arr[l];

        int lt = l; // arr[l+1,lt] < v
        int gt = r + 1; // arr[gt,r] > v
        int i = l + 1;  // arr[lt+1,i] == v

        while (i < gt) {

            if (arr[i].compareTo(v) < 0) {
                swap(arr,i,lt+1);
                i++;
                lt++;

            } else if (arr[i].compareTo(v) > 0) {
                swap(arr,i,gt-1);
                gt--;

            } else {
                i++;
            }
        }

        swap(arr,l,lt);

        sort(arr,l,lt-1);
        sort(arr,gt,r);
    }

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        sort(arr,0,n-1);
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    // 测试 QuickSort3Ways
    // Test for random array, size = 1000000 , random range [0, 10]
    // QuickSort : 拉稀了
    // QuickSort2 : 340ms
    // QuickSort3Ways : 133ms
    public static void main(String[] args) {

        // 三路快速排序算法也是一个O(nlogn)复杂度的算法
        // 可以在1秒之内轻松处理100万数量级的数据
        int N = 100000;
//        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
//        SortTestHelper.testSort("sw.algo.QuickSort3Ways", arr);
        
        System.out.println("Test for random array, size = " + N + " , random range [0, 10]");
        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, 10);
        Integer[] arr2 = Arrays.copyOf(arr1,arr1.length);
        Integer[] arr3 = Arrays.copyOf(arr1,arr1.length);
        SortTestHelper.testSort("sw.algo.QuickSort", arr2);
        SortTestHelper.testSort("sw.algo.QuickSort2", arr3);
        SortTestHelper.testSort("sw.algo.QuickSort3Ways", arr3);

    }
}