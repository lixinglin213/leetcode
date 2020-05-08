package sort;

import java.util.Arrays;

/**
 * 冒泡排序
 *
 * @author lixinglin
 * @date 2020/4/6 2:50 下午
 * @since jdk 1.8
 */
public class Bubble {

    public static void main(String[] args) {
        int[] nums = {4, 2, 1, 1, 6, 3};
        Bubble.sort(nums);
        System.out.print(Arrays.toString(nums));
    }

    public static void sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length - 1; j > i; j--) {

                if (nums[j] < nums[j - 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = tmp;
                }

            }
        }
    }


}
