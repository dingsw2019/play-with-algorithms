package sw.algo;

import java.util.Arrays;

public class Main {

    // 比较InsertionSort和MergeSort两种排序算法的性能效率
    // 整体而言, MergeSort2的性能最优
    // Test for random array, size = 50000 , random range [0, 50000]
    // InsertionSort : 4949ms
    // MergeSort : 117ms
    // MergeSort2 : 34ms
    //
    // Test for nearly ordered array, size = 50000 , swap time = 10
    // InsertionSort : 6ms
    // MergeSort : 65ms
    // MergeSort2 : 20ms
    public static void main(String[] args) {

        int N = 50000;

        // 测试1, 一般测试
        System.out.println("Test for random array, size = " + N + " , random range [0, " + N + "]");
        Integer[] arr1 = SortTestHelper.generateRandomArray(N,0,N);
        Integer[] arr2 = Arrays.copyOf(arr1,arr1.length);
        Integer[] arr3 = Arrays.copyOf(arr1,arr1.length);

        SortTestHelper.testSort("sw.algo.InsertionSort",arr1);
        SortTestHelper.testSort("sw.algo.MergeSort",arr2);
        SortTestHelper.testSort("sw.algo.MergeSort2",arr3);

        System.out.println();

        // 测试2, 测试近乎有序的数组
        int swapTimes = 10;
        assert swapTimes >= 0;
        System.out.println("Test for nearly ordered array, size = " + N + " , swap time = " + swapTimes);

        arr1 = SortTestHelper.generateNearlyOrderedArray(N,swapTimes);
        arr2 = Arrays.copyOf(arr1,arr1.length);
        arr3 = Arrays.copyOf(arr1,arr1.length);


        SortTestHelper.testSort("sw.algo.InsertionSort",arr1);
        SortTestHelper.testSort("sw.algo.MergeSort",arr2);
        SortTestHelper.testSort("sw.algo.MergeSort2",arr3);
    }
}
