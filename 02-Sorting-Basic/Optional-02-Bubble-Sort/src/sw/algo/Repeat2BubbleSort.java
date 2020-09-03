package sw.algo;

public class Repeat2BubbleSort {

    private Repeat2BubbleSort(){}

    // 最基础的
    public static void sort1(Comparable[] arr) {

        int n = arr.length;
        for (int i = 0; i < n; i ++) {
            for (int j = 1; j < n-i; j ++) {
                if (arr[j-1].compareTo(arr[j]) > 0)
                    swap(arr,j-1,j);
            }
        }
    }

    // 提前结束的优化
    public static void sort2(Comparable[] arr) {

        int newn;
        int n = arr.length;
        do {
            newn = 0;

            for (int j = 0; j < n; j ++) {
                if (arr[j-1].compareTo(arr[j]) > 0) {
                    swap(arr,j-1,j);
                    newn = j;
                }
            }
            n = newn;
        }while (newn > 0);
    }

    public static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

}
