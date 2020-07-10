package sw.algo;

/**
 * 选择排序, 遍历所有元素, 从当前元素到最后一个元素比较出最小值
 * 填充到当前元素的位置
 */
public class SelectionSort {

    private SelectionSort(){}

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        // 遍历元素
        for (int i = 0; i < n; i ++) {

            // 最小值的索引
            int minIndex = i;
            for (int j = i + 1; j < n; j ++) {
                if (arr[j].compareTo(arr[minIndex]) < 0)
                    minIndex = j;
            }

            // 最小值与当前元素交换
            swap(arr,i,minIndex);
        }
    }

    // 元素值交换
    public static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        Integer[] a = {10,9,8,7,6,5,4,3,2,1};
        SelectionSort.sort(a);

        for (int i = 0; i < a.length; i ++) {
            System.out.print(a[i]);
            System.out.print(' ');
        }

        System.out.println();
    }
}
