package sw.algo;

public class ShellSort {

    private ShellSort(){}

//    public static void sort(Comparable[] arr){
//        sort(arr,0,arr.length);
//    }
//
//    private void sort(Comparable[] arr, int l, int r){
//
//        if (l == r)
//            return;
//
//        int mid = l + (r - l) / 2;
//        for (int i = l; i < mid; i ++) {
//            if (arr[i].compareTo(arr[mid+1+i]) > 0)
//                swap(arr,i,mid+1+i);
//        }
//
//        sort(arr,l,mid);
//        sort(arr,mid+1,r);
//    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        Integer[] a = {10,9,8,7,6,5,4,3,2,1};
//        ShellSort.sort(a);

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
            System.out.print(' ');
        }
        System.out.println();
    }
}
