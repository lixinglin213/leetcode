package leetcode;

/**
 * [7,1,5,3,6,4] 7
 * [1,2,3,4,5] 4
 * [7,6,4,3,1] 0
 *
 * @author lixinglin
 * @date 2020/4/6 5:54 下午
 * @since jdk 1.8
 */
public class MaxProfit_medium {
    public static void main(String[] args) {
        int[] nums = {7, 1, 5, 3, 6, 4};

        int maxProfit = MaxProfit_medium.maxProfit(nums);
        System.out.print(maxProfit);
    }

    public static int maxProfit(int[] nums) {
        int maxProfit = 0;
        int minValue = nums[0];

        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] > nums[i - 1]) {
                maxProfit += nums[i] - nums[i - 1];
            }

            if (minValue > nums[i]) {
                minValue = nums[i];
            }
        }

        return maxProfit;
    }
}
