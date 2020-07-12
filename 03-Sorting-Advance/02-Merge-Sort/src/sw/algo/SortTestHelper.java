package sw.algo;

import java.lang.reflect.Method;

public class SortTestHelper {

    private SortTestHelper(){}

    // 生成有n个元素的随机数组, 每个元素随机范围为[rangeL,rangeR]
    public static Integer[] generateRandomArray(int n, int rangeL, int rangeR) {

        assert rangeL <= rangeR;

        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i ++) {
            arr[i] = new Integer((int)(Math.random() * (rangeR - rangeL + 1) + rangeL));
        }

        return arr;
    }

    // 生成一个近乎有序的数组
    public static Integer[] generateNearlyOrderedArray(int n, int swapTimes) {
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++)
            arr[i] = new Integer(i);

        for (int i = 0; i < swapTimes; i ++) {
            int a = (int)(Math.random() * n);
            int b = (int)(Math.random() * n);
            int t = arr[a];
            arr[a] = arr[b];
            arr[b] = t;
        }

        return arr;
    }

    // 打印arr数组的内容
    public static void printArray(Object[] arr) {

        for (int i = 0; i < arr.length; i ++) {
            System.out.print(arr[i]);
            System.out.print(' ');
        }

        System.out.println();
    }

    // 检查数组arr是否按从小到大排序
    public static boolean isSorted(Comparable[] arr){

        for (int i = 0; i < arr.length - 1; i ++)
            if (arr[i].compareTo(arr[i+1]) > 0)
                return false;

        return true;
    }

    // 测试排序算法的正确性和算法运行时间
    public static void testSort(String sortClassName, Comparable[] arr){

        // 使用反射机制, 调用类和方法
        try {
            Class sortClass = Class.forName(sortClassName);
            Method sortMethod = sortClass.getMethod("sort",new Class[]{Comparable[].class});
            // 参数
            Object[] params = new Object[]{arr};

            // 计算运行时间
            long startTime = System.currentTimeMillis();
            sortMethod.invoke(null,params);
            long endTime = System.currentTimeMillis();

            // 检查排序正确性
            assert isSorted(arr);

            // 运行时间
            System.out.println(sortClass.getSimpleName() + " : " + (endTime-startTime) + "ms");

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
