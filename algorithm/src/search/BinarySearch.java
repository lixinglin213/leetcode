package search;

import java.util.Arrays;

/**
 * 二分查找
 *
 * @author lixinglin
 * @date 2020/4/21 1:17 下午
 * @since jdk 1.8
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {4, 4, 4, 4, 6, 8};

        int[] search = BinarySearch.search(nums, 4);

        int[] ints = BinarySearch.search2(nums, 4);
        System.out.println(Arrays.toString(ints));
        System.out.println(Arrays.toString(search));
    }

    //二分查找
    public static int[] search(int[] nums, int target) {
        int left = 0;
        int pivot;
        int right = nums.length - 1;
        int[] res = {-1, -1};

        while (left <= right) {
            pivot = (right - left) / 2 + left;
            if (nums[pivot] == target) {
                int R = pivot;
                int L = pivot;

                while (R + 1 < nums.length && nums[R + 1] == target) {
                    R++;
                }
                // 找到最友边和target相等的元素
                while (L - 1 >= 0 && nums[L - 1] == target) {
                    L--;
                }
                // 若唯一，没有重复出现，则 L = R = mid未改变
                res[0] = L;
                res[1] = R;
                return res;

            } else if (nums[pivot] > target) {
                right = pivot - 1;
            } else if (nums[pivot] < target) {
                left = pivot + 1;
            }
        }

        return res;
    }

    //线性查找
    public static int[] search2(int[] nums, int target) {
        int[] result = {-1, -1};
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                result[0] = i;
                break;
            }
        }

        if (result[0] == -1) {
            return result;
        }

        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] == target) {
                result[1] = i;
                break;
            }
        }
        return result;
    }


}
