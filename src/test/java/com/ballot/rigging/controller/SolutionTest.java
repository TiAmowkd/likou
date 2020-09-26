package com.ballot.rigging.controller;

import com.ballot.rigging.pojo.ListNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@RunWith(SpringRunner.class)
@SpringBootTest
@Component
public class SolutionTest {
    @Autowired
    private SolutionController solutionController;

    @Test
    public void lengthOfLongestSubstring() {
        //abcbbcbb abcaaccb
        String str = "dafageggafda";
        int result = solutionController.lengthOfLongestSubstring(str);
        System.out.println(result);
    }


    @Test
    public void findMedianSortedArrays() {
//        int[] nums1 = new int[]{1, 3};
//        int[] nums2 = new int[]{2};
        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{3, 4};
        double result = solutionController.findMedianSortedArrays2(nums1, nums2);
//        double result = solution.findMedianSortedArrays(nums1,nums2);
        System.out.println(result);

        Integer integer = 2;
        integer = 3;
        System.out.println(integer);
    }

    @Test
    public void testCpuNumber() {
        // 获取cpu的核数
        System.out.println(Runtime.getRuntime().availableProcessors());
    }

    @Test
    public void testThread() {
        Data2 data = new Data2();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "C").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "D").start();
    }

    @Test
    public void testThread2() {
        Data2 data = new Data2();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "C").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "D").start();
    }


}

// 判断等待，业务，通知
class Data2 { // 数字 资源类
    private int number = 0;
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    //condition.await(); // 等待
    // condition.signalAll(); // 唤醒全部
    // +1
    public void increment() throws InterruptedException {
        lock.lock();
        try {
            // 业务代码
            while (number != 0) { //0
                // 等待
                condition.await();
            }
            number++;
            System.out.println(Thread.currentThread().getName() + "=>" + number);
            // 通知其他线程，我+1完毕了
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    } //-1

    public synchronized void decrement() throws InterruptedException {
        lock.lock();
        try {
            while (number == 0) { // 1
                // 等待
                condition.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName() + "=>" + number);
            // 通知其他线程，我-1完毕了
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}