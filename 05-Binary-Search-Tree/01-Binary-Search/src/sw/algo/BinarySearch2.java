package sw.algo;

public class BinarySearch2 {

    private BinarySearch2(){}

    // 递归二分查找
    private static int find(Comparable[] arr, int l, int r, Comparable target) {

        if (l >= r)
            return -1;

        int mid = l + (r-l)/2;
        if (target.compareTo(arr[mid]) == 0)
            return mid;
        else if (target.compareTo(arr[mid]) > 0)
            return find(arr,mid+1,r,target);
        else
            return find(arr,l,mid-1,target);

    }

    public static int find(Comparable[] arr, Comparable target) {
        return find(arr,0,arr.length-1,target);
    }

    // 测试递归的二分查找算法
    public static void main(String[] args) {

        int N = 1000000;
        Integer[] arr = new Integer[N];
        for(int i = 0 ; i < N ; i ++)
            arr[i] = new Integer(i);

        // 对于我们的待查找数组[0...N)
        // 对[0...N)区间的数值使用二分查找，最终结果应该就是数字本身
        // 对[N...2*N)区间的数值使用二分查找，因为这些数字不在arr中，结果为-1
        for(int i = 0 ; i < 2*N ; i ++) {
            int v = BinarySearch2.find(arr, new Integer(i));
            if (i < N)
                assert v == i;
            else
                assert v == -1;
        }

        return;
    }
}
