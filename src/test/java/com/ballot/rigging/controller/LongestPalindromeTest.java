package com.ballot.rigging.controller;

import com.ballot.rigging.RiggingApplicationTests;
import com.ballot.rigging.pojo.ListNode;
import com.ballot.rigging.pojo.ListNode2;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class LongestPalindromeTest extends RiggingApplicationTests {
    @Autowired
    private LongestPalindrome longestPalindrome;

    @Test
    public void addTwoNumbers() {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(5);
        ListNode l3 = new ListNode(4);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(6);
        ListNode l6 = new ListNode(4);
        ListNode l7 = new ListNode(4);
        l1.next = l3;
        l3.next = l4;
        l2.next = l5;
        l5.next = l6;
        l6.next = l7;
        ListNode result = longestPalindrome.addTwoNumbers(l1, l2);
//        ListNode result2 = solution.addTwoNumbers2(l1, l2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    @Test
    public void longestPalindrome() {
        String s = "babad";
        String ans = longestPalindrome.longestPalindrome(s);
        String ans2 = longestPalindrome.longestPalindrome2(s);
        System.out.println(ans);
        System.out.println(ans2);
    }

    @Test
    public void convert() {
        String zString = longestPalindrome.convert("LEETCODEISHIRING", 3);
        String zString2 = longestPalindrome.convert2("PAYPALISHIRING", 3);
        System.out.println(zString);
        System.out.println(zString2);
    }

    @Test
    public void reverse() {
        int reverse = longestPalindrome.reverse(-120);
        System.out.println(reverse);

    }

    @Test
    public void myAtoi() {
        int i = longestPalindrome.myAtoi("1234 efa");
        System.out.println(i);
        int i2 = longestPalindrome.myAtoi2("1234 efa");
        System.out.println(i2);
    }

    @Test
    public void twoSum() {
        int[] ints = longestPalindrome.twoSum(new int[]{3, 3, 6, 7, 8, 9}, 6);
        System.out.println(ints[0] + " " + ints[1]);
    }


    @Test
    public void lengthOfLongestSubstring() {
        int result2 = longestPalindrome.lengthOfLongestSubstring("abcabacbb");
        System.out.println(result2);
    }

    @Test
    public void isMatch() {
        longestPalindrome.isMatch("mississippi", "mis*is*p*.");
        isMatch("mississippi", "mis*is*p*.");
    }

    public boolean isMatch(String s, String p) {
        if (p.length() <= 0) return s.length() <= 0;
        boolean match = (s.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.'));
        if (p.length() > 1 && p.charAt(1) == '*') {
            return isMatch(s, p.substring(2)) || (match && isMatch(s.substring(1), p));
        } else {
            return match && isMatch(s.substring(1), p.substring(1));
        }
    }

    @Test
    public void maxArea() {
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        int start = 0, end = height.length - 1;
        int max = 0;
        while (start < end) {
            int min = Math.min(height[start], height[end]);
            int sum = min * (end - start);
            max = Math.max(max, sum);
            if ((min == height[start])) {
                start++;
            } else {
                end--;
            }
        }
        System.out.println(max);
//        return max;

    }

    @Test
    public void intToRoman() {
        longestPalindrome.intToRoman(671);
    }

    @Test
    public void romanToInt() {
        int number = longestPalindrome.romanToInt("III");
        System.out.println(number);
    }

    @Test
    public void longestCommonPrefix() {
        String[] strings = new String[]{""};
        String s = longestPalindrome.longestCommonPrefix(strings);
        System.out.println(s);
    }

    @Test
    public void threeSum() {
        longestPalindrome.threeSum(new int[]{0, 0, 0});
    }

    @Test
    public void threeSumClosest() {
        int i = longestPalindrome.threeSumClosest(new int[]{1,1,-1,-1,3}, -1);
        System.out.println(i);
    }

    @Test
    public void letterCombinations() {
        List<String> strings = longestPalindrome.letterCombinations("2475");
        System.out.println(strings.toString());
    }

    @Test
    public void removeNthFromEnd() {
        ListNode2 l1 = new ListNode2(1);
        ListNode2 l2 = new ListNode2(2);
        ListNode2 l3 = new ListNode2(3);
        ListNode2 l4 = new ListNode2(4);
        ListNode2 l5 = new ListNode2(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        ListNode2 result = longestPalindrome.removeNthFromEnd(l1, 2);
//        ListNode2 result2 = longestPalindrome.removeNthFromEnd2(l1, 2);
//        ListNode2 result3 = longestPalindrome.removeNthFromEnd3(l1, 2);
//        ListNode result2 = solution.addTwoNumbers2(l1, l2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}