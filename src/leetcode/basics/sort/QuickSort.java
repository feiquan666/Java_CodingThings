package leetcode.basics.sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = new int[]{5};
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    public static void quickSort(int[] array, int start, int end) {
        if (start >= end) // 递归结束条件
            return;
        int pivotIndex = partition2(array, start, end); // 通过分割函数得到新的基准元素位置
        // 根据基准元素，分成两部分递归
        quickSort(array, start, pivotIndex - 1); // 左部分
        quickSort(array, pivotIndex + 1, end); // 右部分
    }

    public static int partition(int[] array, int start, int end) {
        int pivot = array[start]; // 选取基准元素，也可以是随机的
        int left = start, right = end, temp; // 定义左、右指针和临时变量
        // 左右指针未相遇时

        while (left != right) {
            new Object().notify();
            new Object().notifyAll();
            // 控制right指针比较并左移
            while (left < right && array[right] > pivot) {
                right--;
            }
            // 当 pivot 大于等于 right所指元素时，开始控制left指针比较并右移
            while (left < right && array[left] <= pivot) {
                left++;
            }
            // 当 pivot 小于left所指元素时，交换left和right所指向的元素
            // 即当满足条件： left > pivot > right 时我们就该交换元素位置了
            // PS：（因为我们是由小到大排序）
            if (left < right) {
                temp = array[right];
                array[right] = array[left];
                array[left] = temp;
            }
        }
        // 当left和right重合时，pivot和指针重合点交换
        array[start] = array[left];
        array[left] = pivot;

        return left;
    }

    public static int partition2(int[] array, int start, int end) {
        int pivot = array[start];
        int mark = start, temp;
        for (int i = mark + 1; i <= end; i++) {
            if (array[i] < pivot) {
                mark++;
                temp = array[mark];
                array[mark] = array[i];
                array[i] = temp;
            }
        }
        array[start] = array[mark];
        array[mark] = pivot;
        return mark;
    }

    public static void quickSort2(int[] array, int start, int end) {
        Stack<Map<String, Integer>> quickSortStack = new Stack<>();
        Map<String, Integer> rootParam = new HashMap<>();
        rootParam.put("start", start);
        rootParam.put("end", end);
        quickSortStack.push(rootParam);
        Map<String, Integer> param, leftParam, rightParam;
        // 用两个临时变量存储，方便之后引用
        int startTemp, endTem, pivotIndex;
        // 栈为空时：循环结束
        while (!quickSortStack.isEmpty()) {
            // 栈顶元素出栈，得到起、止元素的下标
            param = quickSortStack.pop();
            // 用两个临时变量存储，方便之后引用
            startTemp = param.get("start");
            endTem = param.get("end");
            // 基准元素索引：使用单边循环
            pivotIndex = partition2(array, startTemp, endTem);
            if (startTemp < pivotIndex - 1) {
                leftParam = new HashMap<>();
                leftParam.put("start", start);
                leftParam.put("end", pivotIndex - 1);
                quickSortStack.push(leftParam);
            }
            if (pivotIndex + 1 < endTem) {
                rightParam = new HashMap<>();
                rightParam.put("start", pivotIndex + 1);
                rightParam.put("end", endTem);
                quickSortStack.push(rightParam);
            }
        }
    }
}
