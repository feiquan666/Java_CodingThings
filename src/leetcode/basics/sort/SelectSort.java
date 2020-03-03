package leetcode.basics.sort;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int[] array = new int[]{1,15,2,3,6,9,7};
        System.out.println(Arrays.toString(array));
        selectSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void selectSort(int[] array){
        int minIndex, temp; // 最小元素的索引
        for (int i = 0; i < array.length; i++) {
            minIndex = i; // 最小元素索引默认为：无序区的首元素索引
            for (int j = i + 1; j < array.length; j++) {
                // 当大于当前遍历的元素时，修改最小索引为当前元素的索引
                if (array[minIndex] > array[j]) {
                    minIndex = j;
                }
            }
            // 每轮循环结束后,将找到的最小元素与无序区首位元素交换
            if (minIndex != i){
                temp = array[minIndex];
                array[minIndex] = array[i];
                array[i] = temp;
            }
        }
    }
}
