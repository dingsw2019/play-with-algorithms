public class Selection {

    private Selection(){}

    private static int partition(Comparable[] arr, int l, int r) {
        swap(arr,l,(int)(Math.random()*(r-l+1)) +l);
        Comparable e = arr[l];

        int j = l;
        for (int i = l+1; i <= r; i ++) {
            if (arr[i].compareTo(e) < 0)
                swap(arr,i,++j);
        }

        swap(arr,l,j);
        return j;
    }

    private static Comparable solve(Comparable[] nums, int l, int r, int k) {
        if (l == r)
            return nums[l];

        int p = partition(nums,l,r);

        if (k == p)
            return nums[p];
        else if (k < p)
            return solve(nums,l,p-1,k);
        else
            return solve(nums,p+1,r,k);
    }

    public static Comparable slove(Comparable[] nums, int k) {
        return Selection.slove(nums,k-1);
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
