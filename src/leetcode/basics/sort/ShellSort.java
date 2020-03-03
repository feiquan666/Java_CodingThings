package leetcode.basics.sort;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int[] array = new int[]{1, 15, 2, 3, 6, 9, 7};
        System.out.println(Arrays.toString(array));
        int len = array.length, temp, gap = len / 2;
        while (gap > 0){
            for(int i = gap; i < len; i++){
                temp = array[i];
                int preIndex = i - gap;
                while (preIndex >= 0 && array[preIndex] > temp){
                    array[preIndex + gap] = array[preIndex];
                    preIndex -= gap;
                }
                array[preIndex + gap] = temp;
            }
            gap /= 2;
        }
        System.out.println(Arrays.toString(array));
    }
}
