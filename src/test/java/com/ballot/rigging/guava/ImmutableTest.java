package com.ballot.rigging.guava;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Multiset;
import com.google.common.collect.Sets;
import com.google.common.collect.TreeMultiset;
import org.junit.Test;

import java.util.*;

/**
 * 不可变集合用法
 */
public class ImmutableTest {

    private void test(List<Integer> list) {
        list.remove(0);
    }

    @Test
    public void listOperate() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);

        List<Integer> newList =
                Collections.unmodifiableList(list);
        test(newList);

        System.out.println(newList);
    }

    @Test
    public void immutable() {
        List<Integer> list = new ArrayList<Integer>();

        list.add(1);
        list.add(2);
        list.add(3);

        /**
         * 构造不可变集合对象三种方式
         */
        // 通过已经存在的集合创建
        ImmutableSet<Integer> integers = ImmutableSet.copyOf(list);

        // 通过初始值，直接创建不可变集合
        ImmutableSet immutableSet =
                ImmutableSet.of(1, 2, 3);

        /*Map<String,Integer> map = new HashMap<>();
        map.entrySet();
        map.keySet();
*/

        // 以builder方式创建
        ImmutableSet<Object> build = ImmutableSet.builder()
                .add(1)
                .addAll(Sets.newHashSet(2, 3))
                .add(4)
                .build();

    }

}
