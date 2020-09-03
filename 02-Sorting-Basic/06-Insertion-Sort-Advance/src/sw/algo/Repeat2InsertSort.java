package sw.algo;

public class Repeat2InsertSort {

    private Repeat2InsertSort(){}

    public static void sort(Comparable[] arr) {

        int n = arr.length;

        for (int i = 1; i < n; i ++) {
            Comparable e = arr[i];
            int j = i;
            for (; j > 0 && e.compareTo(arr[j-1]) < 0; j --)
                arr[j] = arr[j-1];

            arr[j] = e;
        }
    }

    public static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
