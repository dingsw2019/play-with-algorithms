package sw.algo;

public class MaxHeap<Item extends Comparable> {

    protected Item[] data;
    protected int count;
    protected int capacity;

    public MaxHeap(int capacity) {

        data = (Item[])new Comparable[capacity+1];
        count = 0;
        this.capacity = capacity;
    }

    public int size(){return count;}

    public boolean isEmpty() { return count == 0;}

    public void insert(Item item) {
        assert count + 1 <= capacity;
        data[count+1] = item;
        count++;
        shiftUp(count);
    }

    public Item extractMax() {
        assert count > 0;
        Item ret = data[1];

        swap(1,count);
        count--;
        shiftDown(1);

        return ret;
    }

    private void swap(int i, int j) {
        Item t = data[i];
        data[i] = data[j];
        data[j] = t;
    }

    // 辅助函数
    private void shiftUp(int k) {

        while (k > 1 && data[k].compareTo(data[parent(k)]) > 0) {

            swap(k,parent(k));
            k = parent(k);
        }
    }

    private void shiftDown(int k) {

        while (leftChild(k) <= count) {
            int j = leftChild(k);
            if (j+1 <= count && data[j+1].compareTo(data[j]) > 0)
                j++;

            if (data[k].compareTo(data[j]) >= 0) break;

            swap(k,j);
            k = j;
        }
    }

    private int parent(int index) {
        return index / 2;
    }

    private int leftChild(int index) {
        return index * 2;
    }

    private int rightChild(int index) {
        return index * 2 + 1;
    }

    public static void main(String[] args) {

        MaxHeap<Integer> maxHeap = new MaxHeap<Integer>(100);
        int N = 100; // 堆中元素个数
        int M = 100; // 堆中元素取值范围[0, M)
        for( int i = 0 ; i < N ; i ++ )
            maxHeap.insert( new Integer((int)(Math.random() * M)) );

        Integer[] arr = new Integer[N];
        // 将maxheap中的数据逐渐使用extractMax取出来
        // 取出来的顺序应该是按照从大到小的顺序取出来的
        for( int i = 0 ; i < N ; i ++ ){
            arr[i] = maxHeap.extractMax();
            System.out.print(arr[i] + " ");
        }
        
        System.out.println();

        // 确保arr数组是从大到小排列的
        for( int i = 1 ; i < N ; i ++ )
            assert arr[i-1] >= arr[i];
    }
}
