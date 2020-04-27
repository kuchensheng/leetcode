package cn.com.leetcode.simple;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * Desription:
 *
 * @author:Hui CreateDate:2019/4/8 20:55
 * version 1.0
 */
public class SimpleClass {
    public static void main(String[] args) {


//        try {
//            int[] indexs = twoSum(new int[]{2,7,11,15},9);
//            System.out.println("[" + indexs[0] +"," + indexs[1] +"]");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode listNode = addTwoNumbers(l1, l2);
        while (null != listNode) {
            System.out.print(listNode.val + "->");
            listNode = listNode.next;
        }
//        System.out.println(new SimpleClass().findLength(new int[]{0,0,0,0,1},new  int[]{1,0,0,0,0}));
    }

    /**
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     */
    private static int[] twoSum(int[] nums,int target) throws Exception {
        //时间复杂度O(n²)
        int[] ret = new int[2];
        for (int i=0;i<nums.length;i++) {
            for (int j = i;j<nums.length;j++) {
                if(nums[i] == (target - nums[j])) {
                    ret[0] = i;
                    ret[1] = j;
                    return ret;
                }
            }
        }
        throw new Exception("");
    }

    /**
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     * @param l1
     * @param l2
     * @return
     */
    private static ListNode addTwoNumbers(ListNode l1,ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    /*给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。*/
    public int findLength(int[] A, int[] B) {
        Set<Integer> setA = new HashSet<>(A.length);
        for (int i=0;i<A.length;i++) {
            setA.add(A[i]);
        }
        int count = 0;
        for(int i=0;i<B.length;i++) {
            if(setA.contains(B[i])) {
                count  = count + 1;
            }
        }

        return count;
    }
}
