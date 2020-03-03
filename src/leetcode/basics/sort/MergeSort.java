package leetcode.basics.sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] nums = new int[] { 4,2,3,1};
        int[] newNums = mergeSort(nums);
        System.out.println(Arrays.toString(newNums));
    }
    public static int[] mergeSort(int[] array) {
        // 单元素数组直接返回
        if (array.length < 2) return array;
        int mid = array.length / 2; // 4
        // copyOfRange(int[] original, int from, int to)：包含 from，不包含 to
        int[] left = Arrays.copyOfRange(array, 0, mid); // [1,8,3,5]
        int[] right = Arrays.copyOfRange(array, mid, array.length); // [2,7,6,4]
        return merge(mergeSort(left), mergeSort(right));
    }

    // 归并排序——将两段排序好的数组结合成一个排序数组
    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length]; // 归并后的数组的长度
        // left:[1,8,3,5] right:[2,7,6,4]
        for (int index = 0, i = 0, j = 0; index < result.length; index++) {
            if (i >= left.length) // 说明左边已全部入result,剩余的右边均比左边大(或小)
                result[index] = right[j++];
            else if (j >= right.length)// 说明右边已全部入result,剩余的左边均比左边小(或大)
                result[index] = left[i++];
            else if (left[i] > right[j]) // 左 > 右
                result[index] = right[j++];
            else // 左 <= 右
                result[index] = left[i++];
        }
        return result;
    }

    // 一次性版
    public static int[] mergeSort(int[] nums, int l, int h) {
        if (l == h)
            return new int[] { nums[l] };
        int mid = l + (h - l) / 2;
        int[] leftArr = mergeSort(nums, l, mid); //左有序数组
        int[] rightArr = mergeSort(nums, mid + 1, h); //右有序数组
        int[] newNum = new int[leftArr.length + rightArr.length]; //新有序数组

        int m = 0, i = 0, j = 0;
        while (i < leftArr.length && j < rightArr.length) {
            newNum[m++] = leftArr[i] < rightArr[j] ? leftArr[i++] : rightArr[j++];
        }
        while (i < leftArr.length)
            newNum[m++] = leftArr[i++];
        while (j < rightArr.length)
            newNum[m++] = rightArr[j++];
        return newNum;
    }
}
