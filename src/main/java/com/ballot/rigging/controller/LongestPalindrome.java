package com.ballot.rigging.controller;

import com.ballot.rigging.pojo.Automaton;
import com.ballot.rigging.pojo.ListNode;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: wkd
 */
@RestController
public class LongestPalindrome {

    /**
     * 两数之和 一次遍历map解法
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] arr = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int j = 0; j < nums.length; j++) {
            int cha = target - nums[j];
            if (map.containsKey(cha) && map.get(cha) != j) {
                return new int[]{map.get(cha), j};
            }
            map.put(nums[j], j);
        }
        return arr;

    }

    /**
     * 两数相加
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode headNode = new ListNode(0);
        ListNode ler1 = l1, ler2 = l2, pointer = headNode;
        //进位
        int carry = 0;
        while (ler1 != null || ler2 != null) {
            int x = ler1 != null ? ler1.val : 0;
            int y = ler2 != null ? ler2.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            pointer.next = new ListNode(sum % 10);
            pointer = pointer.next;

            if (ler1 != null) {
                ler1 = ler1.next;
            }
            if (ler2 != null) {
                ler2 = ler2.next;
            }
        }

        if (carry > 0) {
            pointer.next = new ListNode(carry);
        }
        return headNode.next;
    }

    /**
     * 无重复字符的最长子串  滑动窗口
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        char[] charArray = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int start = 0;
        for (int end = 0; end < s.length(); end++) {
            //charArray也可以换成在这里使用 s.charAt(end)
            char ch = charArray[end];
            if (map.containsKey(ch)) {
                start = Math.max(map.get(ch), start);
            }
            max = Math.max(max, end - start + 1);
            // end+1 是发现重复后要减去的长度
            map.put(ch, end + 1);
        }
        return max;
    }

    /**
     * 动态规划法 最长回文子串
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int length = s.length();
        boolean[][] booleans = new boolean[length][length];
        String result = "";
        for (int line = 0; line < length; ++line) {
            for (int row = 0; row + line < length; ++row) {
                int area = row + line;
                boolean boo = s.charAt(row) == s.charAt(area);
                if (line == 0) {
                    booleans[row][area] = true;
                } else if (line == 1) {
                    booleans[row][area] = boo;
                } else {
                    booleans[row][area] = (boo && booleans[row + 1][area - 1]);
                }
                if (booleans[row][area] && line + 1 > result.length()) {
                    result = s.substring(row, row + line + 1);
                }
            }
        }
        return result;
    }

    /**
     * 中心拓展算法 最长回文子串
     *
     * @param s
     * @return
     */
    public String longestPalindrome2(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return right - left - 1;
    }

    /**
     * z字变形
     *
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            rows.add(new StringBuilder());
        }
        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) {
                goingDown = !goingDown;
            }
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) {
            ret.append(row);
        }
        return ret.toString();
    }

    /**
     * z字变形 根据规律得出计算公式
     * @param s
     * @param numRows
     * @return
     */
    public String convert2(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder ret = new StringBuilder();
        int length = s.length();
        int cycleLen = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < length; j += cycleLen) {
                ret.append(s.charAt(j + i));
                //i 不能是第一行  也不能是最后一行  长度不能超过字符串长度
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < length) {
                    ret.append(s.charAt(j + cycleLen - i));
                }
            }
        }
        return ret.toString();
    }


    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            // 7 是 Integer.MAX_VALUE%10 的余数   -8是Integer.MIN_VALUE % 10
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            rev = rev * 10 + pop;
        }
        return rev;
    }

    public int myAtoi(String str) {
        Automaton automaton = new Automaton();
        int length = str.length();
        for (int i = 0; i < length; ++i) {
            automaton.get(str.charAt(i));
        }
        return (int) (automaton.sign * automaton.ans);
    }

    public int myAtoi2(String str) {
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }
        if (!Character.isDigit(str.charAt(0)) && str.charAt(0) != '-' && str.charAt(0) != '+') {
            return 0;
        }
        long ans = 0L;
        boolean neg = str.charAt(0) == '-';
        int i = !Character.isDigit(str.charAt(0)) ? 1 : 0;
        while (i < str.length() && Character.isDigit(str.charAt(i))) {
            ans = ans * 10 + (str.charAt(i++) - '0');
            if (!neg && ans > Integer.MAX_VALUE) {
                ans = Integer.MAX_VALUE;
                break;
            }
            if (neg && ans > 1L + Integer.MAX_VALUE) {
                ans = 1L + Integer.MAX_VALUE;
                break;
            }
        }
        return neg ? (int) -ans : (int) ans;
    }


}
