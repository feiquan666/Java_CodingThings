package mianshiti;

import java.util.Scanner;

public class MyCalculation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(getOutput(scanner.next().split("\\+")));
    }

    /**
     * 获取输出：把每一项加起来，最后取模。
     * 如果遇到不能转化为数字的项，则先使用乘法求积再加和
    */
    private static long getOutput(String[] input){
        long result = 0;// 存放最终结果
        long number = 0;// 存放数组中每一项的计算值
        for(String item : input){
            try {
                number = Long.valueOf(item);//不能转为long型时会进入catch
            }catch (Exception e){
                number = getMulResult(item);
            }finally {
                result += number;
            }
        }
        return Math.floorMod(result,10000);
    }
    /**
     * 获取乘法结果
    */
    private static long getMulResult(String express) {
        String[] nums = express.split("\\*");
        long result = 1;// 此处必须赋值为1，否则结果总为0
        for(String item: nums){
            result *= Long.valueOf(item);
        }
        return result;
    }
}
