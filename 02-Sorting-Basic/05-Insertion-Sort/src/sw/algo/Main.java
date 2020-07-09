package sw.algo;

import java.util.Arrays;

public class Main {

    /**
     * Test for random array, size = 100000, random range [0, 100000]
     * SelectionSort : 28107ms
     * InsertionSort : 37117ms
     *
     * 此时的插入排序性能不如选择排序, 需要优化插入排序
     */
    public static void main(String[] args) {
        int N = 100000;
        System.out.println("Test for random array, size = "+ N +", random range [0, "+ N+"]");

        // 生成随机数数组
        Integer[] arr1 = SortTestHelper.generateRandomArray(N,0,N);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);

        // 测试排序
        SortTestHelper.testSort("sw.algo.SelectionSort",arr1);
        SortTestHelper.testSort("sw.algo.InsertionSort",arr2);
    }
}
