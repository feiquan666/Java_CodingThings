package leetcode.basics.sort;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] array = new int[]{1, 15, 2, 3, 6, 9, 7};
        System.out.println(Arrays.toString(array));
        int current; // 待比较元素
        for (int i = 0, j = array.length - 1; i < j; i++){
            current = array[i+1];
            int lastIndex = i;
            while (lastIndex >= 0 && current > array[lastIndex]){
                array[lastIndex+1] = array[lastIndex];
                lastIndex--;
            }
            array[lastIndex+1] = current;
        }
        System.out.println(Arrays.toString(array));
    }
}
