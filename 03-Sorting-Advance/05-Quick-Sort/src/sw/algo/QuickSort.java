package sw.algo;

import java.util.Arrays;

public class QuickSort {

    private QuickSort(){}

    // 对arr[l,r]部分进行partition操作
    // 返回p, 使得arr[l,p-1] < arr[p], arr[p+1,r] > arr[p]
    private static int partition(Comparable[] arr, int l, int r) {
        // 初始化, 指针v指向基数, 指针j指向大于v的第一个元素的位置
        // 指针i指向比较元素

        Comparable v = arr[l];
        int j = l;

        // arr[l+1,j] < v ; arr[j+1,i) > v
        for (int i = l + 1; i <= r; i ++) {

            if (arr[i].compareTo(v) < 0) {
                swap(arr,j+1,i);
                j++;
            }
        }

        swap(arr,l,j);

        return j;
    }

    // 对arr[l,r]部分进行快速排序, 递归算法
    private static void sort(Comparable[] arr, int l, int r) {
        // 递归结束条件
        if (l >= r)
            return;

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

    // 测试 QuickSort
    // MergeSort : 933ms
    // QuickSort : 540ms
    public static void main(String[] args) {

        // Quick Sort也是一个O(nlogn)复杂度的算法
        // 可以在1秒之内轻松处理100万数量级的数据
        int N = 1000000;
        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, 100000);
        Integer[] arr2 = Arrays.copyOf(arr1,arr1.length);
        SortTestHelper.testSort("sw.algo.MergeSort", arr1);
        SortTestHelper.testSort("sw.algo.QuickSort", arr2);

        return;
    }
}
