package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by CLAY on 2017/6/26.
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class TwoSum {
    //1.时间复杂度 O(n^2),空间复杂度 O(1)
    public int[] twoSum1(int[] nums, int target) {
        if(nums == null || nums.length <= 1){
            throw new IllegalArgumentException("Illegal argument");
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[] { i, j };
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    //2.时间复杂度 O(n),空间复杂度 O(n),two-pass
    public int[] twoSum2(int[] nums, int target) {
        if(nums == null || nums.length <= 1){
            throw new IllegalArgumentException("Illegal argument");
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    //3.时间复杂度 O(n),空间复杂度 O(n),one-pass
    public int[] twoSum3(int[] nums, int target) {
        if(nums == null || nums.length <= 1){
            throw new IllegalArgumentException("Illegal argument");
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
