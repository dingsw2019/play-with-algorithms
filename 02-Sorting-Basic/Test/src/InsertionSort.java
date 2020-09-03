public class InsertionSort {

    private InsertionSort(){}

    public static void sort(Comparable[] arr) {

        int n = arr.length;
        for (int i = 0; i < n; i ++) {

            for (int j = i; j > 0 && arr[j-1].compareTo(arr[j]) > 0; j --) {
                swap(arr,j,j-1);
            }
        }
    }

    public static void sort2(Comparable[] arr) {

        int n = arr.length;
        for (int i = 1; i < n; i ++) {
            Comparable e = arr[i];
            int j = i;
            for (; j > 0 && arr[j-1].compareTo(e) > 0; j --)
                arr[j] = arr[j-1];

            arr[j] = e;
        }
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
