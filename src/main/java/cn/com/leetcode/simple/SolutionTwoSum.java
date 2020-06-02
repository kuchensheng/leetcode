package cn.com.leetcode.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * Desription:
 *
 * @author:Hui CreateDate:2019/5/14 23:21
 * version 1.0
 */
public class SolutionTwoSum {
    public static void main(String[] args) {
        int[] nums = new int[]{3,2,4};
        int target = 6;
        int[] ints = twoSum(nums, target);
        System.out.println(ints[0] +"," + ints[1]);
    }

    private static int[] twoSum(int[] nums,int target) {
        Map<Integer/**/,Integer> map = new HashMap<>(nums.length);
        for (int i=0;i<nums.length;i++) {
            map.put(nums[i],i);
        }

        for (int i = 0;i<nums.length;i++) {
            Integer y = map.get(target - nums[i]);
            if(null != y) {
                return new int[]{i,y};
            }


        }
        throw new RuntimeException("没有找到相关值");
    }
}
