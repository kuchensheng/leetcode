package cn.com.leetcode.simple;

import java.util.*;

/**
 * Desription:
 *
 * @author:Hui CreateDate:2019/4/14 21:03
 * version 1.0
 */
public class StringMatchTest {

    private static Map<Character,Character> pair = null;
    static {
        pair = new HashMap<>();
        pair.put('(',')');
        pair.put('{','}');
        pair.put('[',']');
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(isMatcht(s));
    }

    private static boolean isMatcht(String s) {
        System.out.println("接收到字符串："+s);
        Stack<Character> sc = new Stack<>();
        for (int i=0;i<s.length();i++) {
            Character character = s.charAt(i);
            if(pair.containsKey(character)) {
                //放入栈中
                sc.push(character);
            } else if (pair.containsValue(character)) {
                if(sc.empty()) {
                    return false;
                }
                //栈不为空
                if(sc.peek().equals(pair.get(character))) {
                    sc.pop();
                } else {
                    return false;
                }
            }
        }
        return sc.empty() ? true : false;
    }
}
