package cn.com.leetcode.simple;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class NewString {

    public String getT1(String t,String s) {
        //时间复杂度为O(n),n取决于t和s最大的长度
        Set<Character> sSet = new HashSet<>();
        for (int i = 0;i<s.length();i++) {
            sSet.add(s.charAt(i));
        }
        List<Character> resultList = new CopyOnWriteArrayList<>();
        for (int j = 0;j<t.length();j ++)  {
            resultList.add(t.charAt(j));
        }

        Random random = new Random();
        for (int j = 0;j<resultList.size();j++) {
            Character cc = resultList.get(j);
            if (sSet.contains(cc)) {
                int index = random.nextInt(resultList.size());
                Character rc =
                resultList.remove(j);
                resultList.add(index,cc);
            }
        }
        StringBuilder sb = new StringBuilder();
        resultList.forEach(cc ->{
            sb.append(cc);
        });
        return sb.toString();
    }

    public static void main(String[] args) {
        NewString ns = new NewString();
        String t = "bcaaedf";
        String s = "eabdf";
        System.out.println("t1="+ns.getT1(t,s));
    }
}
