package sw.algo;

public class QuickSort3 {

    private QuickSort3(){}

    private static int partition(Comparable[] arr, int l, int r) {

        // 随机基数
        swap(arr,l,(int)(Math.random() * (r-l+1)) + l);
        Comparable v = arr[l];

        // j 是分界线, [l,j-1] < v, [j+1,r] >= v, j = v
        int j = l;
        for (int i = l+1; i <= r; i ++) {
            if (arr[i].compareTo(v) < 0)
                swap(arr,i,++j);
        }

        swap(arr,l,j);

        return j;
    }

    private static void sort(Comparable[] arr, int l, int r) {

        if (r - l <= 15) {
            InsertionSort.sort(arr,l,r);
            return;
        }

        int p = partition(arr,l,r);

        sort(arr,l,p-1);
        sort(arr,p+1,r);
    }

    public static void sort(Comparable[] arr) {
        sort(arr,0,arr.length-1);
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
