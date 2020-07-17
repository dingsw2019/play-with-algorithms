package sw.algo;

import java.util.*;
import java.lang.*;

// 在堆的有关操作中，需要比较堆中元素的大小，所以Item需要extends Comparable
public class MinHeap<Item extends Comparable> {

    protected Item[] data;
    protected int count;
    protected int capacity;

    public MinHeap(int capacity) {
        data = (Item[])new Comparable[capacity];
        count = 0;
        this.capacity = capacity;
    }

    public void insert(Item item) {
        assert count+1 < capacity;
        data[count] = item;
        shiftUp(count);
        count++;
    }

    public Item extractMin() {
        assert count >= 0;

        Item ret = data[0];

        swap(0,count-1);
        count--;
        shiftDown(0);

        return ret;
    }

    public int getSize(){
        return count-1;
    }

    protected void shiftUp(int k) {
        while (k > 0 && data[parent(k)].compareTo(data[k]) > 0) {
            swap(k,parent(k));
            k = parent(k);
        }
    }

    protected void shiftDown(int k) {
        while (leftChild(k) < count) {
            int j = leftChild(k);
            if (j+1 < count && data[j+1].compareTo(data[j]) < 0)
                j++;

            if (data[k].compareTo(data[j]) <= 0) break;

            swap(k,j);
            k = j;
        }
    }

    private void swap(int i, int j) {
        Item t = data[i];
        data[i] = data[j];
        data[j] = t;
    }

    protected int parent(int index){
        return (index-1)/2;
    }

    protected int leftChild(int index){
        return 2*index+1;
    }

    protected int rightChild(int index){
        return 2*index+2;
    }

    // 测试 sw.algo.MinHeap
    public static void main(String[] args) {

        MinHeap<Integer> minHeap = new MinHeap<Integer>(100);
        int N = 100; // 堆中元素个数
        int M = 100; // 堆中元素取值范围[0, M)
        for( int i = 0 ; i < N ; i ++ )
            minHeap.insert( new Integer((int)(Math.random() * M)) );

        Integer[] arr = new Integer[N];
        // 将minheap中的数据逐渐使用extractMin取出来
        // 取出来的顺序应该是按照从小到大的顺序取出来的
        for( int i = 0 ; i < N ; i ++ ){
            arr[i] = minHeap.extractMin();
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // 确保arr数组是从小到大排列的
        for( int i = 1 ; i < N ; i ++ )
            assert arr[i-1] <= arr[i];
    }
}
