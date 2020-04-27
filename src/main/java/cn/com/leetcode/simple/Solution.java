package cn.com.leetcode.simple;

import sun.security.util.Length;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

/**
 * Desription:
 *
 * @author:Hui CreateDate:2019/4/10 22:43
 * version 1.0
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println("最大长度"+ solution.lengthOfLongesSubstring("pwwkew"));
//        System.out.println(solution.findMedianSortedArrays(new int[]{1,2},new int[]{3,4}));
        System.out.println(solution.longesPalindrome("abcda"));
    }

    public String convert(String s,int numRows) {
        if(null == s || s.length() < 1)  {
            return "";
        }
        if(s.length() <=numRows) {
            return s;
        }

        int counter = 1;
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<s.length();i++) {
            if(i<numRows * counter) {
                sb.append(s.charAt(i));
            }else {
                counter ++;
            }
        }

        return "";
    }
    public String longesPalindrome(String s) {
        if(null == s || s.length() == 0) {
            return "";
        }
        if(s.length() == 1) {
            return s;
        }
        if(s.length() == 2) {
            if(s.charAt(0) == s.charAt(1)) {
                return s;
            }
            return s.charAt(0)+"";
        }

        //str倒转
        Stack<Character> characterStack = new Stack<>();
        for (int i = 0;i<s.length();i++) {
            characterStack.push(s.charAt(i));
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!characterStack.empty()) {
            stringBuilder.append(characterStack.pop());
        }

        String str = stringBuilder.toString();
        int center = str.length() /2;
        int start=0;
        int end = s.length();
        for (int i = center;i>=0;i--) {
            //遍历左半部分
            if(s.charAt(i) != str.charAt(i)) {
                start = i;
                break;
            }
        }
        for (int i=center +1;i<str.length();i++) {
            //遍历右半部分
            if(s.charAt(i) != str.charAt(i)) {
                end = i;
                break;
            }
        }

        if(str.substring(start,end).equals(s.substring(start,end))) {
            return str.substring(start,end);
        } else {
            if(start == 0 && end == s.length() ) {
                return s.charAt(0)+"";
            }
        }
        return "";
    }
    /**
     * 获取集合的中位数
     * 中位数：将一个集合划分为两个长度相等的子集，其中一个子集中的元素总是大于另一个子集中的元素。
     * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1,int[] nums2) {
        if(nums1 == null || nums2 == null) {
            return 0;
        }
        if(nums1.length > nums2.length) {

        }
        int nums1Max = 0;
        for (int i=0;i<nums1.length;i++) {
            if(nums1[i] >= nums2[0]) {
                nums1Max = nums1[i];
                break;
            }
            if(i == (nums1.length -1)) {
                //到最后一个
                return ((double)(nums1[i] + nums2[0])) /2;
            }
        }
        if((nums1.length  + nums2.length) % 2 == 0) {
            return ((double)(nums1Max + nums2[0])) /2;
        } else {
            return  nums2[0];
        }

    }
    /**
     * 获取字符串中子串的最大长度
     * @param s
     * @return
     */
    public int lengthOfLongesSubstring(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        if(s.length() == 1) {
            return 1;
        }

        int max = 1;
        List<Integer> samMax = new ArrayList<>();
        int start = 0;
        int end = 0;
        for (int i=0;i<s.length();i++) {
            if(end !=0 && i == end) {
                end ++;
                continue;
            }
            Character character = s.charAt(i);
            String sub = s.substring(i + 1);
            int length = sub.indexOf(character) + 1;
            end = length;
            if(length == 0) {
                length = 1;
            }
            if(max < length) {
                max = length;
            }else if(max == length) {
                samMax.add(max);
            }
        }

        samMax.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        if(samMax.size() > 0) {
            int val = samMax.get(0);
            if(val == 1) {
                for (int i=1;i<samMax.size();i++) {
                    if(1 == samMax.get(i).intValue()) {
                        val += samMax.get(i);
                    }else {
                        break;
                    }
                }
            }
            max = val;
        }



        return max;
    }
}
