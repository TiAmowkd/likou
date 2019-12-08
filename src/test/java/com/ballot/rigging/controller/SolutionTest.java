package com.ballot.rigging.controller;

import com.ballot.rigging.pojo.ListNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Component
public class SolutionTest {
    @Autowired
    private Solution solution;

    @Test
    public void addTwoNumbers() {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(5);
        ListNode l3 = new ListNode(4);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(6);
        ListNode l6 = new ListNode(4);
        l1.next = l3;
        l3.next = l4;
        l2.next = l5;
        l5.next = l6;
        ListNode result = solution.addTwoNumbers(l1, l2);
//        ListNode result2 = solution.addTwoNumbers2(l1, l2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    @Test
    public void lengthOfLongestSubstring() {
        //abcbbcbb abcaaccb
        String str = "abcaabhgcb";
        int result = solution.lengthOfLongestSubstring(str);
        System.out.println(result);
        int result2 = solution.lengthOfLongestSubstring2(str);
        System.out.println(result2);
    }

    @Test
    public void reverse() {
        int a = -123;
        int result = solution.reverse(a);
        System.out.println(result);
    }

    @Test
    public void findMedianSortedArrays() {
//        int[] nums1 = new int[]{1, 3};
//        int[] nums2 = new int[]{2};
        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{3, 4};
        double result = solution.findMedianSortedArrays2(nums1,nums2);
//        double result = solution.findMedianSortedArrays(nums1,nums2);
        System.out.println(result);

        Integer integer = 2;
        integer = 3;
        System.out.println(integer);
    }
}