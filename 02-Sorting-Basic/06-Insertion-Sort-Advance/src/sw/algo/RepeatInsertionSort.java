package sw.algo;

public class RepeatInsertionSort {

    private RepeatInsertionSort(){}

    public static void sort(Comparable[] arr) {

        int n = arr.length;
        for (int i = 1; i < n; i ++) {
            Comparable e = arr[i];
            int j = i;
            // 如果之前的元素>e, 向后移动.赋值比交换快, 因为交换是3次赋值
            for (; j > 0 && arr[j-1].compareTo(e) > 0; j--)
                arr[j] = arr[j-1];

            arr[j] = e;
        }
    }

    public static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int N = 20;
        Integer[] arr1 = SortTestHelper.generateRandomArray(N,0,N);

        SortTestHelper.printArray(arr1);

        SortTestHelper.testSort("sw.algo.RepeatInsertionSort",arr1);

        SortTestHelper.printArray(arr1);
    }
}
