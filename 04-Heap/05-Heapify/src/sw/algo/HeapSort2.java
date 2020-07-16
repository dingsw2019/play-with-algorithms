package sw.algo;

public class HeapSort2 {

    private HeapSort2(){}

    // 对整个arr数组排序
    // 借助heapify过程创建堆
    // 创建堆的过程时间复杂度为O(n), 将所有元素依次从堆中取出来, 复杂度为O(nlogn)
    //
    public static void sort(Comparable[] arr) {

        int n = arr.length;
        MaxHeap<Comparable> maxHeap = new MaxHeap<>(arr);
        for (int i = n - 1; i >= 0; i --)
            arr[i] = maxHeap.extractMax();
    }

    public static void main(String[] args) {

        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N,0,100000);
        SortTestHelper.testSort("sw.algo.HeapSort2",arr);

        SortTestHelper.printArray(arr);
    }
}
