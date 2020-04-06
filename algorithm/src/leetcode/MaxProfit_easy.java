package leetcode;

import java.util.Arrays;

/**
 * 121 .最大利润问题
 * <p>
 * 输入 输出 [7,6,4,3,2,1] 0
 * 输入 输出 [7,1,5,3,6,4] 5
 * <p>
 * 输入 输出 [7,2,9,1,6] 7
 *
 * @author lixinglin
 * @date 2020/4/6 5:18 下午
 * @since jdk 1.8
 */
public class MaxProfit_easy {

    public static void main(String[] args) {

        int[] nums = {7, 6, 4, 3, 2, 1};
        int[] nums2 = {7, 1, 5, 3, 6, 4};
        int[] nums3 = {7, 2, 9, 1, 6};
        int maxProfit = MaxProfit_easy.maxProfit(nums3);

        System.out.print(Arrays.toString(nums3) + "的最大利润为:" + maxProfit);
    }

    public static int maxProfit(int[] nums) {
        int maxProfit = 0;
        int minValue = nums[0];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - minValue > maxProfit) {
                maxProfit = nums[i] - minValue;
            }
            if (minValue > nums[i]) {
                minValue = nums[i];
            }
        }

        return maxProfit;
    }

}
