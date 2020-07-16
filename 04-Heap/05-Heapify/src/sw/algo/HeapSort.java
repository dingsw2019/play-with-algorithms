package sw.algo;

// 原地堆排序
public class HeapSort {

    private HeapSort(){}

    public static void sort(Comparable[] arr) {
        int n = arr.length;

        // 堆化
        for (int i = parent(n-1); i >= 0; i --)
            shiftDown2(arr,n,i);

        // 从小到大排序
        for (int i = n - 1; i > 0; i --) {
            swap(arr, 0, i);
            shiftDown2(arr,i,0);
        }

    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    // n是数组长度, k是下沉元素索引
    private static void shiftDown(Comparable[] arr, int n, int k){
        while (leftChild(k) < n) {
            int j = leftChild(k);
            if (j+1 < n && arr[j+1].compareTo(arr[j]) > 0)
                j++;

            if (arr[k].compareTo(arr[j]) > 0) break;

            swap(arr,k,j);
            k = j;
        }
    }

    // 优化的shiftDown, 使用赋值代替swap
    private static void shiftDown2(Comparable[] arr, int n, int k) {
        Comparable e = arr[k];
        while (leftChild(k) < n) {
            int j = leftChild(k);
            if (j+1 < n && arr[j+1].compareTo(arr[j]) > 0)
                j++;

            if (e.compareTo(arr[j]) >= 0) break;

            arr[k] = arr[j];
            k = j;
        }
        arr[k] = e;
    }

    private static void shiftUp(Comparable[] arr, int n, int k) {
        while (k > 0 && arr[k].compareTo(arr[parent(k)]) > 0) {
            swap(arr,k,parent(k));
            k = parent(k);
        }
    }

    private static int parent(int index){
        return (index-1) / 2;
    }

    private static int leftChild(int index){
        return 2*index+1;
    }

    private static int rightChild(int index){
        return 2*index+2;
    }

}
