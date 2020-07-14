package sw.algo;

public class RepeatShellSort {

    private RepeatShellSort(){}

    public static void sort(Comparable[] arr) {

        // 计算起始h值
        int h = 1, n = arr.length;
        while ( h < n/3 ) h = 3 * h + 1;

        while (h >= 1){

            // 找到第2个完整的各区间的起始位置
            for (int i = h; i < n; i ++) {
                Comparable e = arr[i];
                int j = i;
                boolean swap = false;
                // 单区间排序
                for ( ; j >= h && e.compareTo(arr[j-h]) < 0; j-= h)
                    arr[j] = arr[j-h];
                arr[j] = e;
            }

            h /= 3;
        }
    }

    public static void main(String[] args) {
        int N = 10;
        Integer[] arr1 = SortTestHelper.generateRandomArray(N,0,N);

        SortTestHelper.printArray(arr1);

        SortTestHelper.testSort("sw.algo.RepeatShellSort",arr1);

        SortTestHelper.printArray(arr1);

    }


}
