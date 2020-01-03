package mianshiti;

import java.util.Scanner;

public class T {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = input.nextInt();
            }
        }
        System.out.println(maxSum(arr));
    }
    public static int maxSum(int[][] arr) {
        if (arr == null || arr.length == 0 || arr[0].length == 0) {
            return 0;
        }
        int max = Integer.MAX_VALUE;
        int cur = 0;
        int[] s = null;
        for (int i = 0; i < arr.length; i++) {
            s = new int[arr[0].length];
            for (int j = 0; j < arr.length; j++) {
                cur = 0;
                for (int k = 0; k < s.length; k++) {
                    s[k] += arr[j][k];
                    cur += s[k];
                    max = Math.max(max,cur);
                    cur = cur < 0 ? 0 :  cur;
                }
            }
        }
        return max;
    }
}
