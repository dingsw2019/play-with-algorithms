package sw.algo;

public class RepeatSelectionSort {

    private RepeatSelectionSort(){}

    public static void sort(Comparable[] arr){

        int n = arr.length;
        for (int i = 0; i < n; i ++) {

            int minIndex = i;
            for (int j = i+1; j < n; j ++) {
                if (arr[minIndex].compareTo(arr[j]) > 0)
                    minIndex = j;
            }

            swap(arr,i,minIndex);
        }
    }

    public static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int N = 10;

        Integer[] arr = SortTestHelper.generateRandomArray(N,0,N);

        SortTestHelper.printArray(arr);

        SortTestHelper.testSort("sw.algo.RepeatSelectionSort",arr);

        SortTestHelper.printArray(arr);
    }
}
