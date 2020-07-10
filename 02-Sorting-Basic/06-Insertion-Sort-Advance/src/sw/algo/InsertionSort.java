package sw.algo;

/**
 * 插入排序
 * 从前到后遍历所有元素, 每个元素与其之前的所有元素比对
 * 优化点: 比对后两个元素不进行交换, 进行赋值。交换是3次赋值, 而直接进行赋值只有1次赋值.
 */
public class InsertionSort {

    private InsertionSort(){}

    // arr数组从小到大排序
    // 使用插入排序优化法
    public static void sort(Comparable[] arr){
        int n = arr.length;

        // 从第2个元素开始遍历, 因为第1个元素之前没有可比较元素
        for (int i = 0; i < n; i++) {

            // 与当前元素之前的所有元素比较大小
//            for (int j = i; j > 0; j --) {
//                if (arr[j].compareTo(arr[j-1]) < 0)
//                    swap(arr,j,j-1);
//                else
//                    break;
//            }

            // 写法2
//            for (int j = i; j > 0 && arr[j].compareTo(arr[j-1]) < 0; j--)
//                swap(arr,j,j-1);

            // 写法3, 优化方法
            Comparable e = arr[i];
            int j = i;
            for ( ; j > 0 && arr[j-1].compareTo(e) > 0; j--)
                arr[j] = arr[j-1];
            // 遍历后的j, 是当前元素适合插入的位置
            arr[j] = e;
        }
    }

    public static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        Integer[] a = {10,9,8,7,6,5,4,3,2,1};
        InsertionSort.sort(a);

        for (int i = 0; i < a.length; i ++) {
            System.out.print(a[i]);
            System.out.print(' ');
        }

        System.out.println();
    }
}
