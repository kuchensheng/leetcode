package com.leetcode.integer;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * 整数反转
 * 123 => 321
 * -123 => -321
 * 120 => 21
 */
public class RevertInteger {

    public static int reverse(int x) {
        int ans = 0;
        while (x != 0) {
            if ((ans * 10) / 10 != ans) {
                ans = 0;
                break;
            }

            ans = ans * 10 + x % 10;
            x = x / 10;
        }
        return ans;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("输入一个值:");
        int x = scanner.nextInt();
        System.out.println(reverse(x));
        main(args);
    }
}
