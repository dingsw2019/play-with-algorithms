package sw.algo;

import java.lang.reflect.Method;

/**
 * 选择排序的测试辅助函数
 */
public class SortTestHelper {


    // 生成有n个元素的随机数组, 每个元素随机范围为[rangeL, rangeR]
    public static Integer[] generateRandomArray(int n, int rangeL, int rangeR) {

        // 范围正确
        assert rangeL <= rangeR;

        // 内存空间
        Integer[] arr = new Integer[n];

        // 填充随机数
        for (int i = 0; i < n; i++)
            arr[i] = new Integer((int)(Math.random() * (rangeR - rangeL + 1) + rangeL));

        return arr;
    }

    // 打印arr数组的所有内容
    public static void printArray(Object arr[]) {

        for (int i = 0; i < arr.length; i ++) {
            System.out.print(arr[i]);
            System.out.print(' ');
        }

        System.out.println();
    }

    // 检查数组arr是否按从小到大排序
    public static boolean isSorted(Comparable[] arr){
        for (int i = 0; i < arr.length; i ++)
            if (arr[i].compareTo(arr[i+1]) > 0)
                return false;
        return true;
    }

    // 测试排序算法的正确性和算法运行时间
    public static void testSort(String sortClassName, Comparable[] arr){

        // 反射机制获取排序算法
        try {
            Class sortClass = Class.forName(sortClassName);
            Method sortMethod = sortClass.getMethod("sort",new Class[]{Comparable[].class});
            // 排序参数
            Object[] params = new Object[]{arr};

            long startTime = System.currentTimeMillis();
            // 调用排序函数
            sortMethod.invoke(null,params);
            long endTime = System.currentTimeMillis();

            // 检查排序正确性

            System.out.println(sortClass.getSimpleName() + " : " + (endTime-startTime) + "ms");


        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
