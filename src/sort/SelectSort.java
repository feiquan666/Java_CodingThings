package sort;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int[] array = new int[]{1,15,2,3,6,9,7};
        System.out.println(Arrays.toString(array));
        int temp;
        for(int i = 0, j = array.length; i < j; i++){
            int maxIndex = i;
            for(int p = i, q = j; p < q; p++){
                if(array[maxIndex] < array[p]){
                    maxIndex = p;
                }
            }
            temp = array[maxIndex];
            array[maxIndex] = array[i];
            array[i] = temp;
        }
        System.out.println(Arrays.toString(array));
    }
}
