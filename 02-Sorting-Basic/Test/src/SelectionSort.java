public class SelectionSort {

    private SelectionSort(){}

    public static void sort(Comparable[] arr) {

        int n = arr.length;
        for (int i = 0; i < n; i ++) {

            int minIndex = i;
            for (int j = i+1; j < n; j ++) {
                if (arr[j].compareTo(arr[minIndex]) < 0)
                    minIndex = j;
            }
            arr[i] = minIndex;
        }
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
    
}
