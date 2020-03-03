package leetcode.basics.sort;
import org.junit.Test;
import java.util.Arrays;

public class BubbleSort {
    private int[] array = {2,3,4,5,6,7,8,1};
    /**
     * 原始的冒泡排序实现
    */
    @Test
    public void bubbleSort() {
        int count = 0;
        int temp;
        // 排序论数：n - 1
        for (int i = 0, j = array.length - 1; i < j; i++) {
            // 每轮排序的比较次数： n - i - 1
            for (int p = 0, q = j - i; p < q; p++) {
                if (array[p] > array[p + 1]) {
                    temp = array[p + 1];
                    array[p + 1] = array[p];
                    array[p] = temp;
                }
                count ++;
            }
        }
        System.out.println(Arrays.toString(array));
        System.out.println(count);
    }
    /**
     * 通过加入isContinue监听数组是否已经有序而决定是否跳出循环
    */
    @Test
    public void bubbleSortPlus() {
        int count = 0;
        int temp;
        boolean isContinue;
        for (int i = 0, j = array.length - 1; i < j; i++) {
            isContinue = true;
            for (int p = 0, q = j - i; p < q; p++) {
                if (array[p] > array[p + 1]) {
                    temp = array[p + 1];
                    array[p + 1] = array[p];
                    array[p] = temp;
                    isContinue =false;
                }
                count ++;
            }
            if(isContinue)
                break;
        }
        System.out.println(Arrays.toString(array));
        System.out.println(count);
    }
    /**
     * 通过记录最后一次交换的位置和无序数组的边界从而减少无效的比较
    */
    @Test
    public void bubbleSortPlusPlus() {
        int count = 0;
        int lastExchangeIndex = 0;//最后一次交换的位置
        int sortBorder = array.length - 1;//无序数组的边界，每次比较到这里即可，后面都是有序的
        int temp;
        boolean isContinue;
        for (int i = 0, j = array.length - 1; i < j; i++) {
            isContinue = true;
            for (int p = 0; p < sortBorder; p++) {
                if (array[p] > array[p + 1]) {
                    temp = array[p + 1];
                    array[p + 1] = array[p];
                    array[p] = temp;
                    isContinue =false;
                    lastExchangeIndex = p;
                }
                count++;
            }
            sortBorder = lastExchangeIndex;
            if(isContinue)
                break;
        }
        System.out.println(Arrays.toString(array));
        System.out.println(count);
    }

    /**
     * 鸡尾酒排序
    */
    @Test
    public void guLuGuLu04() {
        int count = 0;
        int temp;
        boolean isOrderly;
        for (int i = 0; i < array.length / 2; i++) {
            isOrderly = true;
            for (int j = i; j < array.length - i - 1; j++){
                count++;
                if (array[j] > array[j+1]) {
                    temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;
                    isOrderly = false; // 当发生交换,证明数组无序
                }
            }
            if (isOrderly) {
                break;
            }
            isOrderly = true;
            for (int j = array.length - 1; j > i ; j--){
                count++;
                if (array[j] < array[j-1]) {
                    temp = array[j-1];
                    array[j-1] = array[j];
                    array[j] = temp;
                    isOrderly = false; // 当发生交换,证明数组无序
                }
            }
            if (isOrderly) {
                break;
            }
        }
        System.out.println(Arrays.toString(array));
        System.out.println(count);
    }
}
