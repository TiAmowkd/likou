package com.ballot.rigging.controller;

import com.ballot.rigging.RiggingApplicationTests;
import com.ballot.rigging.pojo.ListNode;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class LeetCode20_30Test extends RiggingApplicationTests {
    @Autowired
    private LeetCode20_30 leetCode;

    @Test
    public void isValid() {
        boolean valid = leetCode.isValid("([{}])");
        System.out.println(valid);
    }

    @Test
    public void mergeTwoLists() {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(4);
        ListNode l4 = new ListNode(6);

        ListNode l5 = new ListNode(1);
        ListNode l6 = new ListNode(8);
        ListNode l7 = new ListNode(9);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;

        l5.next = l6;
        l6.next = l7;

        leetCode.mergeTwoLists(l1, l5);
    }

    @Test
    public void generateParenthesis() {
        leetCode.generateParenthesis(3);
    }

    @Test
    public void swapPairs() {

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(4);
//        ListNode l4 = new ListNode(6);
        l1.next = l2;
        l2.next = l3;
//        l3.next = l4;
        leetCode.swapPairs(l1);
    }

    @Test
    public void strStr() {
        leetCode.strStr("hello", "ll");
    }

    @Test
    public void removeElement() {
        int[] nums = new int[]{1, 1, 2, 3, 4, 6};
        int i = leetCode.removeElement(nums, 1);
        System.out.println(i);
    }

    @Test
    public void removeDuplicates() {
        int[] ints = new int[]{1, 1, 2};
        leetCode.removeDuplicates2(ints);
    }
}