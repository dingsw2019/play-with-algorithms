package sw.algo;

import java.util.Arrays;

/**
 * 双路快速排序
 */
public class QuickSort2 {

    private QuickSort2(){}

    // 将等于基数的元素, 均匀放在两边数组中
    private static int partition(Comparable[] arr, int l, int r) {

        swap(arr,l,(int)(Math.random()*(r-l+1))+l);

        Comparable v = arr[l];

        // arr[l+1, i] <= v; arr[j,r] >= v
        int i = l+1, j = r;
        while( true) {
            // 左侧小于v的元素, 直接包含
            while (i <= r && arr[i].compareTo(v) < 0) i++;
            // 右侧大于v的元素, 直接包含
            while (j >= l + 1 && arr[j].compareTo(v) > 0) j--;

            // 是否结束循环
            if (i > j) break;

            // 走到这里说明, i 找到了大于等于v的元素, j 找到了小于等于v的元素
            // i 和 j 交换, 保持左小右大性质
            swap(arr,i, j);

            // 继续向后处理
            i++;
            j--;
        }

        swap(arr,l,j);
        return j;
    }

    // 对arr[l,r]部分进行快速排序, 递归算法
    private static void sort(Comparable[] arr, int l, int r) {
        // 递归结束条件
//        if (l >= r)
//            return;
        // 优化点1, 数据量小, 使用更简单的插入排序替代递归
        if (r - l <= 15) {
            InsertionSort.sort(arr, l ,r);
            return;
        }

        // 排序, 返回p的位置保证, arr[l,p-1] < arr[p]; arr[p+1,r] > arr[p]
        int p = partition(arr,l,r);

        // 对p的左右两侧元素, 在次进行快速排序
        sort(arr,l,p-1);
        sort(arr,p+1,r);
    }

    public static void sort(Comparable[] arr){
        int n = arr.length;
        sort(arr,0,n-1);
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    // 对于拥有非常多重复值的数组, 随机基数的快速排序也非常慢
    // Test for random array, size = 100000 , random range [0, 10]
    // MergeSort : 132ms
    // QuickSort : 2545ms

    // 优化后
    // Test for random array, size = 100000 , random range [0, 10]
    // MergeSort : 223ms
    // QuickSort : 2839ms
    // QuickSort2 : 48ms
    public static void main(String[] args) {

        // Quick Sort也是一个O(nlogn)复杂度的算法
        // 可以在1秒之内轻松处理100万数量级的数据
        int N = 100000;
        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, 100000);
        Integer[] arr2 = Arrays.copyOf(arr1,arr1.length);
        Integer[] arr3 = Arrays.copyOf(arr1,arr1.length);
//        SortTestHelper.testSort("sw.algo.MergeSort", arr1);
//        SortTestHelper.testSort("sw.algo.QuickSort", arr2);

        int swapTimes = 100;
        assert swapTimes >= 0;
//        System.out.println("Test for nearly ordered array, size = " + N + " , swap time = " + swapTimes);
//
//        arr1 = SortTestHelper.generateNearlyOrderedArray(N,swapTimes);
//        arr2 = Arrays.copyOf(arr1,arr1.length);
//
//        SortTestHelper.testSort("sw.algo.MergeSort",arr1);
//        SortTestHelper.testSort("sw.algo.QuickSort",arr2);

        System.out.println("Test for random array, size = " + N + " , random range [0, 10]");
        arr1 = SortTestHelper.generateRandomArray(N, 0, 10);
        arr2 = Arrays.copyOf(arr1,arr1.length);
        arr3 = Arrays.copyOf(arr1,arr1.length);
        SortTestHelper.testSort("sw.algo.MergeSort", arr1);
        SortTestHelper.testSort("sw.algo.QuickSort", arr2);
        SortTestHelper.testSort("sw.algo.QuickSort2", arr3);

    }
}
