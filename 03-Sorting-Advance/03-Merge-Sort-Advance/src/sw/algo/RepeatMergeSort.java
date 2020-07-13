package sw.algo;

import java.util.Arrays;

public class RepeatMergeSort {

    private RepeatMergeSort(){}

    // 对arr[l,mid] 与 arr[mid+1,r] 进行合并排序
    private static void merge(Comparable[] arr, int l, int mid, int r) {

        // 创建排序数组
        Comparable[] aux = Arrays.copyOfRange(arr,l,r+1);

        // i指向左数组, j指向右数组, k指向排序数组
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k ++) {
            // 左数组为空, 将右数组加到排序数组
            if (i > mid) {
                arr[k] = aux[j-l];j++;
            }
            // 左数组为空, 将左数组加到排序数组
            else if (j > r){
                arr[k] = aux[i-l];i++;
            }
            // 左元素小于右元素, 添加左元素
            else if (aux[i-l].compareTo(aux[j-l]) < 0) {
                arr[k] = aux[i-l]; i++;
            // 右元素小于左元素, 添加右元素
            } else {
                arr[k] = aux[j-l]; j++;
            }
        }
    }

    // 自顶向下, 递归切分
    private static void sort(Comparable[] arr, int l, int r){

        // 递归结束条件, 优化点: 数据量小, 使用快速排序, 减少递归
        if (r-l <= 15) {
            InsertionSort.sort(arr,l,r);
            return;
        }

        int mid = l + (r-l)/2;
        sort(arr,l,mid);
        sort(arr,mid+1,r);

        // 合并排序, 优化点2, 左右数组已经有序, 不需要排序了
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
        SortTestHelper.testSort("sw.algo.RepeatMergeSort",arr);

        SortTestHelper.printArray(arr);
    }
}
