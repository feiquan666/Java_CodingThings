package mianshiti;

import java.util.Arrays;

public class TTT {
    public static void main(String[] args) {
        int[][] a = new int[][]{
                {1,2,3},{4,5,6},{7,8,9}
        };
        for(int i = 0; i < a.length; i++){
            for (int j = 0; j < a[i].length; j++){
                outSon(a,new int[][]{{a[i][j]}},0);
            }
        }
    }
    public static void outSon(int[][] father,int[][] flag,int max){
        int sum = printArray(flag);//输出子矩阵
        max = sum > max ?  sum : max;
        System.out.println(": "+sum);
    }

    /**
     * 以[a01,a02;a11,a12]的格式输出二维数组
    */
    public static int printArray(int[][] array){
        System.out.print("[");
        int sum = 0;
        for(int i = 0; i < array.length; i++){
            for (int j = 0; j < array[i].length; j++){
                if(j == array[i].length - 1){
                    System.out.print(array[i][j]);
                    sum += array[i][j];
                    continue;
                }
                System.out.print(array[i][j]+",");
            }
            if(i == array.length - 1){
                continue;
            }
            System.out.print(";");
        }
        System.out.print("]");
        return sum;
    }
}
