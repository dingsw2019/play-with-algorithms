package sw.algo;

import java.util.Arrays;

public class MergeSort {

    private MergeSort(){}

    // 对arr[i,mid]和arr[mid+1,r]的元素进行归并排序
    private static void merge(Comparable[] arr, int l, int mid, int r){
        // 临时辅助数组, 保存排序后的元素
        Comparable[] aux = Arrays.copyOfRange(arr,l,r+1);

        // 初始化指针, i指向左数组, j指向右数组, k指向排序数组
        int i = l, j = mid+1;
        for (int k = l; k <= r; k ++) {
            // 左数组都加入排序了, 只能从右数组添加元素到排序数组了
            if (i > mid) {
                arr[k] = aux[j-l]; j++;

                // 右数组都加入排序了, 只能从左数组添加元素到排序数组了
            } else if (j > r) {
                arr[k] = aux[i-l]; i++;

                // 左数组i元素小于右数组j元素, i加入排序数组
            } else if (aux[i-l].compareTo(aux[j-l]) < 0) {
                arr[k] = aux[i-l]; i++;

                // 右数组j元素小于左数组i元素, j加入排序数组
            } else {
                arr[k] = aux[j-l]; j++;
            }
        }
    }

    // 递归使用归并排序, 对arr[l,r]的范围进行排序
    private static void sort(Comparable[] arr, int l, int r) {
        // 递归结束条件, 优化2: 对于小规模数组, 使用插入排序
        if (r-l <= 15) {
            InsertionSort.sort(arr, l, r);
            return;
        }

        int mid = l + (r-l)/2;
        // 向下拆分
        sort(arr,l,mid);
        sort(arr,mid+1,r);

        // 进行归并排序, 优化1, 当 arr[mid] < arr[mid+1]时
        // 说明左右数组已经是按顺序排列, 不用再进行排序了
        if (arr[mid].compareTo(arr[mid+1]) > 0)
            merge(arr,l,mid,r);
    }

    public static void sort(Comparable[] arr){
        int n = arr.length;
        sort(arr,0,n-1);
    }


    public static void main(String[] args) {
        int N = 50000;
        Integer[] arr = SortTestHelper.generateRandomArray(N,0,100000);
        SortTestHelper.testSort("sw.algo.MergeSort",arr);
        
    }
}
