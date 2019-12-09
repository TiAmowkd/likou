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
    private SolutionController solutionController;

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
        ListNode result = solutionController.addTwoNumbers(l1, l2);
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
        int result = solutionController.lengthOfLongestSubstring(str);
        System.out.println(result);
        int result2 = solutionController.lengthOfLongestSubstring2(str);
        System.out.println(result2);
    }

    @Test
    public void reverse() {
        int a = -123;
        int result = solutionController.reverse(a);
        System.out.println(result);
    }
}