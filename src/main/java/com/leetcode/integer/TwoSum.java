package com.leetcode.integer;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    /**
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * 给定 nums = [2, 7, 11, 15], target = 9
     * 返回 [0, 1]
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0;i<nums.length;i++) {
            map.put(nums[i],i);
        }
        for (int i=0;i<nums.length;i++) {
            int result = target - nums[i];
            if (map.containsKey(result) && map.get(result) != i) {
                return new int[]{i,map.get(result)};
            }
        }

        throw new IllegalArgumentException("No two sum sollution");
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,7,9};
        int[] result = new TwoSum().twoSum(nums,10);
        System.out.println(result[0]+"\t"+result[1]);
    }
}
