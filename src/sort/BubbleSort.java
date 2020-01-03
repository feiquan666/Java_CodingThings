package sort;
import org.junit.Test;
import java.util.Arrays;

public class BubbleSort {
    private int[] array = {1, 9, 8, 3, 7, 6, 6, 3, 5, 4};
    /**
     * 原始的冒泡排序实现
    */
    @Test
    public void bubbleSort() {
        int temp;
        for (int i = 0, j = array.length - 1; i < j; i++) {
            for (int p = 0, q = j - i; p < q; p++) {
                if (array[p] < array[p + 1]) {
                    temp = array[p + 1];
                    array[p + 1] = array[p];
                    array[p] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }
    /**
     * 通过加入isContinue监听数组是否已经有序而决定是否跳出循环
    */
    @Test
    public void bubbleSortPlus() {
        int temp;
        boolean isContinue;
        for (int i = 0, j = array.length - 1; i < j; i++) {
            isContinue = true;
            for (int p = 0, q = j - i; p < q; p++) {
                if (array[p] < array[p + 1]) {
                    temp = array[p + 1];
                    array[p + 1] = array[p];
                    array[p] = temp;
                    isContinue =false;
                }
            }
            if(isContinue)
                break;
        }
        System.out.println(Arrays.toString(array));
    }
    /**
     * 通过记录最后一次交换的位置和无序数组的边界从而减少无效的比较
    */
    @Test
    public void bubbleSortPlusPlus() {
        int lastExchangeIndex = 0;//最后一次交换的位置
        int sortBorder = array.length - 1;//无序数组的边界，每次比较到这里即可，后面都是有序的
        int temp;
        boolean isContinue;
        for (int i = 0, j = array.length - 1; i < j; i++) {
            isContinue = true;
            for (int p = 0; p < sortBorder; p++) {
                if (array[p] < array[p + 1]) {
                    temp = array[p + 1];
                    array[p + 1] = array[p];
                    array[p] = temp;
                    isContinue =false;
                    lastExchangeIndex = p;
                }
            }
            sortBorder = lastExchangeIndex;
            if(isContinue)
                break;
        }
        System.out.println(Arrays.toString(array));
    }
}
