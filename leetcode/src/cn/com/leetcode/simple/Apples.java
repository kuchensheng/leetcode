package cn.com.leetcode.simple;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 篮子里有100个苹果，将这些苹果进行编号，从0开始到99，
 * 现在将这些苹果分成4份，第一份21个，第二份30个，第三份38个，
 * 最后一份11个，要求是苹果的编号不能连续。
 * first = 38，
 */
public class Apples {

    private static List<Integer> apples = new CopyOnWriteArrayList<>();

    private static Map<Integer,List<Integer>> listMap = new HashMap<>();

    private static Random random = new Random();
    /**
     * 编号
     */
    public void init() {
        for (int i= 0;i<100;i++) {
            apples.add(i);
        }
    }

    public void diffApples() {
        List<Integer> list = new ArrayList<>();
        addItems(21,list);
        listMap.put(1,list);
        list = new ArrayList<>();
        addItems(30,list);
        listMap.put(2,list);
        addItems(38,list = new ArrayList<>());
        listMap.put(3,list);
        addItems(11,list = new ArrayList<>());
        listMap.put(4,list);
    }

    private void addItems(int size, List<Integer> list) {

        while (list.size() < size) {
            int index = random.nextInt(apples.size());

            int listMaxIndex = list.size() - 1;
            if (list.size() == 0 || Math.abs(apples.get(index) - list.get(listMaxIndex)) != 1) {
                list.add(apples.get(index));
                apples.remove(index);
            }
        }
    }

    public static void main(String[] args) {
        Apples apples = new Apples();
        apples.init();
        apples.diffApples();
        listMap.forEach((index,list) -> {
            System.out.println("index["+index+"]:"+list);
        });
    }

}
