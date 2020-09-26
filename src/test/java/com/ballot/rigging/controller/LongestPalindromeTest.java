package com.ballot.rigging.controller;

import com.ballot.rigging.RiggingApplicationTests;
import com.ballot.rigging.pojo.ListNode;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

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
        String zString2 = longestPalindrome.convert2("LEETCODEISHIRING", 3);
        System.out.println(zString);
        System.out.println(zString2);
    }

    @Test
    public void reverse() {
        int reverse = longestPalindrome.reverse(120);
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
        int result2 = longestPalindrome.lengthOfLongestSubstring("dafageggafda");
        System.out.println(result2);
    }
}