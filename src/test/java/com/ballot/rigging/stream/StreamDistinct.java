package com.ballot.rigging.stream;

import com.ballot.rigging.pojo.Book;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @Auther: wkd
 * @Date: 2019/12/26 11:28
 * @Description:
 */
public class StreamDistinct {

    @Test
    public void StreamDistinctTest() {
        List<String> list = Arrays.asList("AA", "GG", "BB", "CC", "BB", "CC", "AA", "AA");
        long l = list.stream().distinct().count();
        System.out.println("No. of distinct elements:" + l);
        String output = list.stream().distinct().collect(Collectors.joining(","));
        System.out.println(output);
        List<String> listStreamResult = list.stream().sorted(Comparator.comparing(String::toString))
                .distinct().collect(Collectors.toList());
        System.out.println(listStreamResult);
    }

    @Test
    public void StreamDistinctTargetTest() {
        List<Book> list = new ArrayList<>();
        {
            list.add(new Book("Core Java", 200));
            list.add(new Book("Core Java", 300));
            list.add(new Book("Learning Freemarker", 150));
            list.add(new Book("Spring MVC", 200));
            list.add(new Book("Hibernate", 300));
        }
        list.stream().filter(distinctByKey(b -> b.getName()))
                .forEach(b -> System.out.println(b.getName() + "," + b.getPrice()));
    }


    static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
        //如果keyExtractor.apply(t)第一次出现则绑定一个值，返回null，若已绑定则返回值
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }
}
