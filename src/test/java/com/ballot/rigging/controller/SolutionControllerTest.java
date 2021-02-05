package com.ballot.rigging.controller;

import com.ballot.rigging.RiggingApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class SolutionControllerTest extends RiggingApplicationTests {
    @Autowired
    private SolutionController solutionController;

    @Test
    public void findMedianSortedArrays3() {
        int[] nums1 = new int[]{1, 2, 6, 8, 9, 10};
        int[] nums2 = new int[]{3, 4, 5};
        double medianSortedArrays3 = solutionController.findMedianSortedArrays3(nums1, nums2);
        double medianSortedArrays2 = solutionController.findMedianSortedArrays(nums1, nums2);
        System.out.println(medianSortedArrays3);
    }

    @Test
    public void ff(){
        System.out.println(1L + Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);

    }
}