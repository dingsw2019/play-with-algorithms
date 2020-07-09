package sw.algo;

public class SelectionSort {

    private SelectionSort(){}

    // 选择排序, O(n^2)
    // 将数组arr的元素, 从小到大排序
    public static void sort(int[] arr){
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            // 寻找[i,n)的最小值的索引
            int minIndex = i;
            for (int j = i + 1; j < n; j++){
                if (arr[j] < arr[minIndex])
                    minIndex = j;
            }

            // 交换 i 和 minIndex 的值
            swap(arr,i,minIndex);
        }
    }

    // 将 arr 中的 i 和 j 交换
    private static void swap(int[] arr, int i, int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int[] arr = {10,9,8,7,6,5,4,3,2,1};
        SelectionSort.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            System.out.print(' ');
        }

        System.out.println();
    }
}
