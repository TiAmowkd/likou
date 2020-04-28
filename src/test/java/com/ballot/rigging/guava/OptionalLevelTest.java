package com.ballot.rigging.guava;

import com.ballot.rigging.pojo.Book;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


/**
 * @Auther: wkd
 * @Date: 2019/12/26 18:00
 * @Description: Optional深入理解
 */
public class OptionalLevelTest {

    @Test
    public void whenCheckIfPresent_thenOk() {
        Book book = new Book("john@gmail.com", 1234);
        Optional<Book> opt = Optional.ofNullable(book);
        assertTrue(opt.isPresent());
        assertEquals(book.getName(), opt.get().getName());
        opt.ifPresent(u -> assertEquals(book.getName(), u.getName()));
    }


    @Test
    public void whenEmptyValue_thenReturnDefault() {
        Book book = null;
        Book book2 = new Book("anna@gmail.com", 123);
        Book result = Optional.ofNullable(book).orElse(book2);
        assertEquals(book2.getName(), result.getName());

    }

    @Test
    public void whenValueNotNull_thenIgnoreDefault() {
        Book Book = new Book("john@gmail.com", 1234);
        Book Book2 = new Book("anna@gmail.com", 1234);
        Book result = Optional.ofNullable(Book).orElse(Book2);
        assertEquals("john@gmail.com", result.getName());
    }


    @Test
    public void whenEmptyValue() {
//        Book book = null;
//        这个方法会在值为 null 的时候抛出异常。要避免异常，需要首先验证是否有值
//        Optional<Book> optionalBook = Optional.ofNullable(book);
//        空指针异常
//        System.out.println(optionalBook.get());

        Book newBook = new Book();
        Optional<Book> optionalBook = Optional.ofNullable(newBook);
        System.out.println(optionalBook.get());
        System.out.println(optionalBook.get().getName());
        optionalBook.ifPresent(u -> System.out.println(u.getName()));

       /* newBook为null 不执行u -> System.out.println(u.getName())
        Book newBook = null;
        Optional<Book> optionalBook = Optional.ofNullable(newBook);
        optionalBook.ifPresent(u -> System.out.println(u.getName()));*/
    }

    @Test
    public void whenMap_thenOk() {
        Book user = new Book("anna@gmail.com", 1234);
        String email = Optional.ofNullable(user)
                .map(u -> u.getName()).orElse("default@gmail.com");
        assertEquals(email, user.getName());

       /*true
        Book user = new Book();
        String email = Optional.ofNullable(user)
                .map(u -> u.getName()).orElse("default@gmail.com");
        assertEquals(email, "default@gmail.com");*/

        //true
        Book user2 = new Book("anna@gmail.com", 1234);
        String email2 = Optional.ofNullable(user2)
                .map(u -> u.getName()).orElse("default@gmail.com");
        Optional<String> stringOptional = Optional.ofNullable(user2).map(u -> u.getName());


    }

    @Test
    public void whenMap_Optional() {
//        java.util.NoSuchElementException: No value present
//        Book user2 = null;

//        true
        Book user2 = new Book("anna@gmail.com", 1234);
//        java.util.NoSuchElementException: No value present
//        Book user2 = new Book();
        Optional<String> stringOptional = Optional.ofNullable(user2).map(u -> u.getName());
        String s = stringOptional.get();
        System.out.println(s);

    }

    @Test
    public void whenMap_BookList() {
        Book book = new Book();
        book.setName("aa");
        List<Book> list = new ArrayList<>();
        list.add(new Book("无人机", 4999));
        list.add(new Book("eeeee", 999));
        list.add(new Book("aede机", 495499));
        list.add(new Book("eefr机", 4899));
        list.add(book);
        Optional<List<String>> listStringOptional = Optional.ofNullable(list).
                map(u -> u.stream().map(x -> x.getName()).collect(Collectors.toList()));
        List<String> strings = listStringOptional.get();
        System.out.println(strings);

        //jdk9 Optional.stream()
        // 注意idea编译环境也要切换为9
        // setting ->Build、Execution、Deployment -> Compiler -> Java Compiler
//        listStringOptional.stream().forEach(x->x.stream().forEach(u-> System.out.println(u)));

    }

    /**
     * Optional 使用stream操作
     */
    @Test
    public void Optional_ListString() {
        List<String> list = new ArrayList<>();
        list.add("xxx1");
        list.add("xxx2");
        list.add("xxx3");

        Optional<List<String>> optional = Optional.ofNullable(list);
        optional.stream()//optional 可以转为stream
                .forEachOrdered(x -> x.stream().forEach(y -> System.out.println(y)));

        list.add("yyy1");
        Optional<List<String>> optional2 = Optional.ofNullable(list);
        optional2.stream()
                .flatMap(x -> x.stream())//optional 扁平化
                .forEach(System.out::println);
    }

    /**
     * 用Optional处理List为null，不报错
     */
    @Test
    public void Optional_NullList() {
        List<String> list = null;

        Optional<List<String>> optional = Optional.ofNullable(list);
        optional.stream()//optional 可以转为stream
                .forEachOrdered(x -> x.stream().forEach(y -> System.out.println(y)));
        optional.stream()
                .flatMap(x -> x.stream())//optional 扁平化
                .forEach(System.out::println);

    }


}
