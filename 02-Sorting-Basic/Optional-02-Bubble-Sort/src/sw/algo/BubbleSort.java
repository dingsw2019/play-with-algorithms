package sw.algo;

public class BubbleSort {

    private BubbleSort(){}

    public static void sort(Comparable[] arr){
        int n = arr.length;

        // 写法1
//        for (int i = 0; i < n; i ++) {
//
//            // i 与之后的元素比较
//            for (int j = 1; j < n - i; j ++)
//                if (arr[j-1].compareTo(arr[j]) > 0)
//                    swap(arr,j-1,j);
//        }

        // 写法2 , 两两比较, 如果比较一遍, 一次交换也没有
        // 说明已经排好序了, 提前终止程序
//        boolean swapped = false;
//        do {
//            swapped = false;
//            for (int i = 1; i < n; i++) {
//                if (arr[i-1].compareTo(arr[i]) > 0) {
//                    swap(arr,i-1,i);
//                    swapped = true;
//                }
//            }
//
//            // 优化, 每一趟Bubble Sort 都将最大元素放在最后的位置
//            // 所以下一次排序, 最后的元素可以不再考虑
//            n--;
//
//        }while (swapped);

        // 写法3, 记录最后交换的位置, 没交换证明顺序正确,
        // 所以每一趟完成, 后面不需要遍历的会跳跃式增加
        int newn;
        do {
            newn = 0;
            for (int i = 1; i < n; i ++) {
                if (arr[i-1].compareTo(arr[i]) > 0) {
                    swap(arr,i-1,i);
                    // 记录最后一次交换的位置, 在此之后的元素在下一轮扫描中均不考虑
                    // 因为没交换过, 证明顺序正确
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

    public static void main(String[] args) {
        Integer[] a = {10,9,8,7,6,5,4,3,2,1};
        BubbleSort.sort(a);

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
            System.out.print(' ');
        }
        System.out.println();
    }
}
