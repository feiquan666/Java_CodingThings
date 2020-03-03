package leetcode.practiced;


import java.util.HashMap;
import java.util.Map;

public class Practiced01 {
    public static void main(String[] args) {
        int[] a = {8, -6, 4, -17, 0, -19, -12, -30, 9, -12, -6, -18, 6, -8, -26, -13, -3, -28, -17, -2, -17, -31, -5, -10, 10, -18, -17, -24, -17, 2, 3, -31, -27, -27, -31, 4, -17, 9, -19, -18, -29, 0, 1, 0, -21, 8, 5, -20, -7, -20, 9, -31, -9, -17, -16, -18, 3, 9, -9, -23, -5, 6, -17, -5, 3, -10, -19, -31, -31, -30, -2, -1, -21, -25, -30, -30, -22, -29, 0, 5, -16, -31, -28, -9, -14, -24, -16, -20, -28, -23, -30, -32, -11, -32, -30, -27, 3, -21, -17, -16},
                b = {-16, 0, -28, -15, -30, -8, -3, -23, -2, -30, -28, -14, -24, -28, -27, -3, 1, -15, -26, 5, -18, 9, -12, -23, -2, 10, -30, -2, -22, -10, 0, 6, 0, -3, 9, -9, 3, -24, 7, 4, 10, -12, -6, -7, -30, -13, 0, -22, -5, -25, -8, -28, -7, -13, -1, -26, -1, -4, 0, 10, -30, -21, -23, -11, 4, 4, -8, -23, -22, 5, -20, -7, -29, -1, -7, 9, -10, -17, -15, 2, 0, -20, -4, -30, -30, -31, -22, -21, -25, -5, -3, 0, -13, -8, -18, -19, 4, -5, -20, 0},
                c = {10, 10, -14, -27, -13, 2, 4, 1, -31, -1, -5, -23, 10, -16, 5, -6, -30, -14, -18, -9, -27, 6, -28, -19, -9, 6, -29, -17, -32, -15, 4, -19, -27, -2, 5, -25, -14, -18, -14, -17, -26, -6, -19, -17, -13, 0, -32, -25, 3, -4, -10, -17, -28, 8, -29, -12, -25, -24, -5, -8, 2, -22, -1, -6, -26, 10, -31, 9, -7, 6, -21, -31, -31, -21, -25, -5, 9, 10, -6, 5, -22, -9, -21, 5, -8, -29, -8, 10, -23, -18, -11, -1, -1, -18, 8, -29, -23, -23, 4, -29},
                d = {7, -21, -3, -14, -18, 4, 10, 5, -4, -17, -19, -3, 2, -17, -4, 5, -20, -11, 3, -22, -19, 1, 0, -20, -3, 0, -11, -24, -15, -26, 2, 6, -26, 3, -3, -28, -5, -19, -13, -1, 10, -12, -32, 1, -6, -3, -3, -14, -11, -16, -23, 0, -18, -6, 10, -22, -1, -1, -20, -12, -14, -6, -24, 10, -1, -7, -11, -25, -11, -7, 9, -28, -17, -14, 5, -30, -20, -1, 6, 4, -17, 3, -14, -24, -16, -9, -32, -16, -27, -16, 9, 10, -16, -32, -18, -6, -20, -8, -1, -29};
        System.out.println(fourSumCount(a, b, c, d));
    }

    // 青蛙跳台阶
    public static int climbStairs(int n) {
        if (n == 0)
            return 1;
        if (n <= 2)
            return n;
        long fibOne = 1;
        long fibTow = 2;
        long res = 0;
        for (int i = 3; i <= n; i++) {
            res = (fibOne + fibTow) % 1000000007;
            fibOne = fibTow;
            fibTow = res;
        }
        return (int) res;
    }

    // 水果成篮
    public static int totalFruit(int[] tree) {
        if (tree.length == 1) {
            return 1;
        }
        int maxTotal = 0, left = tree[0], right = -1, leftC = 1, rightC = 0, total;
        for (int i = 1; i < tree.length; ++i) {
            if (left == tree[i]) { // 如果等于左
                ++leftC;
            } else if (right < 0) {
                right = tree[i];
                ++rightC;
            } else if (right == tree[i]) { // 如果等于右
                ++rightC;
            } else {
                total = rightC + leftC;
                maxTotal = total > maxTotal ? total : maxTotal;
                int nowI = i - 1;
                left = tree[nowI];
                right = tree[i];
                leftC = 1;
                rightC = 1;
                while (left == tree[nowI - 1]) {
                    ++leftC;
                    --nowI;
                }
            }
            if (i == tree.length - 1) {
                total = rightC + leftC;
                maxTotal = total > maxTotal ? total : maxTotal;
            }
        }
        return maxTotal;
    }

    // 四数之和||
    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int count = 0, sumAB, sumCD;
        Map<Integer, Integer> map = new HashMap<>(A.length * A.length);
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                sumAB = A[i] + B[j];
                if (map.containsKey(sumAB)) {
                    map.put(sumAB, map.get(sumAB) + 1);
                } else {
                    map.put(sumAB, 1);
                }
            }
        }
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                sumCD = -(C[i] + D[j]);
                if (map.containsKey(sumCD)) {
                    count += map.get(sumCD);
                }
            }
        }
        return count;
    }
}
