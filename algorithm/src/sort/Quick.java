package sort;

import java.util.Arrays;

/**
 * @author lixinglin
 * @date 2020/4/6 3:28 下午
 * @since jdk 1.8
 */
public class Quick {

    public static void main(String[] args) {
        int[] nums = {4, 1, 9, 1, 1, 7, 1, 1, 89, 1};
        int[] sort = Quick.sort(nums, 0, nums.length - 1);
        System.out.print(Arrays.toString(nums));
    }

    public static int[] sort(int[] nums, int left, int right) {
        //二分法
        if (left < right) {
            int pivot = pivot(nums, left, right);
            sort(nums, 0, pivot - 1);
            sort(nums, pivot + 1, right);
        }
        return nums;
    }

    private static int pivot(int[] nums, int first, int last) {

        int pivot = nums[first];

        int begin = first;

        while (first < last) {

            while (nums[last] >= pivot && first < last) {
                last--;
            }

            while (nums[first] <= pivot && first < last) {
                first++;
            }


            int tmp = nums[first];
            nums[first] = nums[last];
            nums[last] = tmp;
        }

        //
        int tmp = nums[first];
        nums[first] = nums[begin];
        nums[begin] = tmp;

        return first;
    }

}
