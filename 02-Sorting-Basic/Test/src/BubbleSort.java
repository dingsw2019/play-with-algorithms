public class BubbleSort {

    private BubbleSort(){}

    public static void sort(Comparable[] arr) {
        
        int n = arr.length;
        for (int i = 0; i < n; i ++) {
            for (int j = 1; j < n-i; j ++) {
                if (arr[j-1].compareTo(arr[j]) > 0)
                    swap(arr,j-1,j);
            }
        }
    }
    
    public static void sort2(Comparable[] arr) {

        int n = arr.length;
        int newn;
        do {
            newn = 0;
            
            for (int i = 1; i < n; i ++) {
                if (arr[i-1].compareTo(arr[i]) > 0) {
                    swap(arr,i-1,i);
                    newn = i;
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
