package com.ballot.rigging.guava;

import com.ballot.rigging.pojo.Book;
import org.junit.Test;

import java.util.Optional;

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

}
