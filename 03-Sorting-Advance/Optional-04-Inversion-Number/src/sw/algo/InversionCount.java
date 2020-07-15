package sw.algo;

import java.util.Arrays;

public class InversionCount {

    private InversionCount(){}
    
    private static long merge(Comparable[] arr, int l, int mid, int r) {
        Comparable[] aux = Arrays.copyOfRange(arr,l,r+1);

        long res = 0L;
        int i = l, j = mid+1;
        for (int k = l; k <= r; k ++) {
            if (i > mid) {
                arr[k] = aux[j-l]; j++;
            } else if (j > r) {
                arr[k] = aux[i-l]; i++;
            } else if (aux[i-l].compareTo(aux[j-l]) < 0) {
                arr[k] = aux[i-l]; i++;
            } else {
                arr[k] = aux[j-l]; j++;
                res += (long)(mid-i+1);
            }
        }

        return res;
    }

    private static long sort(Comparable[] arr, int l, int r) {

        if (l >= r)
            return 0L;

        int mid = l + (r-l)/2;
        long res1 = sort(arr,l,mid);
        long res2 = sort(arr,mid+1,r);

        return res1 + res2 + merge(arr,l,mid,r);
    }

    public static void sort(Comparable[] arr){
        int n = arr.length;
        sort(arr,0,n-1);
    }

    public static void main(String[] args) {
        int N = 300000;
        Integer[] arr = SortTestHelper.generateRandomArray(N,0,N);

//        SortTestHelper.printArray(arr);

        SortTestHelper.testSort("sw.algo.InversionCount",arr);

//        SortTestHelper.printArray(arr);


    }
}
