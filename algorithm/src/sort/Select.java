package sort;

import java.util.Arrays;

/**
 * 选择排序
 *
 * @author lixinglin
 * @date 2020/4/6 2:58 下午
 * @since jdk 1.8
 */
public class Select {

    public static void main(String[] args) {
        int[] nums = {5, 2, 6, 2, 1, 8, 1, 2, 9};
        int[] sort = Select.sort(nums);

        System.out.print(Arrays.toString(sort));

    }

    public static int[] sort(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            int min = nums[i];
            for (int j = i; j < nums.length - 1; j++) {

                if (min > nums[j + 1]) {
                    min = nums[j + 1];
                }
            }
            //swap
            for (int r = i; r < nums.length; r++) {
                if (min == nums[r]) {
                    int tmp = nums[r];
                    nums[r] = nums[i];
                    nums[i] = tmp;
                    break;
                }
            }

        }
        return nums;
    }
}
