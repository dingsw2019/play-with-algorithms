package sw.algo;

import java.util.Arrays;

public class Main {

    // 比较 MergeSort, 3种QuickSort, 2种HeapSort的性能
    // 这几种算法都是O(nlogn)级别的
    // Test for random array, size = 1000000 , random range [0, 1000000]
    // HeapSort1 : 1654ms
    // HeapSort2 : 1376ms
    // HeapSort : 1036ms
    public static void main(String[] args) {

        int N = 1000000;

        // 一般性测试
        System.out.println("Test for random array, size = " + N + " , random range [0, " + N + "]");

        Integer[] arr1 = SortTestHelper.generateRandomArray(N,0,N);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr3 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("sw.algo.HeapSort1", arr1);
        SortTestHelper.testSort("sw.algo.HeapSort2", arr2);
        SortTestHelper.testSort("sw.algo.HeapSort", arr3);

        System.out.println();

        // 测试2 测试近乎有序的数组
        int swapTimes = 100;
        assert swapTimes >= 0;

        System.out.println("Test for nearly ordered array, size = " + N + " , swap time = " + swapTimes);

        arr1 = SortTestHelper.generateNearlyOrderedArray(N, swapTimes);
        arr2 = Arrays.copyOf(arr1, arr1.length);
        arr3 = Arrays.copyOf(arr1, arr1.length);
        SortTestHelper.testSort("sw.algo.HeapSort1", arr1);
        SortTestHelper.testSort("sw.algo.HeapSort2", arr2);
        SortTestHelper.testSort("sw.algo.HeapSort", arr3);

        System.out.println();

        // 测试3 测试存在包含大量相同元素的数组
        System.out.println("Test for random array, size = " + N + " , random range [0,10]");

        arr1 = SortTestHelper.generateRandomArray(N, 0, 10);
        arr2 = Arrays.copyOf(arr1, arr1.length);
        arr3 = Arrays.copyOf(arr1, arr1.length);
        SortTestHelper.testSort("sw.algo.HeapSort1", arr1);
        SortTestHelper.testSort("sw.algo.HeapSort2", arr2);
        SortTestHelper.testSort("sw.algo.HeapSort", arr3);
    }
}
