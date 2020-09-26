package com.ballot.rigging.controller;

import com.ballot.rigging.enums.SkuCategoryEnum;
import com.ballot.rigging.enums.TestEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.annotation.Timed;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author: wkd
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Component
public class ThreadTest {

    @Test
    public void setTest() {
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = Collections.synchronizedSet(new HashSet<>());
        Set<String> set3 = new CopyOnWriteArraySet<>();
    }

    @Test
    public void listTest() {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = Collections.synchronizedList(new ArrayList<>());
        List<String> list3 = new CopyOnWriteArrayList<>();
    }

    @Test
    public void mapTest() {
        //Hashmap 线程不安全
        Map<String, String> map1 = new HashMap<>();
        Map<String, String> map2 = Collections.synchronizedMap(new HashMap<>());
        Map<String, String> map3 = new ConcurrentHashMap<>();
    }

    @Test
    public void testConstructorInstance() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        TestEnum instance1 = TestEnum.CLOTHING;
        Class<?> clazz = null;
        try {
            clazz = Class.forName("com.ballot.rigging.enums.TestEnum");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Constructor<TestEnum> declaredConstructor = (Constructor<TestEnum>) clazz.getDeclaredConstructor(TestEnum.class);
        declaredConstructor.setAccessible(true);
        TestEnum instance2 = declaredConstructor.newInstance();
// NoSuchMethodException: com.kuang.single.EnumSingle.<init>()
        System.out.println(instance1);
        System.out.println(instance2);
    }

}
