package sw.algo;

public class RepeatBubbleSort {

    private RepeatBubbleSort(){}

    public static void sort1(Comparable[] arr) {

        int n = arr.length;

        // 每个元素都向上比较
        for (int i = 0; i < n-i; i ++) {

            // 每次比对都会找到最大值, 放在最后
            // 下一次比对过的最大值就不用比对了
            for (int j = 1; j < n-i; j ++) {
                if (arr[j].compareTo(arr[j-1]) < 0)
                    swap(arr,j,j-1);
            }
        }
    }

    // 如果一次遍历后, 没有位置交换, 说明数组已经有序
    public static void sort2(Comparable[] arr) {

        int n = arr.length;
        boolean swaped = false;
        do {
            swaped = false;
            for (int j = 1; j < n; j ++) {
                if (arr[j].compareTo(arr[j-1]) < 0) {
                    swap(arr,j,j-1);
                    swaped = true;
                }
            }

            n--;
        } while (swaped);
    }

    // 末端数据结束提前
    public static void sort(Comparable[] arr) {
        int n = arr.length;
        int newn;
        do {
            newn = 0;
            for (int j = 1; j < n; j ++) {
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

    public static void main(String[] args) {
        int N = 10;
        Integer[] arr1 = SortTestHelper.generateRandomArray(N,0,N);

        SortTestHelper.printArray(arr1);

        SortTestHelper.testSort("sw.algo.RepeatBubbleSort",arr1);

        SortTestHelper.printArray(arr1);

    }
}
