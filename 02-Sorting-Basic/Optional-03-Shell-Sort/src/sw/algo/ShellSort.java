package sw.algo;

public class ShellSort {

    private ShellSort(){}

    // 方法1
    public static void sort(Comparable[] arr){

        // 划分比较区间, 计算区间的偏移量
        for (int h = arr.length/2; h > 0; h /= 2) {

            // 遍历各区间
            for (int i = h; i < arr.length; i ++) {
                int j = i;
                // 单区间内进行插入排序比较
                while (j-h >= 0 && arr[j].compareTo(arr[j-h]) < 0) {
                    swap(arr,j,j-h);
                    j -= h;
                }
            }
        }
    }

    // 方法2
    public static void sort2(Comparable[] arr) {

        int n = arr.length;
        // 计算分组偏移量
        int h = 1;
        while (h < n/3) h = 3 * h + 1;

        while (h >= 1) {

            // 遍历各比较区间,[h,n)是第二个完整包含各区间的范围
            for (int i = h; i < n; i ++) {

                Comparable e = arr[i];
                int j = i;
                // 单区间内元素, 进行插入排序
                for ( ; j >= h  && e.compareTo(arr[j-h]) < 0; j -= h)
                    arr[j] = arr[j-h];
                arr[j] = e;
            }

            // 重新划分比较区间
            h /= 3;
        }
    }
    
    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        Integer[] a = {10,9,8,7,6,5,4,3,2,1};
        ShellSort.sort2(a);

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
            System.out.print(' ');
        }
        System.out.println();
    }
}
