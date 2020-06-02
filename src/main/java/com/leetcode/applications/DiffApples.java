package com.leetcode.applications;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 将0-99个编号的苹果分为4份，
 * 第一份21个，第二份30个，第三份38个，第四份11个
 * 要求编号不连续
 * */
public class DiffApples {
    private static List<Integer> apples = new ArrayList<>();
    private static List<Integer> subList1 = new ArrayList<>();
    private static List<Integer> subList2 = new ArrayList<>();
    private static List<Integer> subList3 = new ArrayList<>();
    private static List<Integer> subList4 = new ArrayList<>();
    static {
        for (int i=0;i<100;i++) {
            apples.add(i);
        }

    }

    public static void diff() {
        addItem(subList1,11);
        addItem(subList2,21);
        addItem(subList3,30);
        subList4 = apples;
    }

    private static void addItem(List<Integer> subList, int size) {
        List<Integer> list = new ArrayList<>();
        list.addAll(apples);
        int midIndex = list.size() /2;
        int leftIndex = midIndex;
        int rightIndex = midIndex;
        if (list.size() % 2 == 0) {
            rightIndex = midIndex + 1;
        }

        while (subList.size() < size) {
            int leftVal = list.get(leftIndex--);

            if (subList.size() < size) {
                subList.add(leftVal);
                apples.remove(leftIndex);
            }

            int rightVal =  list.get(rightIndex++);
            if (subList.size() < size) {
                subList.add(rightVal);
                System.out.print("rightIndex="+rightIndex);
                if (rightIndex > apples.size()) {
                    rightIndex = apples.size() -1;
                }
                apples.remove(rightIndex);
            }
        }
        System.out.println();

    }

    public static void main(String[] args) {
        DiffApples.diff();
        subList1.forEach(item ->{
            System.out.print(item +"\t");

        });
        System.out.println();
        subList2.forEach(item ->{
            System.out.print(item +"\t");

        });
        System.out.println();
        subList3.forEach(item ->{
            System.out.print(item +"\t");

        });
        System.out.println();
        subList4.forEach(item ->{
            System.out.print(item +"\t");
        });

    }
}
